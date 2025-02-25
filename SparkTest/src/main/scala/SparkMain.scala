import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import _root_.udf.UdfRegister
import bean.{EnumBean, EnumJava, FieldInfo3, IncrementalPartitionType, Person, PersonSer, SerTestBean, TablePartitionInfo, YearPartitionKeyType}
import constant.{ConstantKey, ConstantPath}
import excel.{ExcelCheckUtil, SparkExcelUtil}
import hive.HiveUtil
import inter.UDFName
import json.JsonService
import _root_.log.LazyLogging
import dataCreate.DataCreateUtils
import jetty.HttpApi
import jetty.web.JettyUtils
import org.apache.spark.storage.StorageLevel
import org.json4s.{DefaultFormats, Formats}
import org.json4s.ext.EnumNameSerializer
import redis.RedisServices
import thread.ShutdownThread
import thread.TheadLock.CurrentMapLock
import thread.scheduler.CommitScheduler
import org.json4s.jackson.Json4sScalaModule
import org.json4s.jackson.Serialization._
import org.json4s.JsonDSL._
import org.json4s._
import sql.SqlParserService

import java.util.UUID

object SparkMain extends LazyLogging {

  import JsonService.formats

  def main(args: Array[String]): Unit = {
    sqlDispose()
  }

  private def getSparkSession(): SparkSession = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkTest")
    SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()
  }

  private def getDataCreate(session: SparkSession, fileNum: Int, path: String): Unit = {
    DataCreateUtils.getDataSample(session, fileNum, path)
  }

  private def sqlDispose(): Unit = {
    val tempSql1 =
      """
        |select a,b,c,d,h from test where e = 10 and f in (select s from test2)
        |""".stripMargin
    val tempSql2 =
      """
        |select DISTINCT(LEFT(`YF_DM`,4)) ND,ND SJ from `去重无用数据`
        |UNION ALL select  DISTINCT(LEFT(`YF_DM`,4)) ND,ND-1 SJ from `去重无用数据`
        |UNION ALL select  DISTINCT(LEFT(`YF_DM`,4)) ND,ND-2 SJ from `去重无用数据`
        |UNION ALL select  DISTINCT(LEFT(`YF_DM`,4)) ND,ND-3 SJ from `去重无用数据`
        |UNION ALL select  DISTINCT(LEFT(`YF_DM`,4)) ND,ND-4 SJ from `去重无用数据`
        |""".stripMargin
    val (parsedSql, relyBaseTables, replaceFields, tempTables, replaceTables,
    variables, fieldVariables, moreFieldsTable) = SqlParserService.parseSql(tempSql1)
    println(
      s"""
         |rely_tables==>${relyBaseTables}
         |temp_tables==>${tempTables}
         |replace_tables==>${replaceTables}
         |""".stripMargin)
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
    val columnStr = "`行号`,`交易机构名称`,`户  名`,`账  号`,`交易机构号`,`子账户序号`"
    SparkExcelUtil.excelResolve(session, columnStr, true, ConstantPath.macOSPath, ConstantPath.macOSPathOut)
  }

  private def udfDispose(session: SparkSession): Unit = {
    // udf
    UdfRegister.udfArray(session, UdfRegister.getClazz())
  }

  private def hiveDispose(session: SparkSession, database: String, tableName: String): Unit = {
    HiveUtil.getHiveTableLocation(session, database, tableName)
  }

  private def ftpDispose(path: String): Unit = {
    // 手动连接
    val client = FtpUtils.getConnect("123.126.105.70", 21, "share", "haizhi1234")
    // 工具类获取连接
    // val connectionInfo = FTPConnectionInfo("123.126.105.70", 21, "share", "haizhi1234", 1)
    // val client = new FTPUtils(connectionInfo, true)
    val nodeMap = FtpUtils.resolveFtpJson(path, client)
    val fileSampleData = FtpUtils.previewFile("/typ/checkField/check2.txt", client, 1)
    val checkSampleDataArr = fileSampleData(0).split(",")
    println(nodeMap)
    println(checkSampleDataArr.mkString(","))
    println(nodeMap.keySet().toArray.sameElements(checkSampleDataArr))
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

  private def httpSourceDispose(): Unit = {
    val session = getSparkSession
    val start = System.currentTimeMillis()
    val df = session.read.format("http_v1")
      .option("url", "http://192.168.1.166:44120")
      .option("name", "z98eb6b13d7540979a10b8ca8d07b340")
      .option("db", "bdp")
      .load
    df.createOrReplaceTempView("partition_temp")
    session.table("partition_temp").persist(StorageLevel.MEMORY_AND_DISK)
    session.sql("select count(1) from partition_temp").show()
    session.sql("select * from partition_temp").show(50)
    val end = System.currentTimeMillis()
    println(s"cost time => ${(end - start) / 1000 / 60}")
    df.unpersist(false)
  }
}

