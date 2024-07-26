package scheduler.base

import redis.RedisServices
import java.util.concurrent._
import java.util.concurrent.atomic.{AtomicBoolean, AtomicInteger}
import scala.util.control.NonFatal
import com.google.common.util.concurrent.{ListeningExecutorService, MoreExecutors}
import io.lettuce.core.RedisException
import log.LazyLogging
import org.json4s.DefaultFormats
import thread.NamingThreadFactory
abstract class BaseScheduler(maxRunningNum: Int, threadName: String, queue: String) extends LazyLogging {
  implicit val formats: DefaultFormats.type = DefaultFormats

  val namingThreadFactory = new NamingThreadFactory(s"${this.getClass.getSimpleName}")
  val remainingExecutors: AtomicInteger = new AtomicInteger(maxRunningNum)
  val service: ListeningExecutorService =
    MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(maxRunningNum + 1, namingThreadFactory))
  val callBackService: ExecutorService = Executors.newFixedThreadPool(5, namingThreadFactory)
  val stopped: AtomicBoolean = new AtomicBoolean(false)

  logger.info(s"threadName: $threadName, queue: $queue")

  private val eventThread = new Thread(threadName) {
    setDaemon(true)
    override def run(): Unit = {
      while (!stopped.get && !service.isShutdown) {
        if (remainingExecutors.get() > 0) {
          var msg: String = null
          try {
            // 进行任务消费
            msg = RedisServices.getAsyncTask(queue)
            if (msg != null) {
              logger.info(s"$threadName queueType: $queue, consume message: $msg")
              onReceive(msg)
            } else {
              logger.trace(s"$threadName task list is empty")
              Thread.sleep(1000) // 队列里面没有任务
            }
          } catch {
            case rse: RedisException =>
              logger.error(s"$threadName Mobius abnormal stop!", rse)
              System.exit(-1)
            case NonFatal(e) =>
              logger.error(s"$threadName Unexpected error in $msg", e)
          }
        } else {
          logger.warn(s"$threadName 已达到并发上限: $maxRunningNum, 等待 1 秒.")
          Thread.sleep(1000)
        }
        onScheduler()
      }
    }
  }

  def runningTaskNum: Int = maxRunningNum - remainingExecutors.get()

  def decExecutors(): Unit = {
    remainingExecutors.getAndDecrement()
  }

  def incrExecutors(): Unit = {
    remainingExecutors.getAndIncrement()
  }

  def start(): Unit = {
    if (stopped.get()) {
      throw new IllegalStateException(s"Task $threadName scheduler has already been stopped")
    }
    logger.info(s"------------start $threadName scheduling----------------")
    if (eventThread.isAlive) {
      return
    }
    eventThread.start()
  }

  def stop(): Unit = {
    logger.info(s"------------stop $threadName scheduling-----------------")
    if(stopped.compareAndSet(false, true)) {
      while (runningTaskNum > 0) {
        logger.info(s"$threadName has $runningTaskNum remaining task(s), waiting")
        Thread.sleep(10000)
      }
      logger.info(s"$threadName no remaining task, stopping")
      Thread.sleep(1000)
      callBackService.shutdown()
      service.shutdown()
      logger.warn(s"${Thread.currentThread().getName} invoke interrupt on ${eventThread.getName}")
      try {
        eventThread.interrupt()
        eventThread.join()
      } catch {
        case e: InterruptedException =>
          logger.error(s"${eventThread.getName} throw Exception, Interrupted: ${eventThread.isInterrupted}", e)
      }
    }
  }

  def onReceive(msg: String): Unit

  /**
   * 在循环中调用，可以做一些检查工作
   */
  def onScheduler(): Unit = {
    logger.trace(s"$threadName onScheduler")
  }
}
