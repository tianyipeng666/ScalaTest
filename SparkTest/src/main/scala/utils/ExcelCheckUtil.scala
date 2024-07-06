package utils

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object ExcelCheckUtil {

  private val fieldsMap = new mutable.HashMap[String, ListBuffer[String]]
  private val tempErrorMap = new mutable.HashMap[Int, ListBuffer[String]]()

  def accumulateAllFields(arr: Array[String], fileName: String): Unit = {
    val fieldsStr = arr.mkString(",")
    if (!fieldsMap.contains(fieldsStr)) {
      val fieldsList = new ListBuffer[String]
      fieldsList += fileName
      fieldsMap += fieldsStr -> fieldsList
    } else {
      fieldsMap.get(fieldsStr).get += fileName
    }
  }

  def getErrorFile(): ListBuffer[String] = {
    if (fieldsMap.size == 1) {
      return null
    }
    fieldsMap.map(entry => {
      tempErrorMap += entry._2.size -> entry._2
    })
    println(fieldsMap.keySet.size)
    null
  }

}
