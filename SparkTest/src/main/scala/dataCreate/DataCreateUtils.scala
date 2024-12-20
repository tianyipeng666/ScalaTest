package dataCreate

import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

import java.io.File
import scala.util.Random

object DataCreateUtils {
  def getDataSample(spark: SparkSession, fileNum: Int, path: String): Unit = {



    // 每行大约 100 字节，500MB 的文件约包含 5,000,000 行
    val numRows = 5000000

    // 随机生成 DataFrame
    val data = spark.sparkContext.parallelize(1 to numRows).map { _ =>
      Row(
        Random.nextInt(1000000).toString,
        Random.alphanumeric.take(10).mkString,
        (Random.nextDouble() * 1000).toString,
        Random.alphanumeric.take(5).mkString
      )
    }

    val schema = StructType(Seq(
      StructField("field1", StringType, nullable = false),
      StructField("field2", StringType, nullable = false),
      StructField("field3", StringType, nullable = false),
      StructField("field4", StringType, nullable = false)
    ))

    val df = spark.createDataFrame(data, schema)

    // 保存到四个 500MB 的文件
    for (i <- 1 to fileNum) {
      val outputPath = s"${path}/sample_file_$i.csv"
      df.coalesce(1)
        .write
        .mode(SaveMode.Overwrite)
        .option("header", "true") // 包含列名
        .csv(outputPath)
      println(s"Generated file: $outputPath")
    }

    spark.stop()
  }
}
