package excel

import bean.Schema
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructField

import java.io.File
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object SparkExcelUtil {

  private val filesPath = new mutable.ArrayBuffer[String]()
  def previewExcel(session: SparkSession, src: String): Seq[Schema] = {
    val resBuffer = new ArrayBuffer[Schema]()
    var i = 0
    val df = session.read
      .format("excel")
      .option("dataAddress", "A6")
      .option("header", "true")
      .option("columnNameOfRowNumber", "行号")
      .load(src)
    df.schema.fields.foreach(field => {
      i += 1
      resBuffer.append(Schema(field.name, i, field.dataType.simpleString))
    })
    resBuffer
  }

  def excelResolve(session: SparkSession, isFlatten: Boolean, src: String, des: String): Unit = {
    if (isFlatten) {
      val df = session.read
        .format("excel")
        .option("dataAddress", "A6")
        .option("header", "true")
        .option("columnNameOfRowNumber", "行号")
        .load(src)
      df.write.
        option("header", "true").
        csv(des + "/testExcel3")
      session.read.
        option("header", "true").
        csv(des + "/testExcel3")
        .show(10000)
    } else {
      filesPath.append("/20240713/test.xlsx")
      filesPath.append("/20240713/test2.xlsx")
      filesPath.append("/20240714/test2.xlsx")
      filesPath.append("/20240715/test.xlsx")
      val buffer = mutable.ArrayBuffer[String]()
      filesPath.foreach(path => {
        val parentPath = new File(path).getParent()
        if (!buffer.contains(parentPath)) {
          buffer.append(parentPath)
        }
      })
      buffer.foreach(parentPath => {
        val df = session.read
          .format("excel")
          .option("dataAddress", "A6")
          .option("columnNameOfRowNumber", "行号")
          .option("header", "true")
          .load(src + s"/$parentPath")
        df.write.
          option("header", "true").
          csv(des + s"/testExcel2/$parentPath")
      })

    }
  }

}
