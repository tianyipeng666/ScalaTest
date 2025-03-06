package org.apache.spark.sql.execution.datasources.httpV1.v2

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.datasources.httpV1
import httpV1.HttpHelper
import org.apache.spark.sql.sources.v2.reader.InputPartitionReader
import org.apache.spark.sql.types.StructType


class HttpInputPartitionReader(schema: StructType, options: httpV1.HttpOptions) extends InputPartitionReader[InternalRow] {
  val data: Iterator[Seq[AnyRef]] = getIterator

  override def next(): Boolean = {
    data.hasNext
  }

  override def get(): InternalRow = {
    val seq = data.next().map {
      // 浮点类型会自动转为BigDecimal，导致Spark无法转换
      case decimal: BigDecimal =>
        decimal.doubleValue()
      case x => x
    }
    InternalRow(seq: _*)
  }

  override def close(): Unit = {
    print("close source")
  }

  def getIterator: Iterator[Seq[AnyRef]] = {
    val res: List[Array[AnyRef]] = HttpHelper.scanTable(options, schema)
    res.map(r => r.toList).toIterator
  }

}
