import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import utils.ExcelCheckUtil

import java.io.File

object SparkMain {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkExcel")
    val session = SparkSession.builder().config(conf).enableHiveSupport().getOrCreate()

    // macOS
    // val path = "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/files/"
    // windows
    val path = "D:\\项目\\idea\\idea-project\\ScalaTest\\SparkTest\\files"
    val file = new File(path)
    file.listFiles.foreach(file => {
      println(file.getName)
      val df = session.read
        .format("com.crealytics.spark.excel")
        .option("header", "true")  // Required   // Optional, default: true
        .option("treatEmptyValuesAsNulls", "false")
        //.schema(peopleSchema) // Optional, default: Either inferred schema, or all columns are Strings
        .load(file.getAbsolutePath)
        //.option("dataAddress", "'My Sheet'!B3:C35") // Optional, default: "A1"
        //.option("setErrorCellsToFallbackValues", "true") // Optional, default: false, where errors will be converted to null. If true, any ERROR cell values (e.g. #N/A) will be converted to the zero values of the column's data type.
        //.option("usePlainNumberFormat", "false") // Optional, default: false, If true, format the cells without rounding and scientific notations
        //.option("inferSchema", "true") // Optional, default: false
        //.option("addColorColumns", "true") // Optional, default: false
        //.option("timestampFormat", "yyyy-mm-dd") // Optional, default: yyyy-mm-dd hh:mm:ss[.fffffffff]
        //.option("maxRowsInMemory", 20) // Optional, default None. If set, uses a streaming reader which can help with big files (will fail if used with xls format files)
        //.option("maxByteArraySize", 2147483647) // Optional, default None. See https://poi.apache.org/apidocs/5.0/org/apache/poi/util/IOUtils.html#setByteArrayMaxOverride-int-
        //.option("tempFileThreshold", 10000000) // Optional, default None. Number of bytes at which a zip entry is regarded as too large for holding in memory and the data is put in a temp file instead
        //.option("excerptSize", 10) // Optional, default: 10. If set and if schema inferred, number of rows to infer schema from
        //.option("workbookPassword", "pass") // Optional, default None. Requires unlimited strength JCE for older JVMs
      df.show(1)
      ExcelCheckUtil.accumulateAllFields(df.columns, file.getName)
    })
    ExcelCheckUtil.getErrorFile()
  }
}
