package excel.parser

import data.{DataSetUtils, DataTypeUtils}
import excel.bean.{ExcelConfig, ExcelResult, SheetField, SheetResult}
import excel.reader.ExcelReader

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class ExcelParser(config: ExcelConfig) {

  def parsePartial(limit: Int): ExcelResult = {
    val dataBuffer = new ArrayBuffer[Array[String]]()
    val sheetResults = new ArrayBuffer[SheetResult]()

    // 每解析完一行数据就添加进该buffer中
    def rowHandler(rowNum: Int, data: Array[String]): Unit = {
      dataBuffer.append(data)
    }

    // sheet开始解析前处理逻辑
    def sheetStartHandler(sheetName: String): Unit = {}

    // sheet解析完成后处理逻辑
    def sheetEndHandler(sheetName: String, rowNum: Int, errorMsg: String): Unit = {
      if (dataBuffer.nonEmpty) {
        val rows = dataBuffer.toArray
        dataBuffer.clear()
        // 数据打散，抽样
        val sampleData = Random.shuffle(rows.toIndexedSeq).take(math.min(limit, rows.length)).toArray
        val colMarks = DataSetUtils.markEmptyCol(sampleData)
        val dataset = sampleData.map(DataSetUtils.cleanEmptyCol(_, colMarks))
        val rowOffset = DataSetUtils.inferRowOffset(dataset)
        val header = DataSetUtils.makeHeader(dataset, rowOffset)
        val schema = DataTypeUtils.inferTypeFromDataset(header, dataset, rowOffset)
        val adaptedRows = dataset.map(DataSetUtils.adaptedRow(_, schema.length))
        val formattedData = adaptedRows.zipWithIndex.map { case (row, index) =>
          if (index > rowOffset) {
            DataTypeUtils.formatRow(row, schema)
          } else {
            row
          }
        }
        val sheetResult = SheetResult(sheetName, "", formattedData.length,
          schema.length, rowOffset, colMarks, schema, formattedData, errorMsg)
        sheetResults.append(sheetResult)
      } else {
        val sheetResult = SheetResult(sheetName, "", 0, 0, 0, Seq.empty[Int],
          Seq.empty[SheetField], Array.empty[Array[String]], "数据不能为空")
        sheetResults.append(sheetResult)
      }
    }

    val excelReader = ExcelReader(config, rowHandler, sheetEndHandler, sheetStartHandler, 10000)
    excelReader.doRead()
    ExcelResult(sheetResults)
  }

}

object ExcelParser {
  def apply(config: ExcelConfig): ExcelParser = new ExcelParser(config)
}
