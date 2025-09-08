package excel.parser

import data.{DataSetUtils, DataTypeUtils}
import excel.bean.{ExcelConfig, ExcelResult, SheetField, SheetResult}
import excel.reader.ExcelReader
import log.LazyLogging

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class ExcelParser(config: ExcelConfig) extends LazyLogging{

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
        val sampleData = rows.take(math.min(limit, rows.length))
        dataBuffer.clear()
        // 数据打散，抽样
        // val sampleData = Random.shuffle(rows.toIndexedSeq).take(math.min(limit, rows.length)).toArray
        // 获取列数
        val colMarks = DataSetUtils.markEmptyCol(sampleData)
        val dataset = sampleData.map(DataSetUtils.cleanEmptyCol(_, colMarks))
        // 边界裁剪，确定从多少行开始为正确数据（行偏移）
        val rowOffset = DataSetUtils.inferRowOffset(dataset)
        // 表头
        val header = DataSetUtils.makeHeader(dataset, rowOffset)
        // 全表扫描判断具体类型
        val schema = DataTypeUtils.inferTypeFromDataset(header, rows, rowOffset)
        val adaptedRows = dataset.map(DataSetUtils.adaptedRow(_, schema.length))
        // 跳过表头后标准化数据
        val formattedData = adaptedRows.zipWithIndex.map { case (row, index) =>
          if (index > rowOffset) {
            DataTypeUtils.formatRow(row, schema)
          } else {
            row
          }
        }
        logger.info(s"sheetName:${sheetName}," +
          s"limitLength:${limit}," +
          s"schemaLength:${schema.length}," +
          s"rowNums:${rowNum}," +
          s"rowsLength:${rows.length}," +
          s"sampleDataLength:${sampleData.length}," +
          s"adaptedRowsLength:${adaptedRows.length}," +
          s"formattedDataLength:${formattedData.length}," +
          s"formattedData:${formattedData.take(5).map(_.mkString(",")).mkString("=>")}")
        val sheetResult = SheetResult(sheetName, "", formattedData.length,
          schema.length, rowOffset, colMarks, schema, formattedData, errorMsg)
        sheetResults.append(sheetResult)
      } else {
        val sheetResult = SheetResult(sheetName, "", 0, 0, 0, Seq.empty[Int],
          Seq.empty[SheetField], Array.empty[Array[String]], "数据不能为空")
        sheetResults.append(sheetResult)
      }
    }
    // 在线上环境需要指定maxRecords，否则会只返回1行表头，未发现原因，但是本地测试又不会出现该问题
    val excelReader = ExcelReader(config, rowHandler, sheetEndHandler, sheetStartHandler)
    excelReader.doRead()
    ExcelResult(sheetResults)
  }

}

object ExcelParser {
  def apply(config: ExcelConfig): ExcelParser = new ExcelParser(config)
}
