package thread.TheadLock

import bean.LockInfo

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

object CurrentMapLock {

  // 主要用于在多线程环境下存储键值对数据，而不需要使用同步代码块或方法来保证线程安全，允许多个线程同时读写不同段的数据，而不需要获取整个Map的锁
  private val currentMap = new ConcurrentHashMap[String, LockInfo]()
  // fair：公平性，当设置为公平锁时，可以按照线程请求锁的顺序来获取锁
  private val lock = new ReentrantLock(true)

  def lockAction(lockMark: String): LockInfo = {
    // 获取类锁，其他线程无法执行
    lock.lock()
    try {
      println(s"${Thread.currentThread.getName}==>class lock get lockInfo...")
      Thread.sleep(10000)
      var lockInfo = currentMap.get(lockMark)
      if (lockInfo == null) {
        lockInfo = LockInfo(new ReentrantLock(true), new AtomicInteger())
        currentMap.put(lockMark, lockInfo)
      }
      lockInfo
    } finally {
      lock.unlock()
    }
  }

}
