package es

import log.LazyLogging
import org.apache.http.{Header, HttpHost}
import org.apache.http.auth.{AuthScope, UsernamePasswordCredentials}
import org.apache.http.client.config.RequestConfig
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder
import org.apache.http.message.BasicHeader
import org.apache.http.nio.entity.NStringEntity
import org.elasticsearch.action.DocWriteRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.client.{Request, RestClient, RestClientBuilder}
import org.elasticsearch.common.xcontent.{DeprecationHandler, NamedXContentRegistry, XContentBuilder, XContentFactory, XContentType}
import org.json4s.jackson.Serialization.write

import java.io.ByteArrayInputStream
import scala.collection.mutable.ArrayBuffer

object EsUtils extends LazyLogging{

  private var restClient: RestClient = _

  implicit val formats = org.json4s.DefaultFormats

  def main(args: Array[String]): Unit = {
    val esMap = Map("username" -> "",
      "password" -> "",
      "esUrl" -> "localhost:9200"
    )
    initClient(esMap)

    val settingMap = Map("index.number_of_shards" -> "1",
        "index.number_of_replicas" -> "1"
    )
    val mappingMap = Map("_source" -> "{enabled:true}")
    createIndex("testTemplate", settingMap, mappingMap)
  }

  def initClient(esConfig: Map[String, String]): Unit = {

    // 连接权限
    val user: String = esConfig.get("username").getOrElse("")
    val passwd: String = esConfig.get("password").getOrElse("")

    var defaultHeaders: Array[Header] = Array[Header](
      new BasicHeader("Accept", "application/json"),
      new BasicHeader("Content-type", "application/json")
    )
    val credentialsProvider = new BasicCredentialsProvider
    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, passwd))

    val reqConf: RequestConfig = RequestConfig.custom.setConnectTimeout(30 * 1000)
      .setSocketTimeout(30 * 60 * 1000).setConnectionRequestTimeout(30 * 1000).build

    // es地址
    val httpHosts = new ArrayBuffer[HttpHost]()
    val hosts = esConfig.get("esUrl").get.split(";")
    for (hostPort <- hosts) {
      val ipPort: Array[String] = hostPort.split(":")
      httpHosts.+=(new HttpHost(ipPort(0), ipPort(1).toInt, "http"))
    }

    restClient = RestClient.builder(httpHosts: _*)
      .setDefaultHeaders(defaultHeaders)
      .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
        override def customizeHttpClient(httpClientBuilder: HttpAsyncClientBuilder): HttpAsyncClientBuilder = {
          httpClientBuilder.setDefaultRequestConfig(reqConf)
          httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
        }
      }).build()
    logger.info(s"success to create ES client: $restClient")
  }
  def createIndex(index: String, settings: Map[String, AnyRef], mappings: Map[String, AnyRef]): Boolean = {

    // todo: 创建报错
    // setting
    val jsonStr = write(settings)
    val parser = XContentType.JSON.xContent()
      .createParser(
        NamedXContentRegistry.EMPTY,
        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        jsonStr)
    val settingsBuilder = XContentFactory.jsonBuilder()
      .copyCurrentStructure(parser)
    logger.info(s"[Setting] ==> ${jsonStr}")

    // mapping
    val mappingXb: XContentBuilder = XContentFactory.jsonBuilder().startObject()
    for (elem <- mappings) {
      mappingXb.rawField(elem._1, new ByteArrayInputStream(write(elem._2).getBytes), XContentType.JSON)
    }
    val mappingsBuilder = mappingXb.endObject()
    logger.info(s"[Mapping] ==> ${mappingXb.toString}")

    // 索引创建
    val settingRequest: IndexRequest = new IndexRequest(index)
      .source(settingsBuilder)
      .opType(DocWriteRequest.OpType.CREATE)
    val settingSource: String = settingRequest.source().utf8ToString()
    val indexEntity = new NStringEntity(settingSource, ContentType.APPLICATION_JSON)
    val settingHttpRequest = new Request("PUT", index)
    settingHttpRequest.setEntity(indexEntity)
    val indexListener = new EsResponseListener("index")
    restClient.performRequestAsync(settingHttpRequest, indexListener)
    val settingBool = indexListener.get()

    // mapping调整
    val mappingRequest: IndexRequest = new IndexRequest(index)
      .source(mappingsBuilder)
      .opType(DocWriteRequest.OpType.CREATE)
    val mappingSource: String = mappingRequest.source().utf8ToString()
    val mappingEntity = new NStringEntity(mappingSource, ContentType.APPLICATION_JSON)
    val mappingHttpRequest = new Request("PUT", index + "/_mapping")
    mappingHttpRequest.setEntity(mappingEntity)
    val mappingListener = new EsResponseListener("mapping")
    restClient.performRequestAsync(mappingHttpRequest, mappingListener)
    val mappingBool = mappingListener.get()

    if (settingBool && mappingBool) {
      true
    } else {
      false
    }
  }
}
