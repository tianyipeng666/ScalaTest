package org.apache.spark.sql.execution.datasources.httpV1Filter

import org.apache.spark.Partition

case class HTTPMoveDataPartition(filePath: String, idx: Int) extends Partition {
  override def index: Int = idx
}
