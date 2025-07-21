package thread.scheduler

import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalDateTime}
import java.time.temporal.ChronoUnit
import java.util.concurrent.{Executors, ScheduledExecutorService, TimeUnit}

object DesignatedTimeScheduler {

  // 单线程调度器，底层线程为非daemon，JVM会保持运行
  private val scheduler: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
  private val timeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  /** 计算从现在到下一个 “:00” 或 “:30” 的整秒延迟 */
  private def computeInitialDelaySeconds(): Long = {
    val now = LocalDateTime.now()
    val nextRun = now.plusMinutes(5 - (now.getMinute % 5)).withSecond(0).withNano(0)
    val dur = Duration.between(now, nextRun)
    val secs = dur.getSeconds
    if (dur.getNano > 0) secs + 1 else secs
  }

  // 固定间隔：5 分钟
  private val periodSeconds = 5 * 60L

  /** 启动调度器 */
  def start(): Unit = {
    val initialDelay = computeInitialDelaySeconds()
    scheduler.scheduleAtFixedRate(
      new Runnable {
        override def run(): Unit = {
          // ==== 你的定时业务逻辑 ====
          println(s"[${LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(timeFormat)}] >>> 定时任务执行")
        }
      },
      initialDelay,
      periodSeconds,
      TimeUnit.SECONDS
    )

    println(s"Scheduler 启动：首次延迟 ${initialDelay}s，之后每 ${periodSeconds / 60} 分钟执行一次")
  }

  /** 停止调度器（可选） */
  def stop(): Unit = {
    scheduler.shutdown()
    if (!scheduler.awaitTermination(5, TimeUnit.SECONDS))
      scheduler.shutdownNow()
    println("Scheduler已停止")
  }

}
