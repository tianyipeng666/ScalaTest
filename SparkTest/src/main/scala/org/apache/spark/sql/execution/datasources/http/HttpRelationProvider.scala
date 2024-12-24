package org.apache.spark.sql.execution.datasources.http

import org.apache.spark.sql.{DataFrame, SQLContext, SaveMode}
import org.apache.spark.sql.sources.{BaseRelation, CreatableRelationProvider, DataSourceRegister, RelationProvider}


class HttpRelationProvider extends RelationProvider with DataSourceRegister {

  override def shortName(): String = "http_v1"

  // 读取relation创建
  override def createRelation(
                               sqlContext: SQLContext,
                               parameters: Map[String, String]): BaseRelation = {
    val HttpOptions = new HttpOptions(parameters)
    // 路径如果不是org.apache.spark.sql.execution.datasources下的话会报无法引用
    // private[sql]标识代表Spark SQL内部模块使用，源码外不同路径会无法使用
    val resolver = sqlContext.conf.resolver
    // 获取表schema
    val schema = HttpRelation.getSchema(resolver, HttpOptions)
    // 设定数据分区
    val parts = HttpRelation.getPartitions(resolver, HttpOptions)
    HttpRelation(schema, parts, HttpOptions)(sqlContext.sparkSession)
  }

}
