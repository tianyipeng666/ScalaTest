package redis

import com.lambdaworks.redis.api.sync.RedisCommands
import com.lambdaworks.redis.{RedisClient, RedisConnectionPool, RedisURI, SetArgs}

import scala.jdk.CollectionConverters.asScalaBufferConverter
// import io.lettuce.core.cluster.api.StatefulRedisClusterConnection
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

object RedisServices extends LazyLogging {

  // private val redisPool = RedisConnection.getRedisConnection("bdp-redis", 6679,"h1iz6i2dp4redis")
  private val redisPool = getPoolConnectOld("bdp-redis", 6679, "h1iz6i2dp4redis")

  def getPoolConnectOld(redisHost: String, redisPort: Int, password: String): RedisConnectionPool[RedisCommands[String, String]] = {
    val redisUri = if (password.isEmpty) {
      RedisURI.Builder.redis(redisHost, redisPort)
        .withPassword(password).build()
    } else {
      RedisURI.Builder.redis(redisHost, redisPort).build()
    }
    val redisClient = RedisClient.create(redisUri)
    redisClient.pool()
  }

  def getAsyncTask(queue: String): String = {
    var task: String = null
    // val connection = redisPool.borrowObject().asInstanceOf[StatefulRedisClusterConnection[String, String]]
    val connection = redisPool.allocateConnection
    if (!connection.isOpen) {
      logger.error("redis connect error")
    }
    task = connection.rpop(queue)
    connection.close()
    task
  }

  def pushToList(key: String, value: String): Long = {
    val connection = redisPool.allocateConnection
    val value = connection.rpush(key, value)
    connection.close()
    value
  }

  def recoveryTmpTask(fromQueue: String, toQueue: String): Seq[String] = {
    val connection = redisPool.allocateConnection
    val taskList = connection.lrange(fromQueue, 0, -1).asScala
    connection.close()
    taskList.foreach {task =>
      pushToList(toQueue, task)
      removeFromList(fromQueue, task)
    }
    taskList
  }

  def removeFromList(key: String, value: String): Long = {
    val connection = redisPool.allocateConnection
    val count = connection.lrem(key, -1, value)
    connection.close()
    count
  }

  def setValue(key: String, value: String, expire: Int = -1): String = {
    val connection = redisPool.allocateConnection
    var res = ""
    if (expire > 0) {
      res = connection.set(key, value, SetArgs.Builder.ex(expire.asInstanceOf[Long]))
    } else {
      res = connection.set(key, value)
    }
    connection.close()
    res
  }

  def lock(key: String, value: String, expireTime: Long): Unit = {
    val connection = redisPool.allocateConnection
    var retryCount = 0
    while (retryCount <= expireTime) {
      if (retryCount == expireTime) {
        connection.del(key)
      }
      val res = connection.setnx(key, value)
      if (res) {
        connection.expire(key, expireTime / 1000)
        return
      } else {
        retryCount = retryCount + 1000
        Thread.sleep(1000)
      }
    }
    connection.close()
  }

  def unLock(key: String): Long = {
    val connection = redisPool.allocateConnection
    val count = connection.del(key)
    connection.close()
    count
  }

  def checkConnection(): Boolean = {
    // val connection = redisPool.borrowObject().asInstanceOf[StatefulRedisClusterConnection[String, String]]
    // connection.isOpen
    redisPool.allocateConnection.isOpen

  }

}
