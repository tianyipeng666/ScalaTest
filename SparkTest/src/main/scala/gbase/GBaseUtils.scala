package gbase

import java.sql.{Connection, DriverManager, ResultSet, ResultSetMetaData}
import scala.collection.mutable.ArrayBuffer

object GBaseUtils {

  def getGBaseConnection(): Connection = {
    Class.forName("com.gbase.jdbc.Driver")
    val connection = DriverManager.getConnection("jdbc:gbase://192.168.1.33:5258/gbasetest?user=gbase&password=GBase2O11O531&rewriteBatchedStatements=true")
    connection
  }

  def createDataBase(dataBaseName: String, connection: Connection): Int = {
    val statement = connection.createStatement
    statement.executeUpdate("create database ${dataBaseName}")
  }

  def createTable(tableName: String, fieldMap: Map[String, String], connection: Connection): Int = {
    val statement = connection.createStatement
    val sqlBuilder = new StringBuilder()
    sqlBuilder.append(s"create table ${tableName}(")
    fieldMap.foreach(entry => {
      sqlBuilder.append(s"${entry._1} ${entry._2},")
    })
    sqlBuilder.deleteCharAt(sqlBuilder.length - 1)
    sqlBuilder.append(")")
    println(sqlBuilder)
    statement.executeUpdate(sqlBuilder.toString())
  }

  def getTableData(executeSql: String, connection: Connection): ArrayBuffer[ArrayBuffer[String]] = {
    val statement = connection.createStatement
    val rs: ResultSet = statement.executeQuery(executeSql)
    val rsMeta: ResultSetMetaData = rs.getMetaData
    val size = rsMeta.getColumnCount
    val resultList = ArrayBuffer[ArrayBuffer[String]]()
    while (rs.next) {
      val row = new ArrayBuffer[String]
      for (i <- 1 to size) {
        row.append(rs.getString(i))
      }
      resultList.append(row)
    }
    rs.close()
    statement.close()
    resultList
  }

}
