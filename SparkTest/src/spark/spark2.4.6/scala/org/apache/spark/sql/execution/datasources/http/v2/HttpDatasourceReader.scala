package org.apache.spark.sql.execution.datasources.httpV1.v2

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.datasources.httpV1
import httpV1.HttpHelper
import org.apache.spark.sql.sources.v2.reader.{DataSourceReader, InputPartition, InputPartitionReader}
import org.apache.spark.sql.types.StructType

import java.util


class HttpDatasourceReader(httpOptions: httpV1.HttpOptions) extends DataSourceReader with Serializable {

  override def readSchema(): StructType = HttpHelper.getSchema(httpOptions)

  override def planInputPartitions(): util.List[InputPartition[InternalRow]] = {
    // 为了简单起见，读取表数据时，所有数据放在1个分区中
    util.Arrays.asList(new HttpInputPartition(readSchema(), httpOptions))
  }

  class HttpInputPartition(schema: StructType, options: httpV1.HttpOptions) extends InputPartition[InternalRow] {
    override def createPartitionReader(): InputPartitionReader[InternalRow] = {
      new HttpInputPartitionReader(schema, options)
    }
  }
}
