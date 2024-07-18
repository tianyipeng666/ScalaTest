package excel.hander

import excel.reader.{XlsReader, XlsxReader}

object ExcelHander {

  val xlsPath = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/files/excel2.xls"
  val xlsxPath = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/testFiles/test.xlsx"
  val etPath = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/files/excel3.et"
  def main(args: Array[String]): Unit = {
//    new XlsReader(etPath)
//      .doRead()

    new XlsxReader(xlsxPath)
      .doRead()
  }

}
