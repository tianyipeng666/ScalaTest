package conf

import java.io.File
import java.util
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.config.ConfigException.Missing

object UdfConf {

  def init(): Config = {
    val configFileName = "udf.conf"
    val configFile = if (new File(configFileName).exists()) {
      new File(configFileName)
    } else {
      new File(s"conf/$configFileName")
    }
    val udfConfig = ConfigFactory.parseFile(configFile)
    val conf = ConfigFactory.load(udfConfig)
    conf
  }
  private val conf = init()

  private def getConf[T](name: String, default: T): T = {
    try {
      conf.getValue(name).unwrapped().asInstanceOf[T]
    } catch {
      case _: Missing => default
    }
  }

  private def getConf[T](name: String): T = {
    conf.getValue(name).unwrapped().asInstanceOf[T]
  }

  val udfRedisDbIndex = getConf[Int]("udf_redis.dbIndex")
  val udfRedisHost = getConf[String]("udf_redis.host")
  val udfRedisPassword = getConf[String]("udf_redis.password", "")
  val udfRedisPort = getConf[Int]("udf_redis.port")
  val udfRedisSentinelEnabled = getConf[Boolean]("udf_redis.sentinel.enabled", true)
  val udfRedisSentinelMaterId = if (udfRedisSentinelEnabled) getConf[String]("udf_redis.sentinel.masterId") else null

  val udfMysqlUrl = getConf[String]("udf_mysql.url")
  val udfMysqlUser = getConf[String]("udf_mysql.user")
  val udfMysqlPassword = getConf[String]("udf_mysql.password")
  val udfMysqlDb = getConf[String]("udf_mysql.db")
  val udfMysqlTBZone = getConf[String]("udf_mysql.zone")
  val udfMysqlZoneId = getConf[String]("udf_mysql.zone_id")
  val udfMysqlZoneJson = getConf[String]("udf_mysql.zone_json")
  val udfMysqlTypeId = getConf[String]("udf_mysql.type_id")
  val udfMysqlTBPoint = getConf[String]("udf_mysql.point")
  val udfMysqlPointId = getConf[String]("udf_mysql.point_id")
  val udfMysqlPointJson = getConf[String]("udf_mysql.point_json")
  val udfMysqlEnabled = getConf[Boolean]("udf_mysql.enabled", false)

  val udfMaxPartitions = getConf[Int]("udf.maxPartitions", 30)
  // UDF 并发注册线程数
  val udfRegThreads = getConf[Int]("udf.udfRegThreads", 5)

  val udfRedisSentinelHostPort = {
    if (udfRedisSentinelEnabled) {
      val cluterList = getConf[util.ArrayList[String]]("udf_redis.sentinel.cluster")
      val HostAndPosts = for (i <- 0 until cluterList.size()) yield {
        val str = cluterList.get(i).split(":")
        (str(0), str(1).toInt)
      }
      if (HostAndPosts.isEmpty) {
        throw new IllegalArgumentException("udf_redis cluster list cannot be empty")
      }
      HostAndPosts
    } else {
      null
    }
  }

  val udfDictDataExpired = {
    try {
      UdfUtils.parseTime(getConf[String]("udf.dict.data_expired", "1d"))
    } catch {
      case e: NoSuchElementException =>
        throw new Exception(s"the value of the configuration udf.dict.data_expired is wrong format.")
    }
  }

  val locationService = getConf[String]("udf.location.service", "localhost:12345")
  val locationAccountKey = getConf[String]("udf.location.accountKey", "12345")

  val udfApiProxy = getConf[String]("udf.http.apiProxy", "http://bdp-core:22802/")
  val udfApiConnectTimeout = getConf[Int]("udf.http.connectTimeout", 5)
  val udfApiReadTimeout = getConf[Int]("udf.http.readTimeout", 60)

  // 地址经纬度转换UDF配置(需根据不同地区自行配置)
  val mapHost = getConf[String]("udf_map.host", "localhost")
  val mapPort = getConf[Int]("udf_map.port", 10000)
  val mapAk = getConf[String]("udf_map.ak", "1")

  val appTokenHost = getConf[String]("udf_map.appHost", "localhost")
  val appTokenPort = getConf[Int]("udf_map.appPort", 10000)
  val appClientId = getConf[String]("udf_map.clientId", "root")
  val appClientSecret = getConf[String]("udf_map.clientSecret", "12345")

  val mapId = getConf[String]("udf_map.id", "")
  val mapName = getConf[String]("udf_map.name", "")
  val mapUserType = getConf[String]("udf_map.userType", "")
  val mapIdCard = getConf[String]("udf_map.idCard", "")
  val mapOrgId = getConf[String]("udf_map.orgId", "")
  val mapOrgName = getConf[String]("udf_map.orgName", "")
  val mapPoliceNumber = getConf[String]("udf_map.policeNumber", "")

  val udfRedisSwitch = getConf[Boolean]("udf_map.redis_switch", true)
  val udfRedisExpire = getConf[Int]("udf_map.redis_expire", 3 * 24 * 60 * 60)
  val udfRedisUserToken = getConf[Int]("udf_map.redis_expire", 50 * 60)
}
