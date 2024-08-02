package thread

import thread.scheduler.CommitScheduler

object ShutdownThread {

  def listenShutdown(): Unit = {
    Runtime.getRuntime.addShutdownHook(
      new Thread() {
        override def run() {
          CommitScheduler.stop()
        }
      }
    )
  }
}
