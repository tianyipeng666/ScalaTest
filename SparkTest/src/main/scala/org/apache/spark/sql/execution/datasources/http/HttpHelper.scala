package org.apache.spark.sql.execution.datasources.http

import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SpecificInternalRow
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String
import org.json._

import java.util

object HttpHelper extends Logging {
  case class HttpSchema (name: String, `type`: String)
  case class HttpResult (data: Array[Array[Any]], schema: Array[HttpSchema])

  def getSchema(httpOptions: HttpOptions): StructType = {
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val schemaQuery = s"SELECT * FROM $tableName WHERE 1=0"

    try {
      // 1、调用mobius地址获取schema信息
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
          // todo 根据schema的类型获取，目前统一用string获取
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

  def scanTableV1(httpOptions: HttpOptions, schema: StructType): List[InternalRow] = {
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
      val result = new Array[InternalRow](tableCount)
      var j = 0

      while (j < tableCount) {
        val oneRow = tableData.getJSONArray(j)
        val rowCount: Int = oneRow.length
        var k = 0
        val mutableRow = new SpecificInternalRow(schema.fields.map(x => x.dataType))
        while (k < rowCount) {
          // todo 根据schema的类型获取，目前统一用string获取
          val oneCol = UTF8String.fromString(oneRow.getString(k))
          mutableRow.update(k, oneCol)
          k = k + 1
        }
        result.update(j, mutableRow.asInstanceOf[InternalRow])
        j = j + 1
      }
      result.toList
    } catch {
      case exception: Exception => throw exception
    }

  }
}