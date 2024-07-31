package scheduler.runner

import bean.{AsyncQueueResponse, CommitInfo, EnumBean}
import constant.ConstantKey
import log.LazyLogging
import org.json4s.ext.EnumNameSerializer
import org.json4s.{DefaultFormats, Formats}
import org.json4s.jackson.Serialization
import redis.RedisServices

import java.util.concurrent.Callable

class CommitRunner(syncInfo: CommitInfo) extends Callable[AsyncQueueResponse] with LazyLogging {
  override def call(): AsyncQueueResponse = {

    implicit val formats: Formats = DefaultFormats + new EnumNameSerializer(EnumBean)

    try {
      RedisServices.setValue(ConstantKey.asyncResult(syncInfo.str, syncInfo.enumType.toString), "1")
      RedisServices.lock(ConstantKey.lockTable(syncInfo.str), "/tb/commit", 1800000)
      // commit执行逻辑
      println(s"commit ${syncInfo.str} execute...")
      val statusCode = 1
      AsyncQueueResponse(statusCode, "errorMsg", "", syncInfo.enumType.toString, "/tb/commit")
    } catch {
      case e: Exception =>
        logger.error(s"commit sync error:  ${syncInfo.str}", e)
        val errMsg = if (e.getMessage == null) e.toString else e.getMessage
        AsyncQueueResponse(1, errMsg, "", syncInfo.enumType.toString, "/tb/commit")
    } finally {
      RedisServices.unLock(ConstantKey.lockTable(syncInfo.str))
    }
  }
}
