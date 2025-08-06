package thread.scheduler.base

import bean.EnumBean
import redis.RedisServices611

import java.util.concurrent._
import java.util.concurrent.atomic.{AtomicBoolean, AtomicInteger}
import scala.util.control.NonFatal
import com.google.common.util.concurrent.{ListeningExecutorService, MoreExecutors}
import org.json4s.Formats
import org.json4s.ext.EnumNameSerializer
import io.lettuce.core.RedisException
import log.LazyLogging
import org.json4s.DefaultFormats
import thread.NamingThreadFactory
abstract class BaseScheduler(maxRunningNum: Int, threadName: String, queue: String) extends LazyLogging {

  implicit val formats: Formats = DefaultFormats + new EnumNameSerializer(EnumBean)

  val namingThreadFactory = new NamingThreadFactory(s"${this.getClass.getSimpleName}")

  // 并发原子计数，保证多线程共享操作时不出现问题，cas机制
  val remainingExecutors: AtomicInteger = new AtomicInteger(maxRunningNum)

  // Executors为构建的线程池，MoreExecutors.listeningDecorator对ExecutorService做装饰，转换为ListeningExecutorService，可监听任务的执行
  val service: ListeningExecutorService =
    MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(maxRunningNum + 1, namingThreadFactory))

  // 回调执行
  val callBackService: ExecutorService = Executors.newFixedThreadPool(3, namingThreadFactory)

  val stopped: AtomicBoolean = new AtomicBoolean(false)


  logger.info(s"threadName: $threadName, queue: $queue")

  private val eventThread = new Thread(threadName) {

    // 需保证有常驻进程持续执行才可保证该线程的执行
    // 设定该线程为守护线程，当唯一运行的线程都是守护程序线程时，Java虚拟机将退出
    setDaemon(true)

    override def run(): Unit = {
      while (!stopped.get && !service.isShutdown) {
        if (remainingExecutors.get() > 0) {
          var msg: String = null
          try {
            // 进行任务消费
            msg = RedisServices611.getAsyncTask(queue)
            if (msg != null) {
              logger.info(s"$threadName queueType: $queue, consume message: $msg")
              onReceive(msg)
            } else {
              // 队列里面没有任务
              logger.trace(s"$threadName task list is empty")
              Thread.sleep(1000)
            }
          } catch {
            case rse: RedisException =>
              logger.error(s"$threadName abnormal stop!", rse)
              System.exit(-1)
            case NonFatal(e) =>
              logger.error(s"$threadName Unexpected error in $msg", e)
            case e: Exception =>
              e.printStackTrace()
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
    println("Thread start...")
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
