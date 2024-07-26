package redis

import com.lambdaworks.redis.api.sync.RedisCommands
import com.lambdaworks.redis.{RedisClient, RedisConnectionPool, RedisURI}
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

object RedisServices extends LazyLogging {

  // private val redisPool = RedisConnection.getRedisConnection("bdp-redis", 6679,"h1iz6i2dp4redis")
  private val redisPool = getPoolConnectOld("bdp-redis", 6679,"h1iz6i2dp4redis")

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

  def checkConnection(): Boolean = {
    // val connection = redisPool.borrowObject().asInstanceOf[StatefulRedisClusterConnection[String, String]]
    redisPool.allocateConnection.isOpen
  }

}
