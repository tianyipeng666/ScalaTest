package org.apache.spark.sql.execution.datasources.httpV1Filter

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, RelationProvider}


// 每个Spark版本都兼容v1源，但是Spark不同版本对于v2源区别较大
class HttpFilterRelationProvider extends RelationProvider with DataSourceRegister {

  override def shortName(): String = "http_v1Filter"

  // 读取relation创建
  override def createRelation(
                               sqlContext: SQLContext,
                               parameters: Map[String, String]): BaseRelation = {
    val httpOptions = new HttpOptions(parameters)
    // 路径如果不是org.apache.spark.sql.execution.datasources下的话会报无法引用
    // private[sql]标识代表Spark SQL内部模块使用，源码外不同路径会无法使用
    // 获取表schema
    // val schema = HttpRelation.getSchema(httpOptions)
    new HttpFilterRelation(None, None, httpOptions)(sqlContext.sparkSession)
  }

}
