package excel

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
    try {
      if (fieldsMap.size == 1) {
        return null
      }
      val resBuffer = new ListBuffer[String]
      fieldsMap.foreach(entry => {
        val listBuffer = entry._2
        if (tempErrorMap.contains(listBuffer.size)) {
          val value = tempErrorMap.get(listBuffer.size).get
          listBuffer.foreach(elem => {
            value += elem
          })
        } else {
          tempErrorMap += entry._2.size -> entry._2
        }
      })
      val maxInt = tempErrorMap.keySet.max
      tempErrorMap.filter(_._1 != maxInt).foreach(entry => {
        resBuffer ++= entry._2
      })
      resBuffer
    } catch {
      case e: Exception =>
        e.printStackTrace()
        null
    } finally {
      fieldsMap.clear()
      tempErrorMap.clear()
    }
  }

  def main(args: Array[String]): Unit = {
    val fileName = "aaa.xls"
    val filterSet = mutable.Set("XLS", "XLSX")
    println(filterSet.contains(fileName.split("\\.").last.toUpperCase()))
  }

}
