package org.apache.spark.sql.execution.datasources.http.v2

import org.apache.spark.sql.execution.datasources.http
import org.apache.spark.sql.sources.DataSourceRegister
import org.apache.spark.sql.sources.v2.reader.DataSourceReader
import org.apache.spark.sql.sources.v2.{DataSourceOptions, DataSourceV2, ReadSupport}

import scala.collection.JavaConverters.mapAsScalaMapConverter


class HttpDataSourceV2 extends DataSourceV2 with ReadSupport with DataSourceRegister with Serializable{
  override def shortName(): String = "http_v2"

  override def createReader(options: DataSourceOptions): DataSourceReader = {
    val parameters: Map[String, String] = options.asMap().asScala.toMap
    val httpOptions = new http.HttpOptions(parameters)
    new HttpDatasourceReader(httpOptions)
  }
}
