package org.apache.spark.sql.execution.datasources.httpV1

import org.apache.hadoop.conf.Configuration
import org.apache.spark.Partition
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis._
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.util.SerializableConfiguration

private[sql] object HttpRelation extends Logging {

  def getSchema(resolver: Resolver, httpOptions: HttpOptions): StructType = {
    HttpHelper.getSchema(httpOptions)
  }

  def getPartitions(resolver: Resolver, httpOptions: HttpOptions): Array[Partition] = {
    HttpHelper.getPartitions(httpOptions)
  }
}

private[sql] case class HttpRelation(override val schema: StructType,
                                     parts: Array[Partition],
                                     httpOptions: HttpOptions)(@transient val sparkSession: SparkSession)
  extends BaseRelation with TableScan {

  // hadoop的Configuration未实现序列化，通过SerializableConfiguration实现conf的序列化并传递到executor中使用
  val serHadoopConf = new SerializableConfiguration(new Configuration())

  override def sqlContext: SQLContext = sparkSession.sqlContext

  override val needConversion: Boolean = false

  override def buildScan(): RDD[Row] = {
    // 只有调用行动算子时才会调用该方法，懒加载
    HTTPMoveDataRDD.scanTable(sparkSession.sparkContext,
      schema,
      parts,
      serHadoopConf,
      httpOptions).asInstanceOf[RDD[Row]]
  }

  override def toString: String = {
    s"HttpRelation(${httpOptions.tableName})"
  }
}
