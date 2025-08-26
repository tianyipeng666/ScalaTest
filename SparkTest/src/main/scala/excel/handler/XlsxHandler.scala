package excel.handler

import data.DataSetUtils
import org.apache.poi.ss.usermodel.{BuiltinFormats, DateUtil}
import org.apache.poi.xssf.model.{SharedStrings, StylesTable}
import org.apache.poi.xssf.usermodel.XSSFRichTextString
import org.xml.sax.{Attributes, SAXException}
import org.xml.sax.helpers.DefaultHandler

import java.text.{DecimalFormat, SimpleDateFormat}
import scala.collection.mutable.ArrayBuffer

private[excel] class XlsxHandler(st: StylesTable,
                                 sst: SharedStrings,
                                 maxRecords: Int,
                                 rowHandler: (Int, Array[String]) => Unit) extends DefaultHandler {

  private object XssfDataType extends Enumeration {
    val BOOLEAN, ERROR, FORMULA, INLINE_STRING, SST_STRING, NUMBER, DATETIME = Value
  }

  private val sdfNormal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  private val sdfHourMinSec = new SimpleDateFormat("HH:mm:ss")
  private val numberFormat = new DecimalFormat("#.########")
  private var formatIndex = 0
  private var formatString: String = null
  private val lastContents = new StringBuilder()
  private var nextDataType = XssfDataType.NUMBER
  private val rowBuffer = new ArrayBuffer[String]()
  // 当前行
  private var rowNum = 0
  // 当前列
  private var curCol = 0
  // 定义前一个元素和当前元素的位置，用来计算其中空的单元格数量，如A6和A8等
  private var preRef: String = null

  private var ref: String = null
  private var isTElement = false

  def getRowNum: Int = rowNum

  @throws[SAXException]
  override def startElement(uri: String, localName: String, name: String, attributes: Attributes): Unit = { // c => 单元格
    // c => 单元格
    if ("c".equals(name)) {
      // 当前单元格的位置
      ref = attributes.getValue("r")
      val cellType = attributes.getValue("t")
      val cellStyleStr = attributes.getValue("s")
      nextDataType = XssfDataType.NUMBER
      if ("b".equals(cellType)) {
        nextDataType = XssfDataType.BOOLEAN
      } else if ("e".equals(cellType)) {
        nextDataType = XssfDataType.ERROR
      } else if ("inlineStr".equals(cellType)) {
        nextDataType = XssfDataType.INLINE_STRING
      } else if ("s".equals(cellType)) {
        nextDataType = XssfDataType.SST_STRING
      } else if ("str".equals(cellType)) {
        nextDataType = XssfDataType.FORMULA
      } else if (cellStyleStr != null) {
        val styleIndex = cellStyleStr.toInt
        val style = st.getStyleAt(styleIndex)
        formatIndex = style.getDataFormat
        formatString = Option(style.getDataFormatString).getOrElse(BuiltinFormats.getBuiltinFormat(formatIndex))
        if (formatString != null) {
          if (DateUtil.isADateFormat(formatIndex, formatString)) {
            nextDataType = XssfDataType.DATETIME
          } else if (formatString.contains("年") && formatString.contains("月")) {
            nextDataType = XssfDataType.DATETIME
          }
        }
      }
    } else if ("sheetData".equals(localName)) {
      // Handle any "missing" cells which had comments attached
    }
    // 当元素为t时
    isTElement = "t".equals(name)
    // 置空
    lastContents.clear()

  }


  @throws[SAXException]
  override def endElement(uri: String, localName: String, name: String): Unit = {

    if (isTElement) {
      val value = lastContents.toString().trim
      updateRef()
      rowBuffer.append(value)
      curCol += 1
      isTElement = false
    } else if ("v".equals(name)) {
      var value = lastContents.toString.trim
      nextDataType match {
        case XssfDataType.BOOLEAN =>
          val first = value.charAt(0)
          value = if (first == '0') "FALSE" else "TRUE"
        case XssfDataType.ERROR =>
          value = ""
        case XssfDataType.FORMULA =>
          value = value
        case XssfDataType.INLINE_STRING =>
          val rtsi = new XSSFRichTextString(value)
          value = rtsi.toString
        case XssfDataType.SST_STRING =>
          try {
            val idx = value.toInt
            val rtss = sst.getItemAt(idx)
            value = rtss.getString
          } catch {
            case ex: Exception => value = ""
          }
        case XssfDataType.DATETIME =>
          val date = DateUtil.getJavaDate(value.toDouble)
          if (date == null) {
            value = ""
          } else {
            value = sdfNormal.format(date)
          }
        case XssfDataType.NUMBER =>
          value = numberFormat.format(value.toDouble)
      }
      updateRef()
      rowBuffer.append(value)
      curCol += 1
    } else if ("row".equals(name)) {
      val rowData = rowBuffer.toArray
      if (DataSetUtils.checkRowNotEmpty(rowData)) {
        // 每行解析，添加
        // println(rowNum + "==>" + DataSetUtils.dataTrim(rowData).mkString(","))
        rowHandler(rowNum, DataSetUtils.dataTrim(rowData))
        rowNum += 1
      }
      rowBuffer.clear()
      if (rowNum > maxRecords) {
        throw new Exception(s"sheetEnd, rowNum=$rowNum")
      }
      curCol = 0
      preRef = null
      ref = null
    }
  }

  private def updateRef(): Unit = {
    // 补全单元格之间的空单元格
    if (!ref.equals(preRef)) {
      // 填充第一列开始为空的列
      if (preRef == null && ref.replaceAll("//d+", "") != "A") {
        preRef = "@"
      }
      if (preRef != null) {
        var len = countNullCell(ref, preRef)
        while (len > 0) {
          rowBuffer.append("")
          curCol += 1
          len -= 1
        }
      }
      preRef = ref
    }
  }

  @throws[SAXException]
  override def characters(ch: Array[Char], start: Int, length: Int): Unit = {
    lastContents.append(new String(ch, start, length))
  }

  private def countNullCell(ref: String, preRef: String): Int = {
    // excel2007最大行数是1048576，最大列数是16384，最后一列列名是XFD
    var xfd = ref.replaceAll("\\d+", "")
    var xfd_1 = preRef.replaceAll("\\d+", "")

    xfd = fillChar(xfd, 3, '@', true)
    xfd_1 = fillChar(xfd_1, 3, '@', true)
    val letter = xfd.toCharArray()
    val letter_1 = xfd_1.toCharArray()
    val res = (letter(0) - letter_1(0)) * 26 * 26 + (letter(1) - letter_1(1)) * 26 + (letter(2) - letter_1(2))
    res - 1
  }

  private def fillChar(str: String, len: Int, let: Char, isPre: Boolean): String = {
    val len_1 = str.length
    var res = str
    if (len_1 < len) {
      for (i <- 0 until (len - len_1)) {
        if (isPre) {
          res = let + res
        } else {
          res = res + let
        }
      }
    }
    res
  }
}
