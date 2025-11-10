package dataCreate

import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

import java.io.File
import scala.util.Random

object DataCreateUtils {
  def getDataSampleCsv(spark: SparkSession, fileNum: Int, path: String, tableName: String): Unit = {

    val numRows = 100000

    // 随机生成 DataFrame
    val data = spark.sparkContext.parallelize(1 to numRows).map { _ =>
      Row(
        Random.nextInt(1000000).toString,
        Random.alphanumeric.take(10).mkString,
        (Random.nextDouble() * 1000).toString,
        Random.alphanumeric.take(10).mkString
      )
    }

    val schema = StructType(Seq(
      StructField("field1", StringType, nullable = false),
      StructField("field2", StringType, nullable = false),
      StructField("field3", StringType, nullable = false),
      StructField("field4", StringType, nullable = false)
    ))

    val df = spark.createDataFrame(data, schema)

    // 保存fileNum个文件
    for (i <- 1 to fileNum) {
      val outputPath = s"${path}/${tableName}"
      df.coalesce(1)
        .write
        .mode(SaveMode.Append)
        .option("header", "true") // 包含列名
        .csv(outputPath)
      println(s"Generated file: ${outputPath}_${i}")
    }

    spark.sql(
      s"""
         |CREATE TABLE `typ`.`$tableName` (
         |  field1 STRING,
         |  field2 STRING,
         |  field3 STRING,
         |  field4 STRING
         |)
         |USING csv
         |OPTIONS (
         |  header 'true',
         |  inferSchema 'false',
         |  recursiveFileLookup 'true'
         |)
         |LOCATION '$path/${tableName}'
         |""".stripMargin)

    // spark.sql(s"ALTER TABLE `typ`.`$tableName` SET LOCATION '$path/${tableName}'")

    val cnt = spark.table(s"`typ`.`$tableName`").count()
    println(s"Table `typ`.`$tableName` is ready. Row count = $cnt")

    spark.stop()
  }

  def getDataSampleParquet(spark: SparkSession, fileNum: Int, path: String, tableName: String): Unit = {

    val numRows = 500000

    val data = spark.sparkContext.parallelize(1 to numRows).map { _ =>
      Row(
        Random.nextInt(1000000).toString,
        Random.alphanumeric.take(10).mkString,
        (Random.nextDouble() * 1000).toString,
        Random.alphanumeric.take(10).mkString
      )
    }

    val schema = StructType(Seq(
      StructField("field1", StringType, nullable = false),
      StructField("field2", StringType, nullable = false),
      StructField("field3", StringType, nullable = false),
      StructField("field4", StringType, nullable = false)
    ))

    val df = spark.createDataFrame(data, schema)

    // 写 parquet（不需要 header 之类的选项）
    for (i <- 1 to fileNum) {
      val outputPath = s"$path/$tableName"
      df.coalesce(1)
        .write
        .mode(SaveMode.Append)
        .option("compression", "snappy") // 可选：压缩
        .parquet(outputPath)
      println(s"Generated file: ${outputPath}_$i")
    }

    // 用 Parquet 建表（外部表）
    spark.sql(
      s"""
         |CREATE TABLE IF NOT EXISTS `typ`.`$tableName` (
         |  field1 STRING,
         |  field2 STRING,
         |  field3 STRING,
         |  field4 STRING
         |)
         |USING parquet
         |OPTIONS (
         |  compression 'snappy'
         |)
         |LOCATION '$path/$tableName'
         |""".stripMargin)

    val cnt = spark.table(s"`typ`.`$tableName`").count()
    println(s"Table `typ`.`$tableName` is ready. Row count = $cnt")

    spark.stop()
  }
}
