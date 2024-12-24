package org.apache.spark.sql.execution.datasources.http

import org.apache.spark.Partition
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

  def getPartitions(resolver: Resolver, httpOptions: HttpOptions): Array[Partition] = {
    HttpHelper.getPartitions(httpOptions)
  }

  /**
   * Resolves a Catalyst schema of a dmc table and returns [[HttpRelation]] with the schema.
   */
  def apply(httpOptions: HttpOptions)(sparkSession: SparkSession): HttpRelation = {
    val schema = HttpRelation.getSchema(sparkSession.sessionState.conf.resolver, httpOptions)
    val parts = HttpRelation.getPartitions(sparkSession.sessionState.conf.resolver, httpOptions)
    HttpRelation(schema, parts, httpOptions)(sparkSession)
  }
}

private[sql] case class HttpRelation(
                                     override val schema: StructType,
                                     parts: Array[Partition],
                                     httpOptions: HttpOptions)(@transient val sparkSession: SparkSession)
  extends BaseRelation with TableScan {

  override def sqlContext: SQLContext = sparkSession.sqlContext

  override val needConversion: Boolean = false

  override def buildScan(): RDD[Row] = {
    HTTPRDD.scanTable(sparkSession.sparkContext,
      schema,
      parts,
      httpOptions).asInstanceOf[RDD[Row]]
  }

  override def toString: String = {
    s"HttpRelation(${httpOptions.tableName})"
  }
}
