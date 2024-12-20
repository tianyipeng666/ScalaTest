package org.apache.spark.sql.execution.datasources.http

import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis._
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SQLContext, SparkSession}

private[sql] object HttpRelation extends Logging {
  /**
   * Takes a (schema, table) specification and returns the table's Catalyst schema.
   * If `customSchema` defined in the DMC options, replaces the schema's dataType with the
   * custom schema's type.
   *
   * @param resolver function used to determine if two identifiers are equal
   * @param HttpOptions DMC options that contains mobius url, table and other information.
   * @return resolved Catalyst schema of a JDBC table
   */
  def getSchema(resolver: Resolver, httpOptions: HttpOptions): StructType = {
    HttpHelper.getSchema(httpOptions)
  }

  /**
   * Resolves a Catalyst schema of a dmc table and returns [[HttpRelation]] with the schema.
   */
  def apply(httpOptions: HttpOptions)(sparkSession: SparkSession): HttpRelation = {
    val schema = HttpRelation.getSchema(sparkSession.sessionState.conf.resolver, httpOptions)
    HttpRelation(schema, httpOptions)(sparkSession)
  }
}

private[sql] case class HttpRelation(
                                     override val schema: StructType,
                                     HttpOptions: HttpOptions)(@transient val sparkSession: SparkSession)
  extends BaseRelation with TableScan {

  override def sqlContext: SQLContext = sparkSession.sqlContext

  override val needConversion: Boolean = false

  override def buildScan(): RDD[Row] = {
    val data = HttpHelper.scanTableV1(HttpOptions, schema)
    val dataRdd = sqlContext.sparkContext.makeRDD(data)
    // 路径如果不是org.apache.spark.sql.execution.datasources下的话会报无法引用
    sqlContext.internalCreateDataFrame(dataRdd.setName(HttpOptions.tableName), schema).rdd
  }

  override def toString: String = {
    s"HttpRelation(${HttpOptions.tableName})"
  }
}
