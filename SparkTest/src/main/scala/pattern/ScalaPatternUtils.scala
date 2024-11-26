package pattern

import scala.collection.mutable

object ScalaPatternUtils {

  private val tbNamePattern = "[a-z0-9]{32}".r

  def main(args: Array[String]): Unit = {
    val temTbs = List("SELECT `fk9d2988ea` AS `ID`, `fk030940d7` AS `拜访人`, `fk84e4c2f8` AS `员工编号`, `fk2d46044a` AS `部门`, `fk1cd7a010` AS `职位`, `fk83179d63` AS `拜访日期`, `fk732da065` AS `拜访时间`, `fk61ed59ca` AS `客户类型`, `fkc5fd72ed` AS `进展`, `fk74f45d2a` AS `结果` FROM `sc1c942c604f4365b85fbd076fe44218` WHERE 1=1",
      "SELECT `fk465956e5` AS `ID`, `fkf0d938e1` AS `拜访人`, `fkc47c5981` AS `员工编号`, `fk4b8bf024` AS `部门`, `fk146c7d24` AS `职位`, `fkdddab552` AS `拜访日期`, `fka2f7334b` AS `拜访时间`, `fk96dce56d` AS `客户类型`, `fk5857db51` AS `进展`, `fkc54c0e47` AS `进展1`, `fk4158889f` AS `结果` FROM `e96fd5cc20ca4f87ac20f6f164cc8cce` WHERE 1=1",
      "SELECT `ID` AS `ID`,`拜访人` AS `拜访人`,`员工编号` AS `员工编号`,`部门` AS `部门`,`职位` AS `职位`,`拜访日期` AS `拜访日期`,`拜访时间` AS `拜访时间`,`客户类型` AS `客户类型`,`进展` AS `进展`,`结果` AS `结果`,NULL AS `进展1` FROM inpute71f55f876d8etl UNION ALL SELECT `ID` AS `ID`,`拜访人` AS `拜访人`,`员工编号` AS `员工编号`,`部门` AS `部门`,`职位` AS `职位`,`拜访日期` AS `拜访日期`,`拜访时间` AS `拜访时间`,`客户类型` AS `客户类型`,`进展` AS `进展`,`结果` AS `结果`,`进展1` AS `进展1` FROM input319fec8806adetl",
      "SELECT `m62801ccc4ba4a65894572a4a1ff4513`.`fkf276375a` as fkb718adec,`m62801ccc4ba4a65894572a4a1ff4513`.`fkec39af1d` as fk5fc73231,\\\\\\\"\\\\\\\" as fk9df3213a,md5(concat( `m62801ccc4ba4a65894572a4a1ff4513`.`fkf276375a` )) as fk341be97d,\\\\\\\"\\\\\\\" as fk22af645d,\\\\\\\"\\\\\\\" as fk599dcce2 FROM `m62801ccc4ba4a65894572a4a1ff4513`")
    println(getTableName(temTbs))
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
}
