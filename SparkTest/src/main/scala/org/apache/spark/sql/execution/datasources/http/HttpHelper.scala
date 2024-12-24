package org.apache.spark.sql.execution.datasources.http

import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.spark.Partition
import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SpecificInternalRow
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String
import org.json._

import java.util
import scala.collection.mutable.ArrayBuffer

object HttpHelper extends Logging {
  case class HttpSchema (name: String, `type`: String)
  case class HttpResult (data: Array[Array[Any]], schema: Array[HttpSchema])

  def getPartitions(httpOptions: HttpOptions) : Array[Partition] = {
    // 从远端服务获取总条数
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val partitionRowsNum = httpOptions.partitionRowsNum
    val dataQuery = s"SELECT COUNT(1) FROM $tableName"
    val ans = new ArrayBuffer[Partition]()

    try {
      // 远端接口调用
      val nvps = new util.ArrayList[NameValuePair]()
      nvps.add(new BasicNameValuePair("sql", dataQuery))
      val httpHelper = new http.HttpHelper()
      val data = httpHelper.send(httpUrl, nvps)
      if (!data.contains("\"status\" : 0")) {
        throw new Exception(data)
      }

      // data数量解析
      val result: JSONObject = new JSONObject(data)
      val dataCount = result.getJSONArray("data")
        .getJSONArray(0)
        .get(0)
        .toString
        .toLong

      println(s"${tableName} count => ${dataCount}")

      // 根据远端表数量与传递参数分区数量进行分区
      val partitionNums = dataCount / partitionRowsNum + 1
      var i: Int = 0
      while(i < partitionNums) {
        ans.append(HTTPPartition(partitionRowsNum * i, partitionRowsNum * (i + 1) - 1, i))
        i = i + 1
      }
    } catch {
      case exception: Exception => throw exception
    }
    println(s"${tableName} partitionNums => ${ans.size}")
    ans.toArray
  }

  def getSchema(httpOptions: HttpOptions): StructType = {
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val schemaQuery = s"SELECT * FROM $tableName WHERE 1=0"

    try {
      // 1、根据远端服务地址获取schema信息
      val nvps = new util.ArrayList[NameValuePair]()
      nvps.add(new BasicNameValuePair("sql", schemaQuery))

      val httpHelper = new http.HttpHelper()
      val data = httpHelper.send(httpUrl, nvps)
      if (!data.contains("\"status\" : 0")) {
        throw new Exception(data)
      }

      // 2、解析获取的schema
      val result: JSONObject = new JSONObject(data)

      val tableSchema = result.getJSONArray("schema")

      val cloNum: Int = tableSchema.length
      val fields = new Array[StructField](cloNum)
      var j = 0
      while (j < cloNum) {
        val i = tableSchema.getJSONObject(j)
        val columnName = i.getString("name")
        val columnType = getSparkDataType(i.getString("type"))
        fields(j) = StructField(columnName, columnType, nullable = true)
        j = j + 1
      }
      new StructType(fields)
    } catch {
      case exception: Exception => throw exception
    }
  }

  private def getSparkDataType(mobiusDataType: String): DataType = {
    val sparkDataType = mobiusDataType match {
      case "integer" => IntegerType
      case "boolean" => BooleanType
      case "string" => StringType
      case "byte" => ByteType
      case "binary" => BinaryType
      case "date" => DateType
      case "timestamp" => TimestampType
      case "double" => DoubleType
      case "float" => FloatType
      case "long" => LongType
      case "short" => ShortType
      case _ => StringType
    }
    sparkDataType
  }

  def scanTable(httpOptions: HttpOptions, schema: StructType): List[Array[AnyRef]] = {
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val scanQuery = s"SELECT * FROM $tableName"

    try {
      // 1、调用mobius地址获取数据
      val nvps = new util.ArrayList[NameValuePair]()
      nvps.add(new BasicNameValuePair("sql", scanQuery))

      val httpHelper = new http.HttpHelper()
      val data = httpHelper.send(httpUrl, nvps)
      if (!data.contains("\"status\" : 0")) {
        throw new Exception(data)
      }

      // 2、解析获取的数据
      val info: JSONObject = new JSONObject(data)
      val tableData = info.getJSONArray("data")
      val tableCount: Int = tableData.length
      val result = new Array[Array[AnyRef]](tableCount)
      var j = 0

      while (j < tableCount) {
        val oneRow = tableData.getJSONArray(j)
        val rowCount: Int = oneRow.length
        var k = 0
        val oneRowAry = new Array[AnyRef](rowCount)
        while (k < rowCount) {
          if (oneRow.isNull(k)) {
            oneRowAry.update(k, null)
          } else {
            oneRowAry.update(k, UTF8String.fromString(oneRow.getString(k)))
          }
          k = k + 1
        }

        result.update(j, oneRowAry)
        j = j + 1
      }
      result.toList
    } catch {
      case exception: Exception => throw exception
    }
  }
}