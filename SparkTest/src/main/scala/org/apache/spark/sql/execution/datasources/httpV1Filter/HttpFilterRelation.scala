package org.apache.spark.sql.execution.datasources.httpV1Filter

import constant.ConstantPath
import log.LazyLogging
import org.apache.hadoop.conf.Configuration
import org.apache.spark.Partition
import org.apache.spark.internal.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.analysis._
import org.apache.spark.sql.jdbc.{JdbcDialect, JdbcDialects}
import org.apache.spark.sql.sources._
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.util.SerializableConfiguration
import com.alibaba.fastjson.JSONObject
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

private[sql] object HttpFilterRelation extends Logging {

  def getSchema(httpOptions: HttpOptions): StructType = {
    HttpHelper.getSchema(httpOptions)
  }

  def getPartitions(httpOptions: HttpOptions, columns: Array[String], whereClause: String, executeSql: String): Array[Partition] = {
    HttpHelper.getPartitions(httpOptions, columns, whereClause, executeSql)
  }
}

private[sql] case class HttpFilterRelation(pushedCols: Option[Seq[String]] = None,
                                           pushedSql: Option[String] = None,
                                           httpOptions: HttpOptions)(@transient val sparkSession: SparkSession)
  extends BaseRelation with PrunedFilteredScan with LazyLogging {

  // hadoop的Configuration未实现序列化，通过SerializableConfiguration实现conf的序列化并传递到executor中使用
  val serHadoopConf = new SerializableConfiguration(new Configuration())

  override def schema: StructType = pushedSql match {
    case Some(sqlText) =>
      // 判断是否是count(1)下推(简化判断:看是否包含"COUNT(1)")
      val upperSql = sqlText.toUpperCase
      if (upperSql.contains("COUNT(1)")) {
        // 只返回1列
        StructType(Array(StructField("count", LongType, nullable = false)))
      } else {
        // limit场景 => 用pushedCols(若非空)
        pushedCols match {
          case Some(cols) =>
            // 根据每个列在原schema中的类型构造
            val origin = HttpFilterRelation.getSchema(httpOptions)
            val fields = cols.flatMap { c =>
              origin.find(_.name.equalsIgnoreCase(c))
            }
            StructType(fields)
          case None =>
            // 如果没解析列,就默认
            HttpFilterRelation.getSchema(httpOptions)
        }
      }
    case None =>
      HttpHelper.getSchema(httpOptions)
  }

  override def sqlContext: SQLContext = sparkSession.sqlContext

  // 返回类型是Row则置为true，返回类型是InternalRow则置为false
  // 为false则Spark认为是内部格式，则会做强转；如果返回的就是Row，则设置为true，Spark就不会做强转
  override val needConversion: Boolean = true

  private final val dialect = JdbcDialects.get("jdbc:mysql")

  override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] = {
    val quotedColumns = if (pushedSql.nonEmpty) {
      pushedCols match {
        case Some(cols) => cols.toArray
        case None => Array("count")
      }
    } else requiredColumns
    val whereClause = getWhereClause(filterWhereClause(filters))
    // 支持Count
    val executeSql = pushedSql.getOrElse {
      val cols = if (requiredColumns.isEmpty) "*" else requiredColumns.mkString(", ")
      s"SELECT ${cols} FROM ${httpOptions.tableName} ${whereClause}"
    }
    logger.info(s"Execute sql ==> ${executeSql}, ${requiredColumns.mkString(",")}")
    val parts = HttpFilterRelation.getPartitions(httpOptions, quotedColumns, whereClause, executeSql)
    // 只有调用行动算子时才会调用该方法，懒加载
    HTTPMoveDataRDD.scanTable(sparkSession.sparkContext,
      schema,
      quotedColumns,
      parts,
      serHadoopConf,
      httpOptions)
  }

  override def toString: String = {
    s"HttpFilterRelation(${httpOptions.tableName})"
  }

  override def unhandledFilters(filters: Array[Filter]): Array[Filter] = {
    filters.filter(compileFilter(_, dialect).isEmpty)
  }

  private def filterWhereClause(filters: Array[Filter]): String =
    filters.flatMap(compileFilter(_, dialect)).map(p => s"($p)").mkString(" AND ")

  private def getWhereClause(filterWhereClause: String): String = {
    if (filterWhereClause.nonEmpty) {
      "WHERE " + filterWhereClause
    } else {
      ""
    }
  }

  private def compileFilter(f: Filter, dialect: JdbcDialect): Option[String] = {
    def quote(colName: String): String = dialect.quoteIdentifier(colName)

    Option(f match {
      case EqualTo(attr, value) => s"${quote(attr)} = ${dialect.compileValue(value)}"
      case EqualNullSafe(attr, value) =>
        val col = quote(attr)
        s"(NOT ($col != ${dialect.compileValue(value)} OR $col IS NULL OR " +
          s"${dialect.compileValue(value)} IS NULL) OR " +
          s"($col IS NULL AND ${dialect.compileValue(value)} IS NULL))"
      case LessThan(attr, value) => s"${quote(attr)} < ${dialect.compileValue(value)}"
      case GreaterThan(attr, value) => s"${quote(attr)} > ${dialect.compileValue(value)}"
      case LessThanOrEqual(attr, value) => s"${quote(attr)} <= ${dialect.compileValue(value)}"
      case GreaterThanOrEqual(attr, value) => s"${quote(attr)} >= ${dialect.compileValue(value)}"
      case IsNull(attr) => s"${quote(attr)} IS NULL"
      case IsNotNull(attr) => s"${quote(attr)} IS NOT NULL"
      case StringStartsWith(attr, value) => s"${quote(attr)} LIKE '${value}%'"
      case StringEndsWith(attr, value) => s"${quote(attr)} LIKE '%${value}'"
      case StringContains(attr, value) => s"${quote(attr)} LIKE '%${value}%'"
      case In(attr, value) if value.isEmpty =>
        s"CASE WHEN ${quote(attr)} IS NULL THEN NULL ELSE FALSE END"
      case In(attr, value) => s"${quote(attr)} IN (${dialect.compileValue(value)})"
      case Not(f) => compileFilter(f, dialect).map(p => s"(NOT ($p))").orNull
      case Or(f1, f2) =>
        val or = Seq(f1, f2).flatMap(compileFilter(_, dialect))
        if (or.size == 2) {
          or.map(p => s"($p)").mkString(" OR ")
        } else {
          null
        }
      case And(f1, f2) =>
        val and = Seq(f1, f2).flatMap(compileFilter(_, dialect))
        if (and.size == 2) {
          and.map(p => s"($p)").mkString(" AND ")
        } else {
          null
        }
      case _ => null
    })
  }
}
