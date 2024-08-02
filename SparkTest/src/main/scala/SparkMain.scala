import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.{EnumBean, Person, SerTestBean}
import constant.{ConstantKey, ConstantPath}
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import json.JsonService
import _root_.log.LazyLogging
import redis.RedisServices
import thread.ShutdownThread
import thread.TheadLock.CurrentMapLock
import thread.scheduler.CommitScheduler

import java.lang
import scala.collection.mutable.ArrayBuffer

object SparkMain extends LazyLogging{


  def main(args: Array[String]): Unit = {

    threadLockDispose
  }

  private def getSparkSession(): SparkSession = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkTest")
    SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
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
          case e:Exception => {
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
    val seq = new ArrayBuffer[String]()
    seq.append("list1", "list2", "list3")
    val person = Person("typ2", "30")
    val bean = SerTestBean("typ2", seq, person, true, Some("option"), 1000, EnumBean.ORC)

    println("before transform==>" + bean.enumType)
    println("before transform==>" + bean.optionType)
    println("before transform==>" + bean.pojoType)

    // 对象转str
    val str = JsonService.getSerFromObject(bean)
    // bean写入redis
    RedisServices.putAsyncValue(str, ConstantKey.ASYNC_COMMIT_TASK)
    // str转对象
    val beanTransform = JsonService.getDeSerToObject(str)

    println("after transform==>" + beanTransform.data)
  }
}

