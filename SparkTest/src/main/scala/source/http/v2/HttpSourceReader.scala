package source.http.v2

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.sources.v2.reader.{DataSourceReader, InputPartition}
import org.apache.spark.sql.types.StructType

import java.util

case class HttpSourceReader(options: Map[String, String]) extends DataSourceReader{
  override def planInputPartitions(): util.List[InputPartition[InternalRow]] = ???

  override def readSchema(): StructType = ???

}
