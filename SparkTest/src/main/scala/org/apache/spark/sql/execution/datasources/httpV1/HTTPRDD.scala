package org.apache.spark.sql.execution.datasources.httpV1

import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.spark.{Partition, SparkContext, TaskContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SpecificInternalRow
import org.apache.spark.sql.types.StructType
import org.apache.spark.unsafe.types.UTF8String
import org.json.JSONObject

import java.util
import java.util.UUID

object HTTPRDD {

  def scanTable(sc: SparkContext,
                schema: StructType,
                parts: Array[Partition],
                httpOptions: HttpOptions): RDD[InternalRow] = {
    new HTTPRDD(sc,
      schema,
      parts,
      httpOptions)
  }
}

private[httpV1] class HTTPRDD(sc: SparkContext,
                              schema: StructType,
                              partitions: Array[Partition],
                              httpOptions: HttpOptions)
  extends RDD[InternalRow](sc, Nil) {
  override def compute(split: Partition, context: TaskContext): Iterator[InternalRow] = {
    println(s"Partition ${context.partitionId} compute start...")

    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val scanQuery = s"SELECT * FROM $tableName"
    val partition = split.asInstanceOf[HTTPPartition]

    try {

      // 请求组装
      val httpParams = new util.ArrayList[NameValuePair]()
      httpParams.add(new BasicNameValuePair("sql", scanQuery))
      httpParams.add(new BasicNameValuePair("storage_id", tableName))
      httpParams.add(new BasicNameValuePair("trace_id", UUID.randomUUID.toString))
      httpParams.add(new BasicNameValuePair("limit_start", partition.limitStart.toString))
      httpParams.add(new BasicNameValuePair("limit_end", partition.limitEnd.toString))

      val httpHelper = new http.HttpHelper()
      val data = httpHelper.send(httpUrl, httpParams)
      if (!data.contains("\"status\" : 0")) {
        throw new Exception(data)
      }

      // 2、解析获取的数据
      val info: JSONObject = new JSONObject(data)
      val tableData = info.getJSONArray("data")
      val tableCount: Int = tableData.length
      val result = new Array[InternalRow](tableCount)
      var j = 0

      while (j < tableCount) {
        val oneRow = tableData.getJSONArray(j)
        val rowCount: Int = oneRow.length
        var k = 0
        val mutableRow = new SpecificInternalRow(schema.fields.map(x => x.dataType))
        while (k < rowCount) {
          if (oneRow.isNull(k)) {
            mutableRow.setNullAt(k)
          } else {
            mutableRow.update(k, UTF8String.fromString(oneRow.getString(k)))
          }
          k = k + 1
        }
        result.update(j, mutableRow)
        j = j + 1
      }
      result.iterator
    } catch {
      case exception: Exception => throw exception
    }
  }

  override protected def getPartitions: Array[Partition] = partitions
}
