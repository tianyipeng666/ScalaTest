package redis

import io.lettuce.core.api.{StatefulConnection, StatefulRedisConnection}
import io.lettuce.core.{RedisClient, RedisURI, ScriptOutputType, SetArgs}
import scala.jdk.CollectionConverters.asScalaBufferConverter
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection
import io.lettuce.core.resource.{ClientResources, DefaultClientResources}
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import java.time.Duration
import java.util
import scala.collection.mutable
import conf.ConfParseUtils
import io.lettuce.core.api.sync.RedisCommands
import io.lettuce.core.cluster.RedisClusterClient
import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection
import io.lettuce.core.pubsub.{RedisPubSubListener, StatefulRedisPubSubConnection}
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands
import java.lang.reflect.{InvocationHandler, Method, Proxy}
import scala.collection.JavaConverters._

/**
 * lettuce6.1.1
 */
object RedisServices611 extends LazyLogging {

  @volatile private var commonConn: StatefulRedisConnection[String, String] = _
  @volatile private var clusterConn: StatefulRedisClusterConnection[String, String] = _
  @volatile private var redis: RedisCommands[String, String] = _
  @volatile private var pubsub: RedisPubSubCommands[String, String] = _
  @volatile private var pubsubConn: StatefulRedisPubSubConnection[String, String] = _

  private val mode: String = ConfParseUtils.redisMode.toLowerCase

  private val resource: ClientResources = DefaultClientResources.builder()
    .ioThreadPoolSize(30)
    .computationThreadPoolSize(10)
    .build()

  val listener = new RedisPubSubListener[String, String] {

    override def message(channel: String, message: String): Unit = {
      logger.info(s"[RedisPubSubAdapter] channel=$channel, msg=$message")
      channel match {
        case "redisChannelTest1" => println(s"get redisChannelTest1 message => ${message}")
      }
    }

    override def message(pattern: String, channel: String, message: String): Unit = {
      println(s"get message")
    }

    override def punsubscribed(pattern: String, count: Long): Unit = {
      println(s"get punsubscribed")
    }

    override def subscribed(channel: String, count: Long): Unit = {
      println(s"get subscribed")
    }

    override def unsubscribed(channel: String, count: Long): Unit = {
      println(s"get unsubscribed")
    }

    override def psubscribed(pattern: String, count: Long): Unit = {
      println(s"get psubscribed")
    }
  }

  private lazy val standaloneClient: RedisClient = {
    val b = RedisURI.Builder.redis(ConfParseUtils.redisHost, ConfParseUtils.redisPort)
    if (ConfParseUtils.redisPassword.nonEmpty) b.withPassword(ConfParseUtils.redisPassword.toCharArray)
    RedisClient.create(resource, b.build())
  }
  private lazy val sentinelClient: RedisClient = {
    val head = ConfParseUtils.redisSentinelHostPort.head
    val b = RedisURI.Builder.sentinel(head._1, head._2)
      .withSentinelMasterId(ConfParseUtils.redisSentinelMaterId)
    ConfParseUtils.redisSentinelHostPort.tail.foreach { case (h, p) => b.withSentinel(h, p) }
    if (ConfParseUtils.redisPassword.nonEmpty) b.withPassword(ConfParseUtils.redisPassword.toCharArray)
    RedisClient.create(resource, b.build())
  }
  // Cluster 专用的 RedisClusterClient
  private lazy val clusterClient: RedisClusterClient = {
    val uris = ConfParseUtils.redisClusterNodes.map { case (h, p) =>
      val u = RedisURI.Builder.redis(h, p)
      if (ConfParseUtils.redisPassword.nonEmpty) u.withPassword(ConfParseUtils.redisPassword.toCharArray)
      u.build()
    }.asJava
    RedisClusterClient.create(resource, uris)
  }

  private def getStandaloneConn(): StatefulRedisConnection[String, String] = synchronized {
    if (commonConn == null) {
      commonConn = standaloneClient.connect()
      commonConn.setTimeout(Duration.ofSeconds(10))
    }
    commonConn
  }
  private def getSentinelConn(): StatefulRedisConnection[String, String] = synchronized {
    if (commonConn == null) {
      commonConn = sentinelClient.connect()
      commonConn.setTimeout(Duration.ofSeconds(10))
    }
    commonConn
  }
  private def getClusterConn(): StatefulRedisClusterConnection[String, String] = synchronized {
    if (clusterConn == null) {
      clusterConn = clusterClient.connect()
      clusterConn.setTimeout(Duration.ofSeconds(10))
    }
    clusterConn
  }

  private def getRedisConnectionSync(): RedisCommands[String, String] = synchronized {
    if (redis == null) {
      mode match {
        case "cluster" => {
          // 同450，通过动态代理
          val advClusterCommands = getClusterConn().sync()
          val handler = new InvocationHandler {
            override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef = {
              method.invoke(advClusterCommands, args: _*)
            }
          }
          redis = Proxy.newProxyInstance(
            classOf[RedisCommands[_, _]].getClassLoader,
            Array(classOf[RedisCommands[String, String]]),
            handler
          ).asInstanceOf[RedisCommands[String, String]]
        }
        case "sentinel" =>
          redis = getSentinelConn().sync()
        case "standalone" =>
          redis = getStandaloneConn().sync()
      }
    }
    redis
  }

