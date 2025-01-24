package thread

import com.google.common.util.concurrent.{FutureCallback, Futures, ListenableFuture, ListeningExecutorService, MoreExecutors}
import log.LazyLogging
import io.micrometer.core.instrument.util.NamedThreadFactory
import org.slf4j.MDC

import java.util.concurrent.{ExecutionException, LinkedBlockingQueue, RejectedExecutionException, ThreadPoolExecutor, TimeUnit}
import java.util.concurrent.atomic.AtomicReference
import java.lang._

object ThreadPool extends LazyLogging {

  private val CORE_POOL_SIZE = 5

  private val RESERVE_POOL_SIZE = 5

  private val ALIVE_TIME = 120

  private val BLOCK_NUM = 30

  private val TRACE_ID = "traceId"

  def main(args: Array[String]): Unit = {
    val executorRef = new AtomicReference[ListeningExecutorService]
    executorRef.set(getExecutorService(getThreadPoolExecutor))

    val innerRunnable = new Runnable {
      override def run(): Unit = {
        if (math.random() > 0.5) {
          throw new RuntimeException("Task failed")
        } else {
          logger.info("===========sleep time==============")
          Thread.sleep(5000)
          println("Task completed successfully!")
        }
      }
    }

    val runnable = new Runnable {
      override def run(): Unit = {
        // 当线程池shutdown时需要重新构建ThreadPoolExecutor，实际关闭的是ThreadPoolExecutor而不是ListeningExecutorService
        MDC.put(TRACE_ID, Thread.currentThread.getId.toString)
        while (true) {
          val service = getUsefulExecutorService(executorRef)
          val res: ListenableFuture[_] = service.submit(innerRunnable)
          val callBack = new FutureCallback[String] {

            private val maxRetries = 3
            private var retryCount = 0
            private var isSuccess = false

            override def onSuccess(result: String): Unit = {
              logger.info("success")
              // 模拟关闭
              service.shutdown()
            }

            override def onFailure(t: Throwable): Unit = {
              // 失败重试
              while (retryCount < maxRetries && !isSuccess) {
                retryCount += 1
                val service = getUsefulExecutorService(executorRef)
                logger.warn("Task: failed on attempt {}, retrying... Error: {}", retryCount.toString, t.getMessage, t)
                try {
                  val retryFuture = service.submit(innerRunnable)
                  retryFuture.get
                  isSuccess = true
                  logger.info("Task: succeeded on retry {}", retryCount.toString)
                } catch {
                  case err: Exception =>
                    logger.error("Retry task submission failed, retries: {}, error: {}", retryCount.toString, err.getMessage, err)
                }
              }
              if (isSuccess) {
                logger.info("consume task success has retried {}", retryCount.toString)
                // 模拟关闭
                service.shutdown()
              }
              else {
                logger.error("consume failed, errorMsg: {} end", t.getMessage)
              }
            }
          }
          // FutureCallback与ListenableFuture保证类型一致，_可匹配任意类型
          Futures.addCallback(res.asInstanceOf[ListenableFuture[String]], callBack)
          Thread.sleep(10000)
        }
      }
    }

    val thread = new Thread(runnable, "ThreadPoolTest")
    thread.setDaemon(true)
    thread.start()

    Thread.sleep(Integer.MAX_VALUE)
  }

  private def getThreadPoolExecutor(): ThreadPoolExecutor = {
    new ThreadPoolExecutor(CORE_POOL_SIZE,
      CORE_POOL_SIZE + RESERVE_POOL_SIZE,
      ALIVE_TIME,
      TimeUnit.SECONDS,
      new LinkedBlockingQueue[Runnable](BLOCK_NUM),
      new NamedThreadFactory(this.getClass.getSimpleName))
  }

  private def getExecutorService(planExecutor: ThreadPoolExecutor): ListeningExecutorService = {
    MoreExecutors.listeningDecorator(planExecutor)
  }

  private def getUsefulExecutorService(executorRef: AtomicReference[ListeningExecutorService]): ListeningExecutorService = {
    var service = executorRef.get
    if (service.isShutdown || service.isTerminated) {
      service = getExecutorService(getThreadPoolExecutor())
      logger.warn("The pool has shutdown, service now is {}", if (service.isShutdown || service.isTerminated) "unuseful" else "useful")
      executorRef.set(service)
    }
    service
  }

}
