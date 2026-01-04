package udf

import bean.Person
import inter.UDFName
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{SQLContext, SparkSession}

import java.util
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object UdfRegister {

  def udfArray(session: SparkSession, clazzMap: util.HashMap[String, String]): Unit = {
    // 临时udf注册
    val getListUDF = udf((tbName: String, path: String) => {
      val list = new util.ArrayList[String]()
      list.add(tbName)
      list.add(path)
      list
    })
    session.udf.register("getList", getListUDF)

    //自定义udf注册
//    clazzMap.entrySet().forEach(entry => {
//      val tempSql = s"CREATE OR REPLACE FUNCTION ${entry.getKey} AS '${entry.getValue}'"
//      println(tempSql)
//      session.sql(tempSql)
//    })

    val df = session.createDataFrame(Seq(Person("Michael", "29"), Person("Andy", "30"), Person("Justin", "19")))
    //scala的Seq数据转为Df
    //import session.implicits._
    //val fileList = new ArrayBuffer[String]
    //val df = fileList.map(f => ("tbName", f))
    //  .toDF("name", "age")
    df.createOrReplaceTempView("testView")
    val res = session.sql(
      """
        |select GET_LIST(name, age) from testView
        |""".stripMargin).collect().map(row => row.getString(0).split(","))
    res.foreach(elem => {
      println(elem(0) + "==" + elem(1) + "==" + elem(2))
    })
  }

  def getClazz(): util.HashMap[String, String] = {
    val clazzMap = new util.HashMap[String, String]()
    val clazz = Class.forName("udf.GetListGenericUDF")
    val udf = clazz.getAnnotation(classOf[UDFName])
    clazzMap.put(udf.value, clazz.getName)
    clazzMap
  }
}
