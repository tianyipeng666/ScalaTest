package org.apache.spark.sql.execution.datasources.http.v2

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.execution.datasources.http
import http.HttpHelper
import org.apache.spark.sql.sources.v2.reader.{DataSourceReader, InputPartition, InputPartitionReader}
import org.apache.spark.sql.types.StructType

import java.util


class HttpDatasourceReader(httpOptions: http.HttpOptions) extends DataSourceReader with Serializable {

  override def readSchema(): StructType = HttpHelper.getSchema(httpOptions)

  override def planInputPartitions(): util.List[InputPartition[InternalRow]] = {
    // 为了简单起见，读取表数据时，所有数据放在1个分区中
    util.Arrays.asList(new HttpInputPartition(readSchema(), httpOptions))
  }

  class HttpInputPartition(schema: StructType, options: http.HttpOptions) extends InputPartition[InternalRow] {
    override def createPartitionReader(): InputPartitionReader[InternalRow] = {
      new HttpInputPartitionReader(schema, options)
    }
  }
}
