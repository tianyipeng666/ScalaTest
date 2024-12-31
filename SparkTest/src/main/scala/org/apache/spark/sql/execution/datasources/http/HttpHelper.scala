package org.apache.spark.sql.execution.datasources.http

import com.alibaba.fastjson.{JSON, JSONObject}
import com.github.lianjiatech.retrofit.spring.boot.exception.ReadResponseBodyException
import com.github.lianjiatech.retrofit.spring.boot.util.RetrofitUtils
import constant.ConstantPath
import http.HttpUtils.{execute, httpClient}
import okhttp3.{FormBody, OkHttpClient, Request}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.apache.spark.Partition
import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.SpecificInternalRow
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String

import java.util
import java.util.concurrent.TimeUnit
import scala.collection.mutable.ArrayBuffer

object HttpHelper extends Logging {

  private val httpClient = new OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.MINUTES)
    .build

  def doPostForm(url: String, params: JSONObject): String = {
    val builder = new FormBody.Builder
    import scala.collection.JavaConversions._
    for (key <- params.keySet) {
      builder.add(key, params.getString(key))
    }
    val request = new Request.Builder().url(url).post(builder.build).build
    val execute = httpClient.newCall(request).execute
    try {
      RetrofitUtils.readResponseBody(execute)
    } catch {
      case e: ReadResponseBodyException =>
        e.printStackTrace()
        null
    }
  }

  def doPostFormByte(url: String, params: JSONObject, writePath: String): Boolean = {
    val builder = new FormBody.Builder
    import scala.collection.JavaConversions._
    for (key <- params.keySet) {
      builder.add(key, params.getString(key))
    }
    val request = new Request.Builder().url(url).post(builder.build).build
    // todo: 改为应用配置中的hdfs地址
    val config = new Configuration()
    val fs = FileSystem.get(config)
    val outputPath = new Path(writePath)
    val outputStream = fs.create(outputPath, true)
    val res = httpClient.newCall(request).execute
    try {
      val inputStream = res.body.byteStream
      val bytesRead = new Array[Byte](2048)
      var length = 0
      while ( {
        length = inputStream.read(bytesRead); length != -1
      }) {
        outputStream.write(bytesRead, 0, length)
      }
      outputStream.flush()
      true
    } catch {
      case e: ReadResponseBodyException =>
        e.printStackTrace()
        false
    } finally {
      if (outputStream != null) {
        outputStream.close()
      }
    }
  }

  def getPartitions(httpOptions: HttpOptions) : Array[Partition] = {
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val partitionRowsNum = httpOptions.partitionRowsNum
    val dataCountQuery = s"SELECT COUNT(1) FROM $tableName"
    val paramsCount = new JSONObject
    paramsCount.put("sql", dataCountQuery)
    val partitionBuffer = new ArrayBuffer[Partition]()

    try {
      val dataCount = doPostForm(httpUrl, paramsCount)
      if (!dataCount.contains("\"status\" : 0")) {
        throw new Exception(dataCount)
      }

      // data数量解析
      val resultCount: JSONObject = JSON.parseObject(dataCount)
      val count = resultCount.getJSONArray("data")
        .getJSONArray(0)
        .get(0)
        .toString
        .toLong

      // 数据重分区
      val partitionNums = count / partitionRowsNum + 1
      val paramsPartition = new JSONObject
      paramsPartition.put("storage_id", tableName)
      paramsPartition.put("partition_nums", partitionNums.toString)
      val pathArr = repartitionFiles(httpOptions.url, paramsPartition)

      // partition信息补充
      var i: Int = 0
      while(i < partitionNums) {
        partitionBuffer.append(HTTPMoveDataPartition(pathArr(i), i))
        i = i + 1
      }
    } catch {
      case exception: Exception => throw exception
    }
    println(s"${tableName} partitionNums => ${partitionBuffer.size} ==> ${partitionBuffer.mkString(",")}")
    partitionBuffer.toArray
  }

  private def repartitionFiles(url: String, params: JSONObject): ArrayBuffer[String] = {
    val pathArr = new ArrayBuffer[String]()
    val httpUrl = url + "/db/repartitionData"
    val dataPartition = doPostForm(httpUrl, params)
    if (!dataPartition.contains("\"status\" : 0")) {
      throw new Exception(dataPartition)
    }
    val resultPartition: JSONObject = JSON.parseObject(dataPartition)
    val dataArr = resultPartition.getJSONArray("data")
    (0 until dataArr.size())
      .foreach(i => pathArr.append(dataArr.getString(i)))
    pathArr
  }

  def getSchema(httpOptions: HttpOptions): StructType = {
    val httpUrl = httpOptions.url + "/db/query"
    val tableName = httpOptions.tableName
    val schemaQuery = s"SELECT * FROM $tableName LIMIT 1"

    try {
      val params = new JSONObject
      params.put("sql", schemaQuery)
      val data = doPostForm(httpUrl, params)
      if (!data.contains("\"status\" : 0")) {
        throw new Exception(data)
      }

      // 2、解析获取的schema
      val result: JSONObject = JSON.parseObject(data)

      val tableSchema = result.getJSONArray("schema")

      val cloNum: Int = tableSchema.size()
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

  // 通过请求查询数据(老版)
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
      val info: JSONObject = JSON.parseObject(data)
      val tableData = info.getJSONArray("data")
      val tableCount: Int = tableData.size()
      val result = new Array[Array[AnyRef]](tableCount)
      var j = 0

      while (j < tableCount) {
        val oneRow = tableData.getJSONArray(j)
        val rowCount: Int = oneRow.size
        var k = 0
        val oneRowAry = new Array[AnyRef](rowCount)
        while (k < rowCount) {
          if (oneRow.get(k) == null) {
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