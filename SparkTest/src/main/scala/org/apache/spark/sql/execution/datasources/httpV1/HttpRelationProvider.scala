package org.apache.spark.sql.execution.datasources.httpV1

import org.apache.spark.sql.{DataFrame, SQLContext, SaveMode}
import org.apache.spark.sql.sources.{BaseRelation, CreatableRelationProvider, DataSourceRegister, RelationProvider}

import scala.collection.mutable.ArrayBuffer


// 每个Spark版本都兼容v1源，但是Spark不同版本对于v2源区别较大
class HttpRelationProvider extends RelationProvider with DataSourceRegister {

  override def shortName(): String = "http_v1"

  // 读取relation创建
  override def createRelation(
                               sqlContext: SQLContext,
                               parameters: Map[String, String]): BaseRelation = {
    val httpOptions = new HttpOptions(parameters)
    // 路径如果不是org.apache.spark.sql.execution.datasources下的话会报无法引用
    // private[sql]标识代表Spark SQL内部模块使用，源码外不同路径会无法使用
    val resolver = sqlContext.conf.resolver
    // 获取表schema
    val schema = HttpRelation.getSchema(resolver, httpOptions)
    // 设定数据分区
    val parts = HttpRelation.getPartitions(resolver, httpOptions)
    HttpRelation(schema, parts, httpOptions)(sqlContext.sparkSession)
  }

}
