import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.Person
import constant.ConstantPath
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import redis.RedisServices

object SparkMain {


  def main(args: Array[String]): Unit = {
    //    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
    //    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    redisDispose()
  }

  private def excelDispose(session: SparkSession): Unit = {
    // excel
    SparkExcelUtil.previewExcel(session, ConstantPath.hdfsPath)
  }

  private def udfDispose(session: SparkSession): Unit = {
    // udf
    UdfRegister.udfArray(session, UdfRegister.getClazz())
  }

  private def hiveDispose(session: SparkSession): Unit = {
    // hive建表
    // HiveUtil.createTableAndRefresh(session, hdfsPath, SparkExcelUtil.previewExcel(session, macOSPath), "TestExcel3")
    HiveUtil.createTableTest(session, ConstantPath.hdfsPath, "TestExcelCsv4", 13)
  }

  private def ftpDispose(): Unit = {
    val client = FtpUtils.getConnect("123.126.105.70", 21, "share", "haizhi1234")
    println(FtpUtils.checkRootPathFile("/typ/excelUpload/test.xlsx", client))
  }

  private def redisDispose(): Unit = {
    // redis连通性测试
    println(RedisServices.checkConnection())
  }
}

