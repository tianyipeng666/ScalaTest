package redis

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.{RedisClient, RedisURI, ScriptOutputType, SetArgs}

import scala.jdk.CollectionConverters.asScalaBufferConverter
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection
import io.lettuce.core.resource.{ClientResources, DefaultClientResources}
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

import java.time.Duration
import java.util
import scala.collection.mutable

object RedisServices extends LazyLogging {

  private var redisClient = getRedisClient("bdp-redis", 6679, "h1iz6i2dp4redis")
  // 常用命令连接
  private var connection = getConnection()
  // channel连接
  private var connectionPubSub = getConnectionPubSub()

  private def getRedisClient(redisHost: String, redisPort: Int, password: String): RedisClient = {
    if (redisClient != null) {
      return redisClient
    }

    val redisUri = if (!password.isEmpty) {
      RedisURI.Builder.redis(redisHost, redisPort)
        .withPassword(password.toCharArray).build()
    } else {
      RedisURI.Builder.redis(redisHost, redisPort).build()
    }
    val resource: ClientResources = DefaultClientResources.builder()
      .ioThreadPoolSize(3)
      .computationThreadPoolSize(3)
      .build()
    val client = RedisClient.create(resource, redisUri)
    client
  }

  private def getConnection(): StatefulRedisConnection[String, String] = {
    if (connection != null) {
      return connection
    }
    if (redisClient == null) {
      redisClient = getRedisClient("bdp-redis", 6679, "h1iz6i2dp4redis")
    }
    connection = redisClient.connect()
    connection.setTimeout(Duration.ofSeconds(10))
    connection
  }

  private def getConnectionPubSub(): StatefulRedisConnection[String, String] = {
    if (connectionPubSub != null) {
      return connectionPubSub
    }
    if (redisClient == null) {
      redisClient = getRedisClient("bdp-redis", 6679, "h1iz6i2dp4redis")
    }
    connectionPubSub = redisClient.connectPubSub()
    connectionPubSub.setTimeout(Duration.ofSeconds(10))
    connectionPubSub
  }

  private def withConnectionNull[U](logic: Unit => U): U = {
    // 逻辑执行前判断并初始化连接
    if (connection == null) {
      getConnection
    }
    logic(null)
  }

  def getAsyncTask(queue: String): String = withConnectionNull { _ =>
    var task: String = null
    try {
      if (!connection.isOpen) {
        logger.error("redis connect error")
      }
      task = connection.sync().rpop(queue)
      task
    } catch {
      case e: Exception =>
        e.printStackTrace()
        task
    }
  }

  def pushToList(key: String, value: String): Long = withConnectionNull { _ =>
    connection.sync().rpush(key, value)
  }

  def recoveryTmpTask(fromQueue: String, toQueue: String): Seq[String] = withConnectionNull { _ =>
    val taskList = connection.sync().lrange(fromQueue, 0, -1).asScala
    taskList.foreach { task =>
      pushToList(toQueue, task)
      removeFromList(fromQueue, task)
    }
    taskList
  }

  def removeFromList(key: String, value: String): Long = withConnectionNull { _ =>
    connection.sync().lrem(key, -1, value)
  }

  def setValue(key: String, value: String, expire: Int = -1): String = withConnectionNull { _ =>
    var res = ""
    if (expire > 0) {
      res = connection.sync().set(key, value, SetArgs.Builder.ex(expire.asInstanceOf[Long]))
    } else {
      res = connection.sync().set(key, value)
    }
    res
  }

  def lock(key: String, value: String, expireTime: Long): Unit = withConnectionNull { _ =>
    var retryCount = 0
    while (retryCount <= expireTime) {
      if (retryCount == expireTime) {
        connection.sync().del(key)
      }
      val res = connection.sync().setnx(key, value)
      if (res) {
        connection.sync().expire(key, expireTime / 1000)
        return
      } else {
        retryCount = retryCount + 1000
        Thread.sleep(1000)
      }
    }
  }

  def unLock(key: String): Long = withConnectionNull { _ =>
    connection.sync().del(key)
  }

  def putAsyncValue(value: String, key: String): Long = withConnectionNull { _ =>
    connection.sync().lpush(key, value)
  }

  def checkConnection(): Boolean = withConnectionNull { _ =>
    connection.isOpen
  }

  // lua
  // 原子性：Lua脚本可以保证操作的原子性。当一个脚本在执行时，Redis会阻塞其他对这个数据库的所有操作，直到脚本执行完成
  // 批处理：Lua脚本可以一次性处理多个键值对，这对于需要批量操作的场景非常有用
  // 安全性：Lua脚本包装某些操作可以避免使用潜在不安全的命令，如EVALSHA可以避免脚本注入攻击

  // 标准写法：KEY[]为脚本传参的key，ARGV[]为脚本传参的value
  private val LuaScript: String =
  """
    |if redis.call("GET",KEYS[1]) == ARGV[1]
    |then
    |    return redis.call("DEL",KEYS[1])
    |else
    |    return redis.call("GET",KEYS[1])
    |end
    |""".stripMargin
  private val Sha1Map: mutable.Map[String, String] = mutable.Map()
  private val ScriptMap: Map[String, String] = Map("getOrDel" -> LuaScript)
  // lua脚本注册
  def registerLuaScript(): Unit = withConnectionNull { _ =>
    ScriptMap.foreach {
      case (name, script) => Sha1Map.put(name, connection.sync.scriptLoad(script))
        logger.info(s"[Redis_LUA] name: $name, sha: ${Sha1Map(name)}")
    }
  }

  def getOrDel(key: String, value: String): String = withConnectionNull { _ =>
    try {
      connection.sync().evalsha(Sha1Map("getOrDel"), ScriptOutputType.MULTI, Array(key), value)
        .asInstanceOf[util.ArrayList[Object]].asScala.toList.head.toString
    } catch {
      case exception: Exception =>
        registerLuaScript()
        logger.warn("The script has been register again, please get the result again...")
        connection.sync().evalsha(Sha1Map("getOrDel"), ScriptOutputType.MULTI, Array(key), value)
          .asInstanceOf[util.ArrayList[Object]].asScala.toList.head.toString
    }
  }
}
