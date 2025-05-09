package pattern

import scala.collection.mutable

object ScalaPatternUtils {

  private val tbNamePattern = "[a-z0-9]{32}".r

  def main(args: Array[String]): Unit = {
    val partitionSql1 = "year('2025-04-25 11:08:33') AS `year`, month('2025-04-25 11:08:33') AS `month`, day('2025-04-25 11:08:33') AS `day`"
    val partitionSql2 = "year(`fk123`) AS `year`, month(`fk123`) AS `month`, day(`fk123`) AS `day`"
    println(transformPartitionSql(partitionSql1))
    println(transformPartitionSql(partitionSql2))
  }

  private def getTableName(tmpTbs: Seq[String]): mutable.Set[String] = {
    val tableSet = mutable.Set[String]()
    if (tmpTbs.nonEmpty) {
      tmpTbs.foreach(tbSql => {
        tableSet ++= tbNamePattern.findAllIn(tbSql).toSet
      })
    }
    tableSet
  }

  private def transformPartitionSql(partitionSQL: String): String = {
    // 兼顾month(`fk`)与month('2025-04-25 11:08:33')
    val pattern = raw"(month|day|hour)\(\s*([`'])([^`']+)\2\s*\)\s+AS\s+`\1`".r
    val transformSql = pattern.replaceAllIn(partitionSQL, m => {
      val unit = m.group(1)
      val quote = m.group(2)
      val inner = m.group(3)
      s"LPAD($unit($quote$inner$quote), 2, '0') AS `$unit`"
    })
    transformSql
  }
}
