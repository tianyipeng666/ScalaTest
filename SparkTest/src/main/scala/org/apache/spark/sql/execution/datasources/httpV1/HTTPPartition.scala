package org.apache.spark.sql.execution.datasources.httpV1

import org.apache.spark.Partition

case class HTTPPartition(limitStart: Long, limitEnd: Long, idx: Int) extends Partition {
  override def index: Int = idx
}
