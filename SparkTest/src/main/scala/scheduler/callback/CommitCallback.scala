package scheduler.callback

import bean.AsyncQueueResponse
import com.google.common.util.concurrent.FutureCallback
import constant.ConstantKey
import log.LazyLogging
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization
import org.slf4j.MDC
import redis.RedisServices

import java.util.concurrent.atomic.AtomicInteger
class CommitCallback(tbName: String,
                     traceId: String,
                     remainingExecutors: AtomicInteger,
                     threadName: String,
                     msg: String) extends FutureCallback[AsyncQueueResponse] with LazyLogging {

  implicit val formats: DefaultFormats.type = DefaultFormats
  private val redisKey = ConstantKey.asyncResult(tbName, traceId)

  override def onSuccess(result: AsyncQueueResponse): Unit = {
    remainingExecutors.incrementAndGet()
    // 执行成功移除
    RedisServices.removeFromList(ConstantKey.ASYNC_COMMIT_TMP_TASK, msg)
    logger.debug(s"commit sync result: $result")
    if (result.status == 0) {
      logger.info(s"commit sync success, $traceId")
    } else {
      logger.error(s"commit sync error, $traceId, ${result.errMsg}")
      // fixFileStatus(tbName)
    }
    RedisServices.setValue(redisKey, Serialization.write(result), 180000)
    MDC.remove("traceId")
  }

  override def onFailure(t: Throwable): Unit = {
    remainingExecutors.incrementAndGet()
    RedisServices.removeFromList(ConstantKey.ASYNC_COMMIT_TMP_TASK, msg)
    logger.error(s"commit sync error, $traceId", t)
    val result = AsyncQueueResponse(1, t.getMessage, "", traceId, "/tb/commit")
    RedisServices.setValue(redisKey, Serialization.write(result), 180000)
    // fixFileStatus(tbName)
    MDC.remove("traceId")
  }

  /**
   * 全部状态为初始化或同步中的都修改为失败，并删除被标记为删除的条目
   */
//  def fixFileStatus(tbName: String): Unit = {
//    val dbService = new DbService
//    val deletedCount = dbService.deleteFTPFile(tbName, softDelete = false)
//    logger.info("delete {} ftp files from database where tbName = {}", deletedCount, tbName)
//    dbService.updateFTPFileStatusByTbName(tbName, 3, Seq(0, 1))
//  }
}
