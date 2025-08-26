package excel.reader

import excel.bean.ExcelConfig
import excel.handler.XlsxHandler
import org.apache.poi.openxml4j.opc.{OPCPackage, PackageAccess}
import org.apache.poi.openxml4j.util.ZipSecureFile
import org.apache.poi.xssf.eventusermodel.XSSFReader
import org.apache.poi.xssf.model.{SharedStrings, StylesTable}
import org.xml.sax.InputSource

import java.io.{File, InputStream}
import javax.xml.parsers.SAXParserFactory

class XlsxReader(config: ExcelConfig,
                 rowHandler: (Int, Array[String]) => Unit,
                 sheetEndHandler: (String, Int, String) => Unit,
                 sheetStartHandler: (String) => Unit,
                 maxRecords: Int = Int.MaxValue)
  extends ExcelReader(config, rowHandler, sheetEndHandler, sheetStartHandler, maxRecords) {

  def doRead(): Unit = {
    ZipSecureFile.setMinInflateRatio(0)
    val xlsxPackage = OPCPackage.open(new File(config.filePath), PackageAccess.READ)
    try {
      val xssfReader = new XSSFReader(xlsxPackage)
      val sst = xssfReader.getSharedStringsTable
      val styles = xssfReader.getStylesTable
      val iter = xssfReader.getSheetsData.asInstanceOf[XSSFReader.SheetIterator]
      while (iter.hasNext) {
        val stream = iter.next
        val sheetName = iter.getSheetName.trim
        parseSheet(styles, sst, stream, sheetName)
        stream.close()
      }
    } finally {
      xlsxPackage.close()
    }
  }

  private def parseSheet(st: StylesTable, sst: SharedStrings, in: InputStream, sheetName: String): Unit = {
    var errorMsg = ""
    val xlsxHandler = new XlsxHandler(st, sst, maxRecords, rowHandler)
    try {
      sheetStartHandler(sheetName)
      val saxFactory = SAXParserFactory.newInstance()
      val saxParser = saxFactory.newSAXParser()
      val sheetParser = saxParser.getXMLReader()
      sheetParser.setContentHandler(xlsxHandler)
      val sheetSource = new InputSource(in)
      sheetParser.parse(sheetSource)
    } catch {
      case e: Exception => if (e.getMessage == null || !e.getMessage.startsWith("sheetEnd")) {
        logger.error(s"parse XLSX error, config=$config", e)
        errorMsg = s"parse error, msg=${e.printStackTrace()}"
      }
    }
    sheetEndHandler(sheetName, xlsxHandler.getRowNum, errorMsg)
  }
}
