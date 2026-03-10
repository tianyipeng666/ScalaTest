package gbase

import java.sql.{Connection, DriverManager, ResultSet, ResultSetMetaData, Timestamp, PreparedStatement}
import java.time.{LocalDate, LocalDateTime, LocalTime}
import java.math.BigDecimal
import java.text.SimpleDateFormat
import scala.collection.mutable.ArrayBuffer

object GBaseUtils {

  val url = "jdbc:gbase://123.126.105.18:5258/typ?user=root&password=root&rewriteBatchedStatements=true"

  def getGBaseConnection(): Connection = {
    Class.forName("com.gbase.jdbc.Driver")
    // val connection = DriverManager.getConnection("jdbc:gbase://192.168.1.33:5258/haizhi?user=gbase&password=GBase2O11O531&rewriteBatchedStatements=true")
    val connection = DriverManager.getConnection(url)
    connection
  }

  def createDataBase(dataBaseName: String, connection: Connection): Int = {
    val statement = connection.createStatement
    statement.executeUpdate("create database ${dataBaseName}")
  }

  def createTable(tableName: String, fieldMap: Map[String, String], connection: Connection): Int = {
    val statement = connection.createStatement
    val sqlBuilder = new StringBuilder()
    sqlBuilder.append(s"create table ${tableName}(")
    fieldMap.foreach(entry => {
      sqlBuilder.append(s"${entry._1} ${entry._2},")
    })
    sqlBuilder.deleteCharAt(sqlBuilder.length - 1)
    sqlBuilder.append(")")
    println(sqlBuilder)
    statement.executeUpdate(sqlBuilder.toString())
  }

  def getTableData(executeSql: String, connection: Connection): Unit = {
    val statement = connection.createStatement
    val rs: ResultSet = statement.executeQuery(executeSql)
    val rsMeta: ResultSetMetaData = rs.getMetaData
    val size = rsMeta.getColumnCount
    // schema
    var i = 1
    while (i <= size) {
      val label = rsMeta.getColumnLabel(i)
      val typeName = rsMeta.getColumnTypeName(i)
      val precision = rsMeta.getPrecision(i)
      val scale = rsMeta.getScale(i)
      val nullable = rsMeta.isNullable(i) // 0/1/2
      println(f"  - $label%-20s $typeName%-12s (precision=$precision, scale=$scale, nullable=$nullable)")
      i += 1
    }

    //head
    // 打印表头
    val headers = (1 to size).map(rsMeta.getColumnLabel).mkString(" | ")
    println("\n== Data ==")
    println(headers)
    println("-" * headers.length)

    // 打印所有行
    var rowNum = 0
    while (rs.next()) {
      rowNum += 1
      val row = (1 to size).map { idx =>
        val obj = rs.getObject(idx)
        formatValue(obj)
      }.mkString(" | ")
      println(row)
    }

    println(s"\nTotal rows: $rowNum")

    rs.close()
    statement.close()
    connection.close()
  }

  private def formatValue(v: Any): String = v match {
    case null => "NULL"
    case arr: Array[Byte] =>
      s"<bytes len=${arr.length}, hex=${bytesHexPreview(arr)}>"
    case other =>
      other.toString
  }

  private def bytesHexPreview(bytes: Array[Byte], maxBytes: Int = 16): String = {
    val n = Math.min(bytes.length, maxBytes)
    val sb = new StringBuilder
    var i = 0
    while (i < n) {
      val b = bytes(i) & 0xff
      if (b < 16) sb.append('0')
      sb.append(Integer.toHexString(b))
      i += 1
    }
    val suffix = if (bytes.length > maxBytes) s"...(+${bytes.length - maxBytes} bytes)" else ""
    sb.toString() + suffix
  }

