package excel.reader

import data.DataSetUtils
import excel.bean.ExcelConfig
import org.apache.poi.ss.usermodel.{Cell, CellType, DateUtil, Sheet, WorkbookFactory}

import java.io.{File, FileInputStream}
import java.text.{DecimalFormat, SimpleDateFormat}
import scala.collection.mutable.ArrayBuffer

class XlsReader(config: ExcelConfig,
                rowHandler: (Int, Array[String]) => Unit,
                sheetEndHandler: (String, Int, String) => Unit,
                sheetStartHandler: (String) => Unit,
                maxRecords: Int = Int.MaxValue)
  extends ExcelReader(config, rowHandler, sheetEndHandler, sheetStartHandler, maxRecords) {

  private val sdfNormal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  private val sdfHourMinSec = new SimpleDateFormat("HH:mm:ss")
  private val numberFormat = new DecimalFormat("#.########")

  def doRead(): Unit = {
    var errorMsg = ""
    val in = new FileInputStream(new File(config.filePath))
    // 根据文件类型返回对应的workbook
    val workbook = WorkbookFactory.create(in)
    println("============" + workbook.getClass.getSimpleName + "============")
    val sheetNum = workbook.getNumberOfSheets
    var rowNum = 0
    var i = 0
    while (i < sheetNum) {
      val sheet = workbook.getSheetAt(i)
      val sheetName = sheet.getSheetName.trim
      try {
        sheetStartHandler(sheetName)
        rowNum = parseSheet(sheet)
      } catch {
        case e: Exception => e.printStackTrace()
      }
      sheetEndHandler(sheetName, rowNum, errorMsg)
      i += 1
    }
    workbook.close()
    in.close()
  }

  private def parseSheet(sheet: Sheet): Int = {
    val rowIter = sheet.iterator()
    val rowBuffer = new ArrayBuffer[String]()
    var rowNum = 0
    while (rowIter.hasNext && rowNum < maxRecords) {
      val row = rowIter.next()
      if (row != null) {
        for (cellnum <- 0 until row.getLastCellNum) {
          val cell = row.getCell(cellnum)
          val cellValue = formatCellValue(cell)
          rowBuffer.append(cellValue)
        }
        val rowData = rowBuffer.toArray
        if (DataSetUtils.checkRowNotEmpty(rowData)) {
          println(rowNum + "==>" + DataSetUtils.dataTrim(rowData).mkString(","))
          rowHandler(rowNum, DataSetUtils.dataTrim(rowData))
          rowNum += 1
        }
        rowBuffer.clear()
      }
    }
    rowNum
  }

  private def isCellDateFormatted(cell: Cell): Boolean = {
    var b = DateUtil.isCellDateFormatted(cell)
    val style = cell.getCellStyle()
    if (!b && style != null) {
      val formatString = Option(style.getDataFormatString).getOrElse("")
      b = formatString.contains("年") && formatString.contains("月")
    }
    b
  }

  private def formatFormula(cell: Cell): String = {
    val resultType = cell.getCachedFormulaResultType
    resultType match {
      case CellType.STRING => cell.getStringCellValue
      case CellType.ERROR => ""
      case CellType.NUMERIC =>
        if (isCellDateFormatted(cell)) {
          val date = cell.getDateCellValue
          if (date == null) {
            ""
          } else {
            sdfNormal.format(date)
          }
        } else {
          numberFormat.format(cell.getNumericCellValue)
        }
      case _ => cell.toString.trim
    }
  }

  private def formatCellValue(cell: Cell): String = {
    if (cell == null) {
      return ""
    }
    val cellType = cell.getCellType
    cellType match {
      case CellType.STRING => cell.getStringCellValue
      case CellType.ERROR => ""
      case CellType.FORMULA => formatFormula(cell)
      case CellType.NUMERIC =>
        if (isCellDateFormatted(cell)) {
          val date = cell.getDateCellValue
          if (date == null) {
            ""
          } else {
            sdfNormal.format(date)
          }
        } else {
          numberFormat.format(cell.getNumericCellValue)
        }
      case _ => cell.toString.trim
    }
  }
}
