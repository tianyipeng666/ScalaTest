package bean

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

case class LockInfo (lock: ReentrantLock, concurrentNum: AtomicInteger)
