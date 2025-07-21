package dbConnect

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import proxy.ConnectionProxy

import java.sql.{Connection, PreparedStatement, ResultSet}
import scala.util.control.NonFatal

object DBConnectUtils {

  private var ds = new HikariDataSource()
  private var driverClassStatic = ""
  private var dbUrlStatic = ""
  private var userStatic = ""
  private var passwordStatic = ""

  private def databasePool: Connection = {
    ConnectionProxy.wrap(ds.getConnection)
  }

  private def resetPoolManager() {
    ds.close()
    init(driverClassStatic, dbUrlStatic, userStatic, passwordStatic)
  }

  def init(driverClass: String, dbUrl:String, user:String, password:String) {
    val config = new HikariConfig()
    driverClassStatic = driverClass
    config.setDriverClassName(driverClass)
    dbUrlStatic = dbUrl
    config.setJdbcUrl(dbUrl)
    userStatic = user
    config.setUsername(user)
    passwordStatic = password
    config.setPassword(password)
    // 设置最大连接池大小
    config.setMaximumPoolSize(3)
    // 设置连接超时，单位毫秒
    config.setConnectionTimeout(30000)
    // 设置连接池中连接的最大空闲时间，单位毫秒
    config.setIdleTimeout(600000)
    // 设置连接池中连接的最大生命周期，单位毫秒
    config.setMaxLifetime(1800000)
    ds = new HikariDataSource(config)
  }

  def executeQuery[T](sql: String, params: Seq[Any])(processResultSet: ResultSet => T): Seq[T] = {
    retryConnect(0) {
      using(databasePool) { connection =>
        using(connection.prepareStatement(sql)) { statement =>
          // 设置参数
          setParameters(statement, params)

          // 执行查询并处理结果
          using(statement.executeQuery()) { resultSet =>
            val buffer = new collection.mutable.ListBuffer[T]()
            while (resultSet.next()) {
              buffer += processResultSet(resultSet)
            }
            buffer.toList
          }
        }
      }
    }
  }

  def executeQuery[T](sql: String)(processResultSet: ResultSet => T): Seq[T] = {
    retryConnect(0) {
      using(databasePool) { connection =>
        using(connection.createStatement()) { statement =>
          // 执行查询并处理结果
          using(statement.executeQuery(sql)) { resultSet =>
            val buffer = new collection.mutable.ListBuffer[T]()
            while (resultSet.next()) {
              buffer += processResultSet(resultSet)
            }
            buffer.toList
          }
        }
      }
    }
  }

  private def setParameters(statement: PreparedStatement, params: Seq[Any]): Unit = {
    for (i <- params.indices) {
      statement.setObject(i + 1, params(i))
    }
  }

  // 实现try-with-resources机制，自动关闭资源
  private def using[A <: AutoCloseable, B](closable: A)(body: A => B): B = {
    try {
      body(closable)
    } finally {
      closable.close()
    }
  }

  private def retryConnect[T](retryTimes: Int)(block: => T): T = {
    try {
      block
    } catch {
      case NonFatal(e) =>
        // 尝试超过两次就抛异常
        if (retryTimes < 2 && e.getMessage != null && e.getMessage.contains("Communications link failure")) {
          DBConnectUtils.resetPoolManager()
          retryConnect(retryTimes + 1)(block)
        } else {
          e.printStackTrace
          throw e
        }
    }
  }

}
