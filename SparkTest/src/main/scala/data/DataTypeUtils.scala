package data

import excel.bean.{DataType, DateTimeType, LineStringType, NullType, NumberType, PointType, PolygonType, SheetField, StringType}

import java.text.DecimalFormat
import scala.util.control.Exception._


object DataTypeUtils {
  // 匹配标准时间：2018-07-19 00:00:00
  private val REGEX_STANDARD_DATETIME = """\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}"""

  // 匹配常见日期格式：2018-07-19 or 2018/07/19 or 2018年07月19日
  private val REGEX_DATE =
            """\d{4}-\d{1,2}-\d{1,2}|
              #\d{4}/\d{1,2}/\d{1,2}|
              #\d{4}.\d{1,2}.\d{1,2}|
              #\d{4}年\d{1,2}月\d{1,2}日"""
              .stripMargin('#').replaceAll("\n", "")

  // 匹配常见时间格式：2018-07-19 00:00:00 or 2018/07/19 00:00:00 or 2018年07月19日 00:00:00
  private val REGEX_DATETIME =
                 """\d{4}-\d{1,2}-\d{1,2} \d{1,2}:\d{1,2}:\d{1,2}|
                   #\d{4}/\d{1,2}/\d{1,2} \d{1,2}:\d{1,2}:\d{1,2}|
                   #\d{4}.\d{1,2}.\d{1,2} \d{1,2}:\d{1,2}:\d{1,2}|
                   #\d{4}年\d{1,2}月\d{1,2}日 \d{1,2}:\d{1,2}:\d{1,2}"""
                   .stripMargin('#').replaceAll("\n", "")

  private val REGEX_POINT = """POINT (.*)""".r
  private val REGEX_LINESTRING = """LINESTRING (.*)""".r
  private val REGEX_POLYGON = """POLYGON (.*)""".r

  private val numberFormatTL = new ThreadLocal[DecimalFormat]()

  private def getNumberFormat(): DecimalFormat = synchronized {
    var nf = numberFormatTL.get()
    if (nf == null) {
      nf = new DecimalFormat("#.########")
      numberFormatTL.set(nf)
    }
    nf
  }

  def formatRow(rowData: Array[String], fields: Seq[SheetField]): Array[String] = {
    rowData.zipWithIndex.map { case(col, index) =>
      if (index >= 0 && index < fields.length) {
        formatCol(col, fields(index).dataType)
      } else {
        col
      }
    }
  }

  def inferTypeFromDataset(header: Seq[String], dataset: Array[Array[String]], rowOffset: Int = 0): Seq[SheetField] = {
    val dataTypeSeq: Array[DataType] = Array.fill[DataType](header.length)(NullType)
    for (i <- (rowOffset + 1) until dataset.length) {
      val row = dataset(i)
      var j = 0
      // 可能某行列缺失
      while (j < math.min(dataTypeSeq.length, row.length)) {
        dataTypeSeq(j) = inferField(dataTypeSeq(j), row(j))
        j += 1
      }
    }
    header.zip(dataTypeSeq).map{ case (name, dataType) =>
      SheetField(name, dataType)
    }
  }

  private def inferField(typeSoFar: DataType, field: String): DataType = {
    if (field == null || field.isEmpty) {
      typeSoFar
    } else {
      typeSoFar match {
        case NullType => tryParseType(field)
        case NumberType => tryParseNumber(field)
        case DateTimeType => tryParseDateTime(field)
        case StringType => StringType
        case otherType => tryParseType(field)
      }
    }
  }

  private def formatNumber(field: String): String = {
    if (field.endsWith("%")) {
      val num = field.substring(0, field.length - 1)
      if ((allCatch opt num.toDouble).isDefined) {
        return getNumberFormat().format(num.toDouble / 100)
      }
    } else if (field.contains("E")) {
      if ((allCatch opt field.toDouble).isDefined) {
        return getNumberFormat().format(field.toDouble)
      }
    } else {
      if ((allCatch opt field.toDouble).isDefined) {
        return field
      } else {
        if (isInfOrNan(field)) {
          return field
        }
      }
    }
    ""
  }

  private def formatDataTime(field: String): String = {
    // 标准日期直接返回
    if (field.matches(REGEX_STANDARD_DATETIME)) {
      return field
    }
    var date = field
    var time = "00:00:00"
    if (field.indexOf(":") > 0) {  // datatime
      val datatime = field.split(" ")
      if (datatime.length != 2) {
        return ""
      }
      date = datatime(0)
      time = datatime(1)
    }
    date = date.replace("/", "-").replace(".", "-").replace('年', '-').replace('月', '-').replace("日", "")
    val yearMonthDay = date.split("-")
    if (yearMonthDay.length != 3) {
      return ""
    }
    val year = yearMonthDay(0).trim
    val month = yearMonthDay(1).trim
    val day = yearMonthDay(2).trim
    val hourMinuteSecond = time.split(":")
    if (hourMinuteSecond.length != 3) {
      return ""
    }
    val hour = hourMinuteSecond(0).trim
    val minute = hourMinuteSecond(1).trim
    val second = hourMinuteSecond(2).trim
    s"$year-${zeroPadded(month)}-${zeroPadded(day)} ${zeroPadded(hour)}:${zeroPadded(minute)}:${zeroPadded(second)}"
  }

  private def zeroPadded(numStr: String): String = {
    if (numStr.length < 2) {
      return s"0$numStr"
    }
    numStr
  }

  private def isInfOrNan(field: String): Boolean = {
    field == "NaN" || field == "Inf" || field == "-Inf"
  }

  private def tryParseType(field: String): DataType = {
    field match {
      case REGEX_POINT(_) => PointType
      case REGEX_LINESTRING(_) => LineStringType
      case REGEX_POLYGON(_) => PolygonType
      case _ => tryParseNumber(field)
    }
  }

  private def tryParseNumber(field: String): DataType = {
    // 百分比
    if (field.endsWith("%") && (allCatch opt field.substring(0, field.length - 1).toDouble).isDefined) {
      NumberType
    } else if ((allCatch opt field.toDouble).isDefined || isInfOrNan(field)) {
      NumberType
    } else {
      tryParseDateTime(field)
    }
  }

  def tryParseDateTime(field: String): DataType = {
    if (field.matches(REGEX_DATETIME) || field.matches(REGEX_DATE)) {
      DateTimeType
    } else {
      StringType
    }
  }

  private def formatCol(col: String, dataType: DataType): String = {
    if (col == null || col.isEmpty) return ""
    dataType match {
      case NumberType => formatNumber(col)
      case DateTimeType => formatDataTime(col)
      case _ => col
    }
  }

}
