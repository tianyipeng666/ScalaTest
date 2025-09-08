package excel

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import org.apache.poi.ss.usermodel._
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import java.io.FileOutputStream
import java.nio.file.{Files, Paths}
import java.util.concurrent.ThreadLocalRandom


object ExcelCheckUtil {


  def main(args: Array[String]): Unit = {
    createXlsxFile()
  }

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

  private def createXlsxFile() = {
    val ROWS     = 500000           // 行数
    val COLS     = 60               // 列数
    val RAND_LEN = 12               // 每格随机字符串长度
    val outPath  = Paths.get("huge_500k_60cols.xlsx")

    // SXSSFWorkbook: 流式写，窗口行数（内存缓存）可根据机器内存调大/小
    val wb = new SXSSFWorkbook(1000)
    wb.setCompressTempFiles(true)   // 压缩临时文件，减少磁盘占用
    try {
      val sheet = wb.createSheet("data")

      // 统一设置“文本”格式（"@"），防止被 Excel 识别为数字/日期
      val df: DataFormat = wb.createDataFormat()
      val textStyle = wb.createCellStyle()
      textStyle.setDataFormat(df.getFormat("@"))
      for (c <- 0 until COLS) {
        sheet.setDefaultColumnStyle(c, textStyle)
      }

      // 可选：表头
      val header = sheet.createRow(0)
      for (c <- 0 until COLS) {
        val cell = header.createCell(c, CellType.STRING)
        cell.setCellValue(s"col_${c + 1}")
      }

      // 数据行（从第 2 行开始写，行号 1）
      var r = 1
      while (r <= ROWS) {
        val row = sheet.createRow(r)
        var c = 0
        while (c < COLS) {
          val cell = row.createCell(c, CellType.STRING)
          cell.setCellValue(randomStr(RAND_LEN))
          c += 1
        }
        if (r % 10000 == 0) println(s"written rows: $r")
        r += 1
      }

      // 持久化到文件
      if (Files.exists(outPath)) Files.delete(outPath)
      val fos = new FileOutputStream(outPath.toFile)
      try wb.write(fos) finally fos.close()

      println(s"Done → ${outPath.toAbsolutePath}")
    } finally {
      // 释放 SXSSF 产生的临时文件
      wb.dispose()
      wb.close()
    }
  }

  private def randomStr(len: Int) = {
    val alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray
    val rnd = ThreadLocalRandom.current
    val buf = new Array[Char](len)
    for (i <- 0 until len) {
      buf(i) = alphabet(rnd.nextInt(alphabet.length))
    }
    new String(buf)
  }

}
