package scheduler.runner

import bean.{AsyncQueueResponse, CommitInfo}
import constant.ConstantKey
import log.LazyLogging
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization
import redis.RedisServices

import java.util.concurrent.Callable
class CommitRunner(syncInfo: CommitInfo) extends Callable[AsyncQueueResponse] with LazyLogging {
  override def call(): AsyncQueueResponse = {
    implicit val formats: DefaultFormats.type = DefaultFormats
    try {
      RedisServices.setValue(ConstantKey.asyncResult(syncInfo.tbName, syncInfo.traceId), "1")
      RedisServices.lock(ConstantKey.lockTable(syncInfo.tbName), "/tb/commit", 1800000)
      // commit执行逻辑
      println(s"commit ${syncInfo.tbName} execute...")
      val statusCode = 1
      AsyncQueueResponse(statusCode, "errorMsg", "", syncInfo.traceId, "/tb/commit")
    } catch {
      case e: Exception =>
        logger.error(s"commit sync error:  ${syncInfo.tbName}", e)
        val errMsg = if (e.getMessage == null) e.toString else e.getMessage
        AsyncQueueResponse(1, errMsg, "", syncInfo.traceId, "/tb/commit")
    } finally {
      RedisServices.unLock(ConstantKey.lockTable(syncInfo.tbName))
    }
  }
}
