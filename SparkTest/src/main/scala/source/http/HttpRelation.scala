package source.http

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.sql.sources.{BaseRelation, TableScan}
import org.apache.spark.sql.types.StructType

case class HttpRelation(session: SparkSession, options: HttpOptions, schemaInfo: StructType, num: Int) extends BaseRelation with TableScan {
  override def sqlContext: SQLContext = session.sqlContext

  override def schema: StructType = schemaInfo

  override def buildScan(): RDD[Row] = {
    null
  }

}

object HttpRelation {
  def getTableInfo(httpOptions: HttpOptions): (StructType, Int) = {
    null
  }

  def columnQueryNum(httpOptions: HttpOptions): Int = {
    0
  }
}
