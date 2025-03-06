package org.apache.spark.sql.execution.datasources.httpV1Filter

import com.alibaba.fastjson.JSONObject
import constant.ConstantPath
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.parquet.example.data.Group
import org.apache.parquet.hadoop.ParquetReader
import org.apache.parquet.hadoop.example.GroupReadSupport
import org.apache.parquet.schema.{MessageType, MessageTypeParser}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.GenericInternalRow
import org.apache.spark.sql.execution.datasources.PartitionedFile
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String
import org.apache.spark.util.SerializableConfiguration
import org.apache.spark.{Partition, SparkContext, TaskContext}

object HTTPMoveDataRDD {

  def scanTable(sc: SparkContext,
                schema: StructType,
                requiredColumns: Array[String],
                parts: Array[Partition],
                serHadoopConf: SerializableConfiguration,
                httpOptions: HttpOptions): RDD[InternalRow] = {
    new HTTPMoveDataRDD(sc,
      pruneSchema(schema, requiredColumns),
      parts,
      serHadoopConf,
      httpOptions)
  }

  /**
   * Prune all but the specified columns from the specified Catalyst schema.
   *
   * @param schema  - The Catalyst schema of the master table
   * @param columns - The list of desired columns
   * @return A Catalyst schema corresponding to columns in the given order.
   */
  private def pruneSchema(schema: StructType, columns: Array[String]): StructType = {
    val fieldMap = Map(schema.fields.map(x => x.name -> x): _*)
    new StructType(columns.map(name => fieldMap(name)))
  }
}

private[httpV1Filter] class HTTPMoveDataRDD(@transient sc: SparkContext,
                                      schema: StructType,
                                      partitions: Array[Partition],
                                      serHadoopConf: SerializableConfiguration,
                                      httpOptions: HttpOptions)
  extends RDD[InternalRow](sc, Nil) {

  //
  override def compute(split: Partition, context: TaskContext): Iterator[InternalRow] = {
    val httpUrl = httpOptions.url + "/stream/downloadTempFile"
    val partition = split.asInstanceOf[HTTPMoveDataPartition]
    // local模式没有问题，但是非local模式会报读取不到，通封装在case class中，通过参数传进来可解决
    val writePath = ConstantPath.hdfsPath + "/remote_get" + partition.filePath.split("remote")(1)
    val hadoopConf = serHadoopConf.value

    println(s"Partition ${context.partitionId} ==> source file path ${partition.filePath}")
    println(s"Partition ${context.partitionId} ==> des file path ${writePath}")
    println(s"${schema.fields.mkString(",")}")
    try {
      val params = new JSONObject
      params.put("filePath", partition.filePath)
      val isTransmit = HttpHelper.doPostFormByte(httpUrl, params, writePath)
      if (isTransmit) {
        val filePath = new Path(writePath)

        // 读取
        val parquetReader = ParquetReader.builder[Group](new GroupReadSupport(), filePath)
          .withConf(hadoopConf)
          .build()
        new Iterator[InternalRow] {
          private var nextRecord: Group = parquetReader.read()

          override def hasNext: Boolean = nextRecord != null

          override def next(): InternalRow = {
            if (nextRecord == null) throw new NoSuchElementException("No more records")
            val row = convertGroupToInternalRow(nextRecord, schema)
            nextRecord = parquetReader.read()
            row
          }

          override def finalize(): Unit = parquetReader.close()
        }
      } else {
        null
      }
    } catch {
      case exception: Exception => throw exception
    } finally {
      // 清除文件
      val fs = FileSystem.get(hadoopConf)
      val path = new Path(writePath)
      if (fs.exists(path)) {
        fs.delete(path, true)
      }
      removeTempData(partition.filePath)
    }
  }

  private def removeTempData(path: String): Boolean = {
    val httpUrl = httpOptions.url + "/db/removeTempData"
    val params = new JSONObject
    params.put("filePath", path)
    val data = HttpHelper.doPostForm(httpUrl, params)
    if (!data.contains("\"status\" : 0")) {
      throw new Exception(data)
    }
    true
  }

  // 将Spark的类型转换为Parquet的MessageType，该方法未使用
  private def schemaToMessageType(schema: StructType): MessageType = {
    val fields = schema.map { field =>
      field.dataType match {
        case StringType => s"""required binary ${field.name} (UTF8);"""
        case IntegerType => s"""required int32 ${field.name};"""
        case LongType => s"""required int64 ${field.name};"""
        case BooleanType => s"""required boolean ${field.name};"""
        case DoubleType => s"""required double ${field.name};"""
        case FloatType => s"""required float ${field.name};"""
        case _ => throw new IllegalArgumentException(s"Unsupported type: ${field.dataType}")
      }
    }
    val schemaString = fields.mkString("message spark_schema {", "\n", "}")
    MessageTypeParser.parseMessageType(schemaString)
  }

  // 通过sparkSession读取hdfs上的parquet文件并转换为IternalRow，由于SparkSession无法序列化，因此在compute中无法使用
  private def readParquetFileAsIterator(schema: StructType,
                                        file: PartitionedFile,
                                        hadoopConf: Configuration): Iterator[InternalRow] = {
    val format = new ParquetFileFormat()
    val reader = format.buildReaderWithPartitionValues(
      sparkSession = null,
      dataSchema = schema,
      partitionSchema = StructType(Nil),
      requiredSchema = schema,
      filters = Nil,
      options = Map.empty,
      hadoopConf = hadoopConf
    )
    reader(file)
  }

  private def convertGroupToInternalRow(group: Group, schema: StructType): InternalRow = {
    val values = schema.fields.zipWithIndex.map { case (field, index) =>
      if (group.getFieldRepetitionCount(field.name) > 0) {
        field.dataType match {
          case StringType => UTF8String.fromString(group.getBinary(field.name, 0).toStringUsingUTF8)
          case IntegerType => group.getInteger(field.name, 0)
          case LongType =>
            if (field.name.equalsIgnoreCase("count")) {
            val longValue = group.getLong(field.name, 0)
            UTF8String.fromString(longValue.toString)
          } else {
            group.getLong(field.name, 0)
          }
          case BooleanType => group.getBoolean(field.name, 0)
          case DoubleType => group.getDouble(field.name, 0)
          case FloatType => group.getFloat(field.name, 0)
          case _ => null
        }
      } else {
        null
      }
    }
    new GenericInternalRow(values.asInstanceOf[Array[Any]])
  }

  override protected def getPartitions: Array[Partition] = partitions
}