  private def getRedisConnectionPubSubSync(): RedisPubSubCommands[String, String] = synchronized {
    if (pubsub == null) {
      pubsub = getRedisPubSubConnection.sync()
    }
    pubsub
  }

  // StatefulRedisClusterPubSubConnection继承自StatefulRedisPubSubConnection，统一返回
  private def getRedisPubSubConnection(): StatefulRedisPubSubConnection[String, String] = synchronized {
    if (pubsubConn == null) {
      mode match {
        case "cluster" =>
          val pubsubClusterConn = clusterClient.connectPubSub()
          pubsubClusterConn.setNodeMessagePropagation(true)
          pubsubClusterConn.setTimeout(Duration.ofSeconds(10))
          pubsubConn = pubsubClusterConn
        case "sentinel" =>
          val pubsubSentinelConn = sentinelClient.connectPubSub()
          pubsubSentinelConn.setTimeout(Duration.ofSeconds(10))
          pubsubConn = pubsubSentinelConn
        case "standalone" =>
          val pubsubStandaloneConn = standaloneClient.connectPubSub()
          pubsubStandaloneConn.setTimeout(Duration.ofSeconds(10))
          pubsubConn = pubsubStandaloneConn
      }
    }
    pubsubConn
  }


  private def withPubSubCommandNull[U](logic: Unit => U): U = {
    if (pubsub == null) {
      getRedisConnectionPubSubSync
    }
    logic(null)
  }

  private def withPubSubConnectionNull[U](logic: Unit => U): U = {
    if (pubsubConn == null) {
      getRedisPubSubConnection
    }
    logic(null)
  }

  private def withRedisNull[U](logic: Unit => U): U = {
    if (redis == null) {
      getRedisConnectionSync
    }
    logic(null)
  }

  def subscribeChannel(channel: String): Unit = withPubSubCommandNull { _ =>
    // 需要保证添加listener与订阅channel的连接是同一个
    pubsub.subscribe(channel)
    println("complete subscribeChannel")
  }

  def addPubSubListener(listener: RedisPubSubListener[String, String]): Unit = withPubSubConnectionNull { _ =>
    pubsubConn.addListener(listener)
  }

  def publish(channel: String, value: String): Long = withRedisNull { _ =>
    redis.publish(channel, value)
  }

  def getAsyncTask(queue: String): String = withRedisNull { _ =>
    var task: String = null
    try {
      if (!redis.isOpen) {
        logger.error("redis connect error")
      }
      task = redis.rpop(queue)
      task
    } catch {
      case e: Exception =>
        e.printStackTrace()
        task
    }
  }

  def pushToList(key: String, value: String): Long = withRedisNull { _ =>
    redis.rpush(key, value)
  }

  def recoveryTmpTask(fromQueue: String, toQueue: String): Seq[String] = withRedisNull { _ =>
    val taskList = redis.lrange(fromQueue, 0, -1).asScala
    taskList.foreach { task =>
      pushToList(toQueue, task)
      removeFromList(fromQueue, task)
    }
    taskList
  }

  def removeFromList(key: String, value: String): Long = withRedisNull { _ =>
    redis.lrem(key, -1, value)
  }

  def setValue(key: String, value: String, expire: Int = -1): String = withRedisNull { _ =>
    var res = ""
    if (expire > 0) {
      res = redis.set(key, value, SetArgs.Builder.ex(expire.asInstanceOf[Long]))
    } else {
      res = redis.set(key, value)
    }
    res
  }

  def lock(key: String, value: String, expireTime: Long): Unit = withRedisNull { _ =>
    var retryCount = 0
    while (retryCount <= expireTime) {
      if (retryCount == expireTime) {
        redis.del(key)
      }
      val res = redis.setnx(key, value)
      if (res) {
        redis.expire(key, expireTime / 1000)
        return
      } else {
        retryCount = retryCount + 1000
        Thread.sleep(1000)
      }
    }
  }

  def unLock(key: String): Long = withRedisNull { _ =>
    redis.del(key)
  }

  def putAsyncValue(value: String, key: String): Long = withRedisNull { _ =>
    redis.lpush(key, value)
  }

  def checkConnection(): Boolean = withRedisNull { _ =>
    redis.isOpen
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
  def registerLuaScript(): Unit = withRedisNull { _ =>
    ScriptMap.foreach {
      case (name, script) => Sha1Map.put(name, redis.scriptLoad(script))
        logger.info(s"[Redis_LUA] name: $name, sha: ${Sha1Map(name)}")
    }
  }

  def getOrDel(key: String, value: String): String = withRedisNull { _ =>
    try {
      redis.evalsha(Sha1Map("getOrDel"), ScriptOutputType.MULTI, Array(key), value)
        .asInstanceOf[util.ArrayList[Object]].asScala.toList.head.toString
    } catch {
      case exception: Exception =>
        registerLuaScript()
        logger.warn("The script has been register again, please get the result again...")
        redis.evalsha(Sha1Map("getOrDel"), ScriptOutputType.MULTI, Array(key), value)
          .asInstanceOf[util.ArrayList[Object]].asScala.toList.head.toString
    }
  }
}
