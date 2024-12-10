package es

import log.LazyLogging
import org.elasticsearch.client.{Response, ResponseListener}

class EsResponseListener(requestType: String) extends ResponseListener with LazyLogging{

  // 0:初始 1:成功 2:失败
  private var resultCode: Int = 0

  // 超时时间
  private val TIMEOUT: Long = 20000L
  override def onSuccess(response: Response): Unit = {
    resultCode = 1
  }

  override def onFailure(e: Exception): Unit = {
    resultCode = 2
    System.err.println(e.getMessage)
    throw e
  }

  def get(): Boolean = {
    var timeCount: Long = 0L
    var executionResult: Boolean = false
    while (resultCode == 0) {
      if (timeCount >= TIMEOUT) {
        logger.warn(s"requestType [${requestType}] ==> timeout $TIMEOUT ms to get response from es")
        return false
      }
      try {
        logger.info(s"requestType [${requestType}] ==> get response from es")
        Thread.sleep(1000)
        timeCount += 1000
      } catch {
        case e: Exception =>
          e.printStackTrace()
          return false
      }
    }
    executionResult = resultCode == 1
    executionResult
  }
}
