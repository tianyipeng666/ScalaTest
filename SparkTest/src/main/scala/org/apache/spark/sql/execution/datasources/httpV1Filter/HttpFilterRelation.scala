package org.apache.spark.sql.execution.datasources.httpV1Filter

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

private[sql] object HttpFilterRelation extends Logging {

  def getSchema(httpOptions: HttpOptions): StructType = {
    HttpHelper.getSchema(httpOptions)
  }

  def getPartitions(httpOptions: HttpOptions, columns: Array[String], whereClause: String, executeSql: String): Array[Partition] = {
    HttpHelper.getPartitions(httpOptions, columns, whereClause, executeSql)
  }
}

private[sql] case class HttpFilterRelation(pushedSql: Option[String],
                                     httpOptions: HttpOptions)(@transient val sparkSession: SparkSession)
  extends BaseRelation with PrunedFilteredScan with LazyLogging {

  // hadoop的Configuration未实现序列化，通过SerializableConfiguration实现conf的序列化并传递到executor中使用
  val serHadoopConf = new SerializableConfiguration(new Configuration())

  override def schema: StructType = pushedSql match {
      case Some(_) =>
        // 假设聚合下推只支持返回单个 COUNT 值，类型为 Long
        StructType(Array(StructField("count", LongType, nullable = false)))
      case None =>
        HttpHelper.getSchema(httpOptions)
  }

  override def sqlContext: SQLContext = sparkSession.sqlContext

  override val needConversion: Boolean = false

  private final val dialect = JdbcDialects.get("jdbc:mysql")

  override def buildScan(requiredColumns: Array[String], filters: Array[Filter]): RDD[Row] = {
    val quotedColumns = if (pushedSql.nonEmpty) "count".split(",") else requiredColumns
    val whereClause = getWhereClause(filterWhereClause(filters))
    val executeSql = pushedSql.getOrElse {
      val cols = if (requiredColumns.isEmpty) "*" else requiredColumns.mkString(", ")
      s"SELECT ${cols} FROM ${httpOptions.tableName} ${whereClause}"
    }
    logger.info(s"Execute sql ==> ${executeSql}, ")
    val parts = HttpFilterRelation.getPartitions(httpOptions,quotedColumns, whereClause, executeSql)
    // 只有调用行动算子时才会调用该方法，懒加载
    HTTPMoveDataRDD.scanTable(sparkSession.sparkContext,
      schema,
      quotedColumns,
      parts,
      serHadoopConf,
      httpOptions).asInstanceOf[RDD[Row]]
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
        // We can't compile Or filter unless both sub-filters are compiled successfully.
        // It applies too for the following And filter.
        // If we can make sure compileFilter supports all filters, we can remove this check.
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
