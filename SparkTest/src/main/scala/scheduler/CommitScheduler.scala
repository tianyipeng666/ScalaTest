package scheduler

import bean.{AsyncQueueMessage, CommitInfo}
import com.google.common.util.concurrent.Futures
import constant.ConstantKey
import log.LazyLogging
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import org.slf4j.MDC
import redis.RedisServices
import scheduler.base.BaseScheduler
import scheduler.callback.CommitCallback
import scheduler.runner.CommitRunner
class CommitScheduler(maxRunningNum: Int, threadName: String, queue: String) extends BaseScheduler(maxRunningNum, threadName, queue) {
  override def onReceive(msg: String): Unit = {
    RedisServices.pushToList(ConstantKey.ASYNC_COMMIT_TMP_TASK, msg)
    val parseMsg = JsonMethods.parse(msg).extract[AsyncQueueMessage]
    val traceId = parseMsg.traceId
    MDC.put("traceId", s" [$traceId]")
    logger.info(s"consume commit task: $traceId")
    val commitInfo = JsonMethods.parse(parseMsg.data).extract[CommitInfo]
    val tbName = commitInfo.tbName
    remainingExecutors.decrementAndGet()
    val resultFuture = try {

      // 提交执行
      service.submit(new CommitRunner(commitInfo))
    } catch {
      case e: Exception =>
        remainingExecutors.incrementAndGet()
        logger.error(s"commit sync error, $commitInfo", e)
        throw e
    }

    // 执行完回调
    val callback = new CommitCallback(tbName, commitInfo.traceId, remainingExecutors, threadName, msg)
    Futures.addCallback(resultFuture, callback, callBackService)
  }
}


object CommitScheduler extends LazyLogging {
  private val maxRunningNum = 10
  private val threadName = "commit-async"
  private val queue = ConstantKey.ASYNC_COMMIT_TASK
  private lazy val scheduler = new CommitScheduler(maxRunningNum, threadName, queue)
  implicit val formats: DefaultFormats.type = DefaultFormats

  def start(): Unit = {
    // 启动时从之前执行未终止任务恢复
    RedisServices.recoveryTmpTask(ConstantKey.ASYNC_COMMIT_TMP_TASK, ConstantKey.ASYNC_COMMIT_TASK).foreach {task =>
      val parseMsg = JsonMethods.parse(task).extract[AsyncQueueMessage]
      val syncInfo = JsonMethods.parse(parseMsg.data).extract[CommitInfo]
      // 把0初始化和1执行中的状态均改为3失败
      // DbService().updateFTPFileStatusByTbName(syncInfo.tbName, 3, Seq(0, 1))
      logger.warn(s"recovery commit task: ${syncInfo.tbName} [${syncInfo.traceId}]")
    }
    scheduler.start()
  }

  def stop(): Unit = {
    if (scheduler != null) {
      scheduler.stop()
    }
  }
}
