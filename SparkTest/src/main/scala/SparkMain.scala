import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.{EnumBean, EnumJava, IncrementalPartitionType, Person, PersonSer, SerTestBean, TablePartitionInfo, YearPartitionKeyType}
import constant.{ConstantKey, ConstantPath}
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import json.JsonService
import _root_.log.LazyLogging
import jetty.HttpApi
import jetty.web.JettyUtils
import org.json4s.{DefaultFormats, Formats}
import org.json4s.ext.{EnumNameSerializer}
import redis.RedisServices
import thread.ShutdownThread
import thread.TheadLock.CurrentMapLock
import thread.scheduler.CommitScheduler
import org.json4s.jackson.Json4sScalaModule
import org.json4s.jackson.Serialization._
import org.json4s.JsonDSL._
import org.json4s._

import java.lang
import scala.collection.mutable.ArrayBuffer

object SparkMain extends LazyLogging {

  import JsonService.formats

  def main(args: Array[String]): Unit = {
    jettyDispose

  }

  private def getSparkSession(): SparkSession = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkTest")
    SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
  }

  private def jettyDispose(): Unit = {
    new HttpApi().mapRoutes()
    JettyUtils.startJettyServer("127.0.0.1", 8080, serverName = "LocalJetty")
  }

  private def schedulerDispose(): Unit = {
    // jvm退出监测
    ShutdownThread.listenShutdown()
    CommitScheduler.start()
    while (true) {
      Thread.sleep(1000)
    }
  }

  private def threadLockDispose(): Unit = {
    val task = new Runnable {
      override def run(): Unit = {
        val lockInfo = CurrentMapLock.lockAction("TestLock")
        logger.info(s"${Thread.currentThread.getName}==>" + lockInfo.concurrentNum.incrementAndGet)
        // 不上锁会并发执行
        lockInfo.lock.lock()
        try {
          println(s"${Thread.currentThread.getName}==>task execute...")
          Thread.sleep(10000)
        } catch {
          case e: Exception => {
            e.printStackTrace()
          }
        } finally {
          // 释放锁后顺序执行，公平模式
          lockInfo.lock.unlock()
        }
      }
    }
    val threadFirst = new Thread(task)
    val threadSecond = new Thread(task)
    val threadThird = new Thread(task)
    threadFirst.start
    threadSecond.start
    threadThird.start
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
    logger.info(RedisServices.checkConnection().toString)
    logger.info(RedisServices.getAsyncTask(ConstantKey.ASYNC_COMMIT_TASK))
    RedisServices.registerLuaScript()
    logger.info(RedisServices.getOrDel("redisPrefix:m:commit:result:typ2:orc", "1"))
  }

  private def jsonDispose(): Unit = {

    // 对象
    val bean = JsonService.getSerObject()
    // 对象转str
    val str = JsonService.getSerFromObject(bean)
    // bean写入redis
    // RedisServices.putAsyncValue(str, ConstantKey.ASYNC_COMMIT_TASK)
    // RedisServices.setValue(ConstantKey.asyncResult("typ", "20240806"), write(PersonSer("typ", res)), 1800)

    // str转对象
    val beanTransform = JsonService.getDeSerToObject(str)

    println("after transform==>" + beanTransform.data)
    // 枚举值为null时转回为枚举会报错：Can't convert JNull to class bean.EnumJava
    val tbInfo = JsonService.parse(beanTransform.data).extract[SerTestBean]
    tbInfo.enmJavaType = if (tbInfo.enmJavaType == EnumJava.EMPTY) null else tbInfo.enmJavaType
    println(tbInfo)
  }
}

