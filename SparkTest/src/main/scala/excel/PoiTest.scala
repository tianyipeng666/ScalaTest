package excel

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import java.io.FileInputStream
import scala.jdk.CollectionConverters.asScalaIteratorConverter

object PoiTest {
  def main(args: Array[String]): Unit = {
    val workbook: Workbook = new XSSFWorkbook(
      new FileInputStream("/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/files/excel1.xlsx"))
    val sheet = workbook.getSheetAt(0)
    val row = sheet.getRow(1)
    println(row.getCell(0).getCellType + "==" + row.getCell(1).getCellType + "==" + row.getCell(2).getDateCellValue + "==" + row.getCell(3).getCellType)
//    val rows = sheet.iterator().asScala.toList
//    val data = rows.map { row =>
//      // 根据你的 Excel 文件结构提取数据
//      val cell1 = row.getCell(0).getStringCellValue // 假设第一列是字符串类型
//      val cell2 = row.getCell(1).getNumericCellValue // 假设第二列是整型
//      val cell3 = row.getCell(2).getStringCellValue // 假设第二列是整型
//      val cell4 = row.getCell(3).getStringCellValue // 假设第二列是整型
//      println(cell1 + "==" + cell2 + "==" + cell3 + "==" + cell4)
//    }
  }

}
