import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.{GetListGenericUDF, GetListUDF}
import bean.Person
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName

import java.io.File
import java.lang.String
import java.util
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object SparkMain {

  val macOSPath = "file:///Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/testFiles/test.xlsx"
  // val windowsPath = "D:\\项目\\idea\\idea-project\\ScalaTest\\SparkTest\\files"
  val desPath = "file:///Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/desFiles"
  val hdfsPath = "hdfs://hdcluster/excel/externalExcel2"


  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    SparkExcelUtil.previewExcel(session, macOSPath)
    // hive建表
    // HiveUtil.createTableAndRefresh(session, hdfsPath, SparkExcelUtil.previewExcel(session, macOSPath), "TestExcel3")

  }
}

