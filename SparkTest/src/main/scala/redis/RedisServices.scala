package redis

import io.lettuce.core.cluster.api.StatefulRedisClusterConnection
import io.lettuce.core.support.ConnectionPoolSupport
import io.lettuce.core.{ClientOptions, RedisClient, RedisURI}
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

object RedisServices extends LazyLogging {

  private val redisPool = RedisConnection.getRedisConnection("bdp-redis", 6679,"h1iz6i2dp4redis")

  def getAsyncTask(queue: String): String = {
    var task: String = null
    val connection = redisPool.borrowObject().asInstanceOf[StatefulRedisClusterConnection[String, String]]
    if (!connection.isOpen) {
      logger.error("redis connect error")
    }
    task = connection.sync().rpop(queue)
    connection.close()
    task
  }

  def checkConnection(): Boolean = {
    val connection = redisPool.borrowObject().asInstanceOf[StatefulRedisClusterConnection[String, String]]
    connection.isOpen
  }

}
