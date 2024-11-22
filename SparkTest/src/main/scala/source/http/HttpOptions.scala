package source.http

import org.apache.spark.sql.catalyst.util.CaseInsensitiveMap

class HttpOptions(@transient val parameters: CaseInsensitiveMap[String]) extends Serializable {

  def this(parameters: Map[String, String]) = this(CaseInsensitiveMap(parameters))

  private val HTTP_URL = "url"
  private val HTTP_TABLE_NAME = "table"
  private val PARTITION_COLUMN = "partitionColumn"
  private val LOWER_BOUND = "lowerBound"
  private val UPPER_BOUND = "upperBound"
  private val NUM_PARTITIONS = "numPartitions"
  private val QUERY_TIMEOUT = "queryTimeout"
  private val BATCH_FETCH_SIZE = "fetchSize"

  val url = parameters.get(HTTP_URL)
  val table = parameters.get(HTTP_TABLE_NAME)
  val partitionColumn = parameters.get(PARTITION_COLUMN)
  val lowerBound = parameters.get(LOWER_BOUND)
  val upperBound = parameters.get(UPPER_BOUND)
  val numPartitions = parameters.getOrElse(NUM_PARTITIONS, "10").toInt
  val queryTimeout = parameters.getOrElse(QUERY_TIMEOUT, "0").toInt
  val fetchSize = parameters.getOrElse(BATCH_FETCH_SIZE, "0").toInt
}
