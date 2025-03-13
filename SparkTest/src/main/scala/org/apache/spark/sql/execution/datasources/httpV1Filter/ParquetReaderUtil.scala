package org.apache.spark.sql.execution.datasources.httpV1Filter

import log.LazyLogging
import org.apache.hadoop.conf.Configuration
import org.apache.parquet.example.data.Group
import org.apache.parquet.schema.{MessageType, MessageTypeParser}
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.GenericInternalRow
import org.apache.spark.sql.execution.datasources.PartitionedFile
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.spark.sql.types.{BooleanType, DoubleType, FloatType, IntegerType, LongType, StringType, StructType}
import org.apache.spark.unsafe.types.UTF8String
import org.apache.spark.sql.catalyst.expressions.GenericInternalRow
import org.apache.spark.sql.execution.datasources.PartitionedFile
import org.apache.spark.sql.execution.datasources.parquet.ParquetFileFormat
import org.apache.parquet.example.data.Group
import org.apache.parquet.hadoop.ParquetReader
import org.apache.parquet.hadoop.example.GroupReadSupport
import org.apache.parquet.schema.{MessageType, MessageTypeParser}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.sql.Row

object ParquetReaderUtil extends LazyLogging {

  def getParquetMessage(hadoopConf:Configuration, filePath:Path, schema:StructType): Iterator[Row] = {
    // 读取
    val parquetReader = ParquetReader.builder[Group](new GroupReadSupport(), filePath)
      .withConf(hadoopConf)
      .build()
    new Iterator[Row] {
      private var nextRecord: Group = parquetReader.read()

      override def hasNext: Boolean = nextRecord != null

      override def next(): Row = {
        if (nextRecord == null) {
          throw new NoSuchElementException("No more records")
        }
        // println(s"nextRecord before conversion: $nextRecord")
        val row = convertGroupToRow(nextRecord, schema)
        // println(s"Converted row => $row")
        nextRecord = parquetReader.read()
        // println(s"nextRecord after read => $nextRecord")
        row
      }

      override def finalize(): Unit = parquetReader.close()
    }
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

  private def convertGroupToRow(group: Group, schema: StructType): Row = {
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
    Row.fromSeq(values)
  }

}
