package conf

import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.config.ConfigException.Missing

import java.io.File
import java.util
object ConfParseUtils {

  // ConfigFactory.load()默认读取的就是resources下的application.conf文件
  private val conf = ConfigFactory.load()

  private def parseConf(): Config = {
    val confFilePath = new File("/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/src/main/resources/application.conf")
    val specialConfig = ConfigFactory.parseFile(confFilePath)
    ConfigFactory.load(specialConfig)
  }

  private def getConf[T](name: String)(implicit m: Manifest[T]): T = {
    m.runtimeClass match {
      case t if t == classOf[Int] => conf.getInt(name).asInstanceOf[T]
      case t if t == classOf[Long] => conf.getLong(name).asInstanceOf[T]
      case t if t == classOf[Double] => conf.getDouble(name).asInstanceOf[T]
      case t if t == classOf[Boolean] => conf.getBoolean(name).asInstanceOf[T]
      case t if t == classOf[String] => conf.getString(name).asInstanceOf[T]
      case _ => conf.getValue(name).unwrapped().asInstanceOf[T]
    }
  }

  private def getConf[T](name: String, default: T)(implicit m: Manifest[T]): T = {
    try {
      getConf[T](name)
    } catch {
      case _: Missing => default
    }
  }

  val redisMode = getConf[String]("redis.mode", if (redisSentinelEnabled) "sentinel" else "standalone")

  val redisHost = getConf[String]("redis.host")
  val redisPort = getConf[Int]("redis.port")
  val redisPassword = getConf[String]("redis.password", "")

  val redisSentinelEnabled = getConf[Boolean]("redis.sentinel.enabled", false)
  val redisSentinelMaterId = if (redisSentinelEnabled) getConf[String]("redis.sentinel.masterId") else null
  val redisSentinelHostPort = {
    if (redisSentinelEnabled) {
      val cluterList = getConf[util.ArrayList[String]]("redis.sentinel.cluster")
      val HostAndPosts = for (i <- 0 until cluterList.size()) yield {
        val str = cluterList.get(i).split(":")
        (str(0), str(1).toInt)
      }
      if (HostAndPosts.isEmpty) {
        throw new IllegalArgumentException("redis cluster list cannot be empty")
      }
      HostAndPosts
    } else {
      null
    }
  }

  val redisClusterEnabled = getConf[Boolean]("redis.cluster.enabled", false)
  val redisClusterNodes = {
    if (redisClusterEnabled) {
      val cluterList = getConf[util.ArrayList[String]]("redis.cluster.nodes")
      val HostAndPosts = for (i <- 0 until cluterList.size()) yield {
        val str = cluterList.get(i).split(":")
        (str(0), str(1).toInt)
      }
      if (HostAndPosts.isEmpty) {
        throw new IllegalArgumentException("redis cluster list cannot be empty")
      }
      HostAndPosts
    } else {
      null
    }
  }
}