  private def formatObject(obj: Any): String = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    obj match {
      case null => null
      case i: Timestamp => sdf.format(i)
      case arr: Array[Byte] => new String(arr)
      case other => other.toString
    }
  }

  def insertTmpData(): Unit = {
    val targetDb = "typ"
    val driverClass = "com.gbase.jdbc.Driver"

    Class.forName(driverClass)

    var conn0: Connection = null
    var conn: Connection = null
    var ps: PreparedStatement = null

    try {
      // 1) 连接到当前可用库，创建数据库 typ
      conn0 = DriverManager.getConnection(url)
      conn0.prepareStatement(s"CREATE DATABASE IF NOT EXISTS $targetDb").execute()

      // 2) 连接到 typ 库
      val jdbcUrlTyp = switchDb(url, targetDb)
      conn = DriverManager.getConnection(jdbcUrlTyp)
      conn.setAutoCommit(false)

      // 3) 建表（尽量覆盖 GBase 8a 常见类型）
      conn.prepareStatement("DROP TABLE IF EXISTS test").execute()

      val createTableSql =
        """
          |CREATE TABLE test (
          |  id          BIGINT      NOT NULL,
          |  c_tinyint   TINYINT,
          |  c_smallint  SMALLINT,
          |  c_int       INT,
          |  c_bigint    BIGINT,
          |  c_float     FLOAT,
          |  c_double    DOUBLE,
          |  c_decimal   DECIMAL(20,6),
          |  c_char      CHAR(10),
          |  c_varchar   VARCHAR(50),
          |  c_text      TEXT,
          |  c_blob      BLOB,
          |  c_longblob  LONGBLOB,
          |  c_date      DATE,
          |  c_datetime  DATETIME,
          |  c_time      TIME,
          |  c_ts        TIMESTAMP,
          |  PRIMARY KEY (id)
          |)
          |DISTRIBUTED BY('id')
          |""".stripMargin

      conn.prepareStatement(createTableSql).execute()

      // 4) 插入 100 行（PreparedStatement + batch）
      val insertSql =
        """
          |INSERT INTO test (
          |  id, c_tinyint, c_smallint, c_int, c_bigint,
          |  c_float, c_double, c_decimal,
          |  c_char, c_varchar, c_text,
          |  c_blob, c_longblob,
          |  c_date, c_datetime, c_time, c_ts
          |) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
          |""".stripMargin

      ps = conn.prepareStatement(insertSql)

      val baseDate = LocalDate.of(2025, 1, 1)
      val baseDateTime = LocalDateTime.of(2025, 4, 25, 11, 8, 33)

      for (i <- 1 to 100) {
        val id = i.toLong

        val tiny = (i % 120).toByte
        val small = (i * 10).toShort
        val intv = i * 1000
        val bigv = 10000000000L + i

        val flt = i.toFloat + 0.25f
        val dbl = i.toDouble + 0.000123

        val dec = new BigDecimal(s"$i.${(i % 100).formatted("%02d")}0000") // scale=6

        val ch = f"c$i%09d".take(10) // 10 chars
        val vc = s"varchar_$i"
        val tx = s"text row=$i, hello gbase8a, some payload..."

        val blob = s"blob_$i".getBytes("UTF-8")
        val longBlob = (s"longblob_$i|" * 50).getBytes("UTF-8") // 更长一点

        val d = java.sql.Date.valueOf(baseDate.plusDays(i))
        val dt = java.sql.Timestamp.valueOf(baseDateTime.plusDays(i).withNano(0))
        val tm = java.sql.Time.valueOf(LocalTime.of(i % 24, (i * 3) % 60, (i * 7) % 60))
        val ts = java.sql.Timestamp.valueOf(baseDateTime.plusDays(i).plusSeconds(i).withNano(0))

        ps.setLong(1, id)
        ps.setByte(2, tiny)
        ps.setShort(3, small)
        ps.setInt(4, intv)
        ps.setLong(5, bigv)
        ps.setFloat(6, flt)
        ps.setDouble(7, dbl)
        ps.setBigDecimal(8, dec)
        ps.setString(9, ch)
        ps.setString(10, vc)
        ps.setString(11, tx)
        ps.setBytes(12, blob)
        ps.setBytes(13, longBlob)
        ps.setDate(14, d)
        ps.setTimestamp(15, dt)
        ps.setTime(16, tm)
        ps.setTimestamp(17, ts)

        ps.addBatch()

        // 分批提交
        if (i % 50 == 0) {
          ps.executeBatch()
          conn.commit()
        }
      }

      ps.executeBatch()
      conn.commit()
    } finally {
      try {
        if (ps != null) ps.close()
      } catch {
        case _: Throwable =>
      }
      try {
        if (conn != null) conn.close()
      } catch {
        case _: Throwable =>
      }
      try {
        if (conn0 != null) conn0.close()
      } catch {
        case _: Throwable =>
      }
    }
  }

  def switchDb(jdbcUrl: String, db: String): String = {
    val Array(base, query@_*) = jdbcUrl.split("\\?", 2)
    val q = query.headOption

    val prefix = "jdbc:gbase://"
    require(base.startsWith(prefix), s"Unsupported url: $jdbcUrl")

    // host:port[/...]
    val after = base.substring(prefix.length)
    // 只取 host:port，忽略后面可能已有的 /xxx
    val hostPort = after.takeWhile(_ != '/')
    val newBase = s"$prefix$hostPort/$db"

    q.map(p => s"$newBase?$p").getOrElse(newBase)
  }

}
