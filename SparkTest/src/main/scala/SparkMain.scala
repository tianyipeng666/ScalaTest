import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.{EnumBean, Person, SerTestBean}
import constant.ConstantPath
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import json.JsonService
import redis.RedisServices
import scheduler.CommitScheduler
import scala.collection.mutable.ArrayBuffer

object SparkMain {


  def main(args: Array[String]): Unit = {
//    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
//    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
    jsonDispose()
  }

  private def schedulerDispose(): Unit = {
    CommitScheduler.start()
  }

  private def excelDispose(session: SparkSession): Unit = {
    // excel
    SparkExcelUtil.previewExcel(session, ConstantPath.macOSPath, false)
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

  private def jsonDispose(): Unit = {
    val seq = new ArrayBuffer[String]()
    seq.append("list1", "list2", "list3")
    val person = Person("typ", "29")
    val bean = SerTestBean("typ", seq, person, true, Some("option"), 1000, EnumBean.EXCEL)

    println("before transform==>" + bean.enumType)
    println("before transform==>" + bean.optionType)
    println("before transform==>" + bean.pojoType)

    // 对象转str
    val str = JsonService.getSerFromObject(bean)
    // str转对象
    val beanTransform = JsonService.getDeSerToObject(str)

    println("after transform==>" + beanTransform.enumType)
    println("after transform==>" + beanTransform.optionType)
    println("after transform==>" + beanTransform.pojoType)

  }
}

