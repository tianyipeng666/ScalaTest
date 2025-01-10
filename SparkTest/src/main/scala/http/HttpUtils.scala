package http

import org.json._
import com.github.lianjiatech.retrofit.spring.boot.exception.ReadResponseBodyException
import com.github.lianjiatech.retrofit.spring.boot.util.RetrofitUtils
import okhttp3.{FormBody, MediaType, OkHttpClient, Request, RequestBody}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair
import org.json4s.{DefaultFormats, Formats}

import java.io.InputStream
import java.util
import java.util.concurrent.TimeUnit

object HttpUtils {

  implicit val formats: Formats = DefaultFormats

  private val httpClient = new OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.MINUTES)
    .build

  val url = "http://192.168.1.166:44120"

  def main(args: Array[String]): Unit = {
    val params = new JSONObject
    params.put("sql", "SELECT * FROM z98eb6b13d7540979a10b8ca8d07b340 limit 1")
    println(doPostForm(url + "/db/query", params))
  }

  def doPostForm(url: String, params: JSONObject): String = {
    // 发送请求在url后
    val builder = new FormBody.Builder
    import scala.collection.JavaConversions._
    for (key <- params.keySet) {
      builder.add(key, params.getString(key))
    }
    val request = new Request.Builder().url(url).post(builder.build).build
    execute(request)
  }

  def doPostBody(url: String, params: String): String = {
    // 发送参数在body中
    // params为case class通过write构建的jsonString，write(elem)
    val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params)
    val request = new Request.Builder().url(url).post(body).build
    execute(request)
  }

  private def execute(request: Request) = {
    val execute = httpClient.newCall(request).execute
    try {
      RetrofitUtils.readResponseBody(execute)
    } catch {
      case e: ReadResponseBodyException =>
        e.printStackTrace()
        null
    }
  }

  private def doPostFormByte(url: String, params: JSONObject): Boolean = {
    val builder = new FormBody.Builder
    import scala.collection.JavaConversions._
    for (key <- params.keySet) {
      builder.add(key, params.getString(key))
    }
    val request = new Request.Builder().url(url).post(builder.build).build
    executeByte(request)
  }

  private def executeByte(request: Request): Boolean = {
    val config = new Configuration()
    val fs = FileSystem.get(config)
    val outputPath = new Path("hdfs://hdcluster/bdp/remote_get/z98eb6b13d7540979a10b8ca8d07b340/part-00001-2ecbfef4-8265-40e1-a35c-5499cad4f55f-c000.snappy.parquet")
    val outputStream = fs.create(outputPath, true)
    val res = httpClient.newCall(request).execute
    // 文件流下载，远端请求发挥inputStream
    try {
      val inputStream = res.body.byteStream
      val bytesRead = new Array[Byte](1024)
      var length = 0
      while ( {length = inputStream.read(bytesRead); length != -1}){
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
}
