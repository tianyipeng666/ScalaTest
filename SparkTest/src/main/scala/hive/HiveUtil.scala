package hive

import bean.Schema
import org.apache.spark.sql.SparkSession

import scala.collection.mutable

object HiveUtil {
  def createTableAndRefresh(session: SparkSession, hdfsPath:String, schema:Seq[Schema], tableName:String) :Unit = {
    val builder = new mutable.StringBuilder
    // 无法带external
    builder.append(s"CREATE EXTERNAL TABLE IF NOT EXISTS bdp.$tableName (")
    schema.sortBy(_.seq_no).foreach(schema => {
      builder.append(s"`${schema.name}` STRING,")
    })
    builder.deleteCharAt(builder.size - 1)
    builder.append(")")
    builder.append(s"\n USING CSV")
    // 分区键需再表名后的括号内(col1, col2, pk)，不能带属性
    // builder.append(s"\n PARTITIONED BY (`pk` STRING)")
    builder.append(s"\n OPTIONS ('path' '$hdfsPath', 'header' 'true', 'delimiter' ',')")
    println(builder.toString())
    session.sql(builder.toString())

    val alterLocationSql = s"ALTER TABLE bdp.$tableName SET LOCATION '$hdfsPath'"
    println(alterLocationSql)
    session.sql(alterLocationSql)

    session.sql(s""" MCSK REPAIR TABLE bdp.$tableName """)
    session.sql(s""" SELECT * FROM bdp.$tableName """)
      .show(10000)
  }

  def createTableTest(session: SparkSession, hdfsPath: String, tableName: String, count: Int): Unit = {
    val builder = new mutable.StringBuilder
    // 无法带external
    builder.append(s"CREATE EXTERNAL TABLE IF NOT EXISTS bdp.$tableName (")
    builder.append(s"`name1` STRING,")
    builder.append(s"`name2` STRING,")
    builder.append(s"`name3` STRING,")
    builder.append(s"`name4` STRING,")
    builder.append(s"`name5` STRING,")
    builder.append(s"`name6` STRING,")
    builder.append(s"`name7` STRING,")
    builder.append(s"`name8` STRING,")
    builder.append(s"`name9` STRING,")
    builder.append(s"`name10` STRING,")
    builder.append(s"`name11` STRING,")
    builder.append(s"`name12` STRING,")
    builder.append(s"`name13` STRING,")
    builder.deleteCharAt(builder.size - 1)
    builder.append(")")
    builder.append(s"\n USING CSV")
    builder.append(s"\n OPTIONS ('path' '$hdfsPath', 'header' 'true', 'delimiter' ',')")
    println(builder.toString())
    session.sql(builder.toString())

    val alterLocationSql = s"ALTER TABLE bdp.$tableName SET LOCATION '$hdfsPath'"
    println(alterLocationSql)
    session.sql(alterLocationSql)

    session.sql(s""" REFRESH TABLE bdp.$tableName """)
    session.sql(s""" SELECT * FROM bdp.$tableName """)
      .show(10000)
  }

  def createCSVSpark246(): String = {
    // 分区字段不支持中文，分区字段需在括号内，不能带有属性; 不带external
    // 支持中文字段，hive元数据表COLUMNS_V2的COLUMN_NAME列编码为utf8，ALTER TABLE hive_meta.COLUMNS_V2 MODIFY COLUMN COLUMN_NAME varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
    val sql =
      """
        |CREATE TABLE IF NOT EXISTS bdp.TESTCSV246
        |(`测试1` String, `测试2` String, `pk` String)
        |USING CSV
        |PARTITIONED BY (`pk`)
        |OPTIONS ('path' 'hdfs://hdcluster/excel/externalExcel3', 'header' 'true', 'delimiter' ',')
        |""".stripMargin
        sql
  }

  def createCSVSpark322(): String = {
    // 注意USING在PARTITIONED前
    val sql =
      """
        |CREATE EXTERNAL TABLE IF NOT EXISTS bdp.TestExcel3 (`行号` STRING,`交易机构号` STRING,`交易机构名称` STRING,`户  名` STRING,`账  号` STRING,`子账户序号` STRING,`摘  要` STRING,`交易金额` STRING,`余  额` STRING,`对方账号卡号` STRING,`对方户名` STRING,`交易日期` STRING,`交易柜员` STRING)
        | USING CSV
        | PARTITIONED BY (`pk` STRING)
        | OPTIONS ('path' 'hdfs://hdcluster/excel/externalExcel3', 'header' 'true', 'delimiter' ',')
        |""".stripMargin
        sql
  }

  def getHiveTableLocation(session: SparkSession, database: String, tableName: String): Unit = {
    // 元数据获取
    val tableMeta = session.sessionState.catalog.externalCatalog.getTable(database, tableName)
    // 打印meta信息结构
    println(tableMeta)
    // 打印meta中location信息
    println(tableMeta.storage.locationUri.get)
//    println(session.sql(s"desc formatted ${database}.${tableName}").collect()
//      .filter(_.get(0).toString.equals("Location"))
//      .map(_.get(1))
//      .mkString
//    )

    // inputFormat
    println(tableMeta.storage.inputFormat.get)

    // totalSize
    var totalSize = 0L
    val statistics = tableMeta.stats.getOrElse(null)
    totalSize = if (statistics != null) statistics.sizeInBytes.toLong else -1
    println(totalSize)

    // rowsCount
    var rowsCount = 0L
    // ???
    rowsCount = if (statistics != null) statistics.rowCount.get.toLong else 0L
    println(rowsCount)
//    rowsCount = session.sql(s"select count(*) as cnt from ${database}.${tableName}").take(1)
//      .map(_.get(0)).mkString.toLong
  }

  def getHiveTableCount(session: SparkSession, database: String, tableName: String): Unit = {
    println(session.sql(s"select count(*) as cnt from ${database}.${tableName}").take(1)
      .map(_.get(0)).mkString)
  }

  def modifyTable(session: SparkSession, database: String, tableName: String): Unit = {
    session.sql(s"alter table ${database}.${tableName} set tblproperties('totalSize'='true')")
    session.sql(s"refresh table ${database}.${tableName}")
    session.sql(s"show tblproperties ${database}.${tableName}").show()
  }

  def getTableTotalSize(session: SparkSession, database: String, tableName: String, location: String, inputFormat: String): Unit = {
    session.sql(s"SELECT TABLE_SIZE('$database', '$tableName', '$location', '$inputFormat') FROM system.dual LIMIT 1").show()
  }


}
