package org.apache.spark.sql.execution.datasources.http

import constant.ConstantPath
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.parquet.example.data.Group
import org.apache.parquet.hadoop.ParquetReader
import org.apache.parquet.hadoop.example.GroupReadSupport
import org.apache.parquet.schema.{MessageType, MessageTypeParser}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.{GenericInternalRow, SpecificInternalRow}
import org.apache.spark.sql.execution.datasources.PartitionedFile
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.spark.sql.types.StructType
import org.apache.spark.unsafe.types.UTF8String
import org.apache.spark.util.SerializableConfiguration
import org.apache.spark.{Partition, SparkContext, TaskContext}
import com.alibaba.fastjson.{JSON, JSONObject}
import org.apache.spark.sql.types._

object HTTPMoveDataRDD {

  def scanTable(sc: SparkContext,
                schema: StructType,
                parts: Array[Partition],
                serHadoopConf: SerializableConfiguration,
                httpOptions: HttpOptions): RDD[InternalRow] = {
    new HTTPMoveDataRDD(sc,
      schema,
      parts,
      serHadoopConf,
      httpOptions)
  }
}

private[http] class HTTPMoveDataRDD(@transient sc: SparkContext,
                                    schema: StructType,
                                    partitions: Array[Partition],
                                    serHadoopConf: SerializableConfiguration,
                                    httpOptions: HttpOptions)
  extends RDD[InternalRow](sc, Nil) {

  //
  override def compute(split: Partition, context: TaskContext): Iterator[InternalRow] = {
    val httpUrl = httpOptions.url + "/stream/downloadTempFile"
    val partition = split.asInstanceOf[HTTPMoveDataPartition]
    val writePath = ConstantPath.hdfsPath + "/remote_get" + partition.filePath.split("remote")(1)
    val hadoopConf = serHadoopConf.value

    println(s"Partition ${context.partitionId} ==> source file path ${partition.filePath}")
    println(s"Partition ${context.partitionId} ==> des file path ${writePath}")
    try {
      val params = new JSONObject
      params.put("filePath", partition.filePath)
      val isTransmit = HttpHelper.doPostFormByte(httpUrl, params, writePath)
      if (isTransmit) {
        val filePath = new Path(writePath)
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
          case LongType => group.getLong(field.name, 0)
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
