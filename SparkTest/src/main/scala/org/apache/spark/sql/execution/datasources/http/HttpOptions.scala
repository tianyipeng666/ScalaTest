package org.apache.spark.sql.execution.datasources.http

import org.apache.spark.sql.catalyst.util.CaseInsensitiveMap

import java.util.Locale

class HttpOptions(@transient val parameters: CaseInsensitiveMap[String])
  extends Serializable {

  import HttpOptions._

  def this(parameters: Map[String, String]) = this(CaseInsensitiveMap(parameters))

  require(parameters.isDefinedAt(HTTP_URL), s"Option '$HTTP_URL' is required.")
  val url = parameters(HTTP_URL)

  require(parameters.isDefinedAt(TABLE_NAME), s"Option '$TABLE_NAME' is required.")
  val tableName = parameters(TABLE_NAME)

  val dbName = parameters(DB_NAME)

  val partitionRowsNum = parameters.getOrElse(PARTITION_ROWS_NUM, "1000000").toInt
}

object HttpOptions {
  private val curId = new java.util.concurrent.atomic.AtomicLong(0L)
  private val httpOptionNames = collection.mutable.Set[String]()

  private def newOption(name: String): String = {
    httpOptionNames += name.toLowerCase(Locale.ROOT)
    name
  }

  val HTTP_URL = newOption("url")
  val TABLE_NAME = newOption("name")
  val DB_NAME = newOption("db")
  val PARTITION_ROWS_NUM = newOption("partitionRowsNum")
}