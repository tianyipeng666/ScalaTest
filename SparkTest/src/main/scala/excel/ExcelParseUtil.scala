package excel

import excel.bean.ExcelConfig
import excel.parser.ExcelParser

object ExcelParseUtil {

  def excelParse(excelPath: String, excelType: String, limit: Integer): Unit = {
    val config = ExcelConfig(excelPath, excelType, "", Seq())
    val result = ExcelParser(config).parsePartial(limit)
    println(result)
  }

}
