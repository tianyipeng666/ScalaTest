import ftp.FtpUtils
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, DataTypes, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import utils.ExcelCheckUtil
import org.apache.spark.sql.functions._
import _root_.udf.{GetListGenericUDF, GetListUDF}
import bean.Person
import inter.UDFName
import org.apache.poi.ss.formula.functions.T

import java.io.File
import java.lang.String
import java.util
import scala.collection.mutable.ArrayBuffer

object SparkMain {

  val macOSPath = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/testFiles"
  val windowsPath = "D:\\项目\\idea\\idea-project\\ScalaTest\\SparkTest\\files"
  val ftpPath = ""
  val desPath = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/desFiles"
  val hdfsPath = "hdfs://172.16.34.121:8020/excel/"

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    // excel处理
    excelResolve(session)

    // class
    // val clazzMap = getClazz()
    // udf处理
    // udfArray(session, clazzMap)
  }

  private def excelResolve(session: SparkSession): Unit = {
    val df = session.read.format("excel")
      .option("dataAddress", "A6")
      .option("header", "true")
      .option("columnNameOfRowNumber", "行号")
      .load(macOSPath + "/*.xlsx")
    df.show(10000)
    df.write.
      option("header", "true").
      csv(desPath + "/testCsv")
    session.read.
      option("header", "true").
      csv(desPath + "/testCsv")
      .show(10000)

  }

  private def udfArray(session: SparkSession, clazzMap:util.HashMap[String, String]): Unit = {
//    val getListUDF = udf((tbName: String, path: String) => {
//      val list = new util.ArrayList[String]()
//      list.add(tbName)
//      list.add(path)
//      list
//    })
//    session.udf.register("getList", getListUDF)
    clazzMap.entrySet().forEach(entry => {
      val tempSql = s"CREATE OR REPLACE FUNCTION ${entry.getKey} AS '${entry.getValue}'"
      println(tempSql)
      session.sql(tempSql)
    })

    val df = session.createDataFrame(Seq(Person("Michael", "29"), Person("Andy", "30"), Person("Justin", "19")))
    df.createOrReplaceTempView("testView")
    val res = session.sql(
      """
        |select GET_LIST(name, age) from testView
        |""".stripMargin).collect().map(row => row.getString(0).split(","))
    res.foreach(elem => {
      println(elem(0) + "==" + elem(1))
    })
  }

  private def getClazz():util.HashMap[String, String] = {
    val clazzMap = new util.HashMap[String, String]()
    val clazz = Class.forName("udf.GetListGenericUDF")
    val udf = clazz.getAnnotation(classOf[UDFName])
    clazzMap.put(udf.value, clazz.getName)
    clazzMap
  }
}

