package excel.bean

import org.json4s.{JValue, _}
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._


 /**
  * @param name 列名
  * @param dataType   1 [number, percent] 2 [null, string] 3 [date, datetime]
  */
case class SheetField(name: String, dataType: DataType) {
   def toJson(): JValue = {
     ("name" -> name) ~ ("data_type" -> dataType.id)
   }
   override def toString(): String = {
     compact(toJson())
   }
}

case class SheetResult(
             name: String,
             sheetId: String,
             rowNum: Int,
             colNum: Int,
             rowOffset: Int,
             colMarks: Seq[Int],
             fields: Seq[SheetField],
             data: Array[Array[String]],
             errorMsg: String = "") {
  def toJson(): JValue = {
    ("name" -> name) ~ ("sheet_id" -> sheetId) ~ ("row_num" -> rowNum) ~ ("col_num" -> colNum) ~
    ("row_offset" -> rowOffset) ~ ("col_offset" -> colOffset) ~ ("col_marks" -> colMarks) ~
    ("schema" -> fields.map(_.toJson())) ~ ("data" -> data.toSeq.map(_.toSeq)) ~ ("error_msg" -> errorMsg)
  }

  override def toString(): String = {
    compact(toJson())
  }

  def colOffset: Int = {
    for (i <- 0 until colMarks.length) {
      if (colMarks(i) == 1) {
        return i
      }
    }
    colMarks.length
  }
}

case class ExcelResult(sheetResults: Seq[SheetResult]) {
  def result: JValue = {
    sheetResults.map(_.toJson())
  }

  override def toString(): String = {
    compact(result)
  }
}

case class UDT(
           name: String,
           fieldId: Option[String] = None,
           dataType: Int,
           defaultValue: Option[String] = None) {
  def fieldName: String = fieldId.getOrElse(name)
}

case class Sheet(
           name: String,
           sheetId: String,
           schema: Seq[UDT],
           rowOffset: Int,
           colMarks: Seq[Int])

case class ExcelConfig(
           filePath: String,
           fileType: String,
           fileName: String,
           sheetList: Seq[Sheet],
           delimiter: Option[String] = None)


case class ExcelAppend(
            excelId: String,
            sheetId: String,
            schema: Seq[UDT])


