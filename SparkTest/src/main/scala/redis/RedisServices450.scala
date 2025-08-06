package redis

import conf.ConfParseUtils
import com.lambdaworks.redis.{RedisClient, RedisConnectionPool, RedisURI}
import com.lambdaworks.redis.api.sync.RedisCommands
import com.lambdaworks.redis.cluster.RedisClusterClient
import com.lambdaworks.redis.cluster.api.StatefulRedisClusterConnection
import com.lambdaworks.redis.cluster.api.sync.RedisAdvancedClusterCommands
import com.lambdaworks.redis.pubsub.{RedisPubSubListener, StatefulRedisPubSubConnection}
import com.lambdaworks.redis.support.ConnectionPoolSupport
import log.LazyLogging
import org.apache.commons.pool2.impl.GenericObjectPoolConfig

import java.lang.reflect.{InvocationHandler, Method, Proxy}
import java.util.function.Supplier
import scala.collection.JavaConverters._

/**
 * lettuce4.5.0
 */
object RedisServices450 extends LazyLogging {

  // 1. 三种模式：standalone | sentinel | cluster
  private val mode: String = ConfParseUtils.redisMode.toLowerCase
  val connection: RedisCommands[String, String] = redisConnection

  // 2. 分别构造 URI
  private lazy val standaloneUri: RedisURI = {
    val b = RedisURI.Builder.redis(ConfParseUtils.redisHost, ConfParseUtils.redisPort)
    if (ConfParseUtils.redisPassword.nonEmpty) b.withPassword(ConfParseUtils.redisPassword)
    b.build()
  }
  private lazy val sentinelUri: RedisURI = {
    val head = ConfParseUtils.redisSentinelHostPort.head
    val b = RedisURI.Builder
      .sentinel(head._1, head._2)
      .withSentinelMasterId(ConfParseUtils.redisSentinelMaterId)
    ConfParseUtils.redisSentinelHostPort.tail.foreach { case (h, p) => b.withSentinel(h, p) }
    if (ConfParseUtils.redisPassword.nonEmpty) b.withPassword(ConfParseUtils.redisPassword)
    b.build()
  }
  private lazy val clusterUris: Seq[RedisURI] =
    ConfParseUtils.redisClusterNodes.map { case (h, p) =>
      val b = RedisURI.Builder.redis(h, p)
      if (ConfParseUtils.redisPassword.nonEmpty) b.withPassword(ConfParseUtils.redisPassword)
      b.build()
    }

  // 3. 三种客户端
  private lazy val standaloneClient: RedisClient = RedisClient.create(standaloneUri)
  private lazy val sentinelClient: RedisClient = RedisClient.create(sentinelUri)
  private lazy val clusterClient: RedisClusterClient = RedisClusterClient.create(clusterUris.asJava)

  //scala2.12写法，2.11不支持
  //private lazy val clusterPool = ConnectionPoolSupport.createGenericObjectPool(() => clusterClient.connect(), new GenericObjectPoolConfig())
  private lazy val clusterPool = {
    val supplier = new Supplier[StatefulRedisClusterConnection[String, String]] {
      override def get(): StatefulRedisClusterConnection[String, String] =
        clusterClient.connect()
    }
    val cfg = new GenericObjectPoolConfig[StatefulRedisClusterConnection[String, String]]()
    ConnectionPoolSupport.createGenericObjectPool(supplier, cfg)
  }
  private lazy val sentinelPool = sentinelClient.pool()
  private lazy val standalonePool = standaloneClient.pool()

  /**
   * 返回一个“连接池”：
   * - Standalone/Sentinel：复用 Lettuce 的 `RedisClient.pool()`
   * - Cluster：使用 `ConnectionPoolSupport` 创建 `GenericObjectPool[StatefulRedisClusterConnection]` :contentReference[oaicite:0]{index=0}
   */
  def redisConnection(): RedisCommands[String, String] = mode match {
    case "cluster" =>
      val clusterConn = clusterPool.borrowObject()
      val adv: RedisAdvancedClusterCommands[String, String] = clusterConn.sync()

      // InvocationHandler：把所有调用都转给 adv
      val handler = new InvocationHandler {
        override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef =
          method.invoke(adv, args: _*)
      }

      // 只实现 RedisCommands 一个接口，避免 getStatefulConnection 冲突
      Proxy.newProxyInstance(
        classOf[RedisCommands[_, _]].getClassLoader,
        // 只放 RedisCommands
        Array(classOf[RedisCommands[_, _]]),
        handler
      ).asInstanceOf[RedisCommands[String, String]]
    case "sentinel" =>
      // Lettuce 内置的哨兵连接池
      sentinelPool.allocateConnection()
    case _ =>
      // 单节点连接池
      standalonePool.allocateConnection()
  }

  /**
   * 返回底层 Client：
   * - Standalone/Sentinel：`RedisClient`
   * - Cluster：`RedisClusterClient`
   */
  def redisClient: StatefulRedisPubSubConnection[String, String] = {
    val conn = mode match {
      case "cluster" =>
        // StatefulRedisClusterPubSubConnection[String,String]是子类
        val pubsubConn = clusterClient.connectPubSub()
        // pubsubConn.setNodeMessagePropagation(true)
        pubsubConn
      case "sentinel" =>
        sentinelClient.connectPubSub()
      case _ =>
        standaloneClient.connectPubSub()
    }
    conn.addListener(listener)
    conn
  }

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

  def exist(key: String*): Boolean = {
    connection.exists(key: _*) > 0
  }

  def getValue(key: String): Option[String] = {
    Option(connection.get(key))
  }

  def publish(channel: String, value: String): Long = {
    connection.publish(channel, value)
  }

  def putValue(key: String, value: String): Long = {
    connection.lpush(key, value)
  }

  def subscribeChannel(channel: String): Unit = {
    // 需要保证添加listener与订阅channel的连接是同一个
    redisClient.sync.subscribe(channel)
    println("complete subscribeChannel")
  }
}
