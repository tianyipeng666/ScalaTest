package udf

import bean.Person
import inter.UDFName
import org.apache.spark.sql.SparkSession

import java.util
object UdfRegister {

  def udfArray(session: SparkSession, clazzMap: util.HashMap[String, String]): Unit = {
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

  def getClazz(): util.HashMap[String, String] = {
    val clazzMap = new util.HashMap[String, String]()
    val clazz = Class.forName("udf.GetListGenericUDF")
    val udf = clazz.getAnnotation(classOf[UDFName])
    clazzMap.put(udf.value, clazz.getName)
    clazzMap
  }
}
