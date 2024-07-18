package excel.reader

import excel.hander.XlsxHander
import org.apache.poi.openxml4j.opc.{OPCPackage, PackageAccess}
import org.apache.poi.openxml4j.util.ZipSecureFile
import org.apache.poi.xssf.eventusermodel.XSSFReader
import org.apache.poi.xssf.model.{SharedStrings, StylesTable}
import org.xml.sax.InputSource

import java.io.{File, InputStream}
import javax.xml.parsers.SAXParserFactory

class XlsxReader(path: String, maxRecords: Int = Int.MaxValue) {

  def doRead(): Unit = {
    // 这里下载到本地是为了防止解析内存爆仓
    ZipSecureFile.setMinInflateRatio(0)
    val xlsxPackage = OPCPackage.open(new File(path), PackageAccess.READ)
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
    val xlsxHander = new XlsxHander(st, sst, maxRecords)
    try {
      val saxFactory = SAXParserFactory.newInstance()
      val saxParser = saxFactory.newSAXParser()
      val sheetParser = saxParser.getXMLReader()
      sheetParser.setContentHandler(xlsxHander)
      val sheetSource = new InputSource(in)
      sheetParser.parse(sheetSource)
    } catch {
      case e: Exception => if (e.getMessage == null || !e.getMessage.startsWith("sheetEnd")) {
      }
    }
  }
}
