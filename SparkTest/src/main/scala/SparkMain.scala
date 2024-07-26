import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.Person
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import redis.RedisServices

object SparkMain {

  val macOSPath = "file:///Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/testFiles/20240713/test.xlsx"
  // val windowsPath = "D:\\项目\\idea\\idea-project\\ScalaTest\\SparkTest\\files"
  val desPath = "file:///Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/desFiles"
  val hdfsPath = "hdfs://hdcluster/bdp/ftp_tmp/dfed602e4ad94d89832be33324e73b4f_excel/test_excel_07222124.xlsx"


  def main(args: Array[String]): Unit = {
//    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
//    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    redisDispose()
  }

  private def excelDispose(session: SparkSession): Unit = {
    // excel
    SparkExcelUtil.previewExcel(session, hdfsPath)
  }

  private def udfDispose(session: SparkSession): Unit = {
    // udf
    UdfRegister.udfArray(session, UdfRegister.getClazz())
  }

  private def hiveDispose(session: SparkSession): Unit = {
    // hive建表
    // HiveUtil.createTableAndRefresh(session, hdfsPath, SparkExcelUtil.previewExcel(session, macOSPath), "TestExcel3")
    HiveUtil.createTableTest(session, hdfsPath, "TestExcelCsv4", 13)
  }

  private def ftpDispose(): Unit = {
    val client = FtpUtils.getConnect("123.126.105.70", 21, "share", "haizhi1234")
    println(FtpUtils.checkRootPathFile("/typ/excelUpload/test.xlsx", client))
  }

  private def redisDispose(): Unit = {
    RedisServices.checkConnection()
  }
}

