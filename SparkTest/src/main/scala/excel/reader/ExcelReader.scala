package excel.reader

import excel.bean.ExcelConfig
import log.LazyLogging

abstract class ExcelReader(config: ExcelConfig,
                           rowHandler: (Int, Array[String]) => Unit,
                           sheetEndHandler: (String, Int, String) => Unit,
                           sheetStartHandler: (String) => Unit,
                           maxRecords: Int = Int.MaxValue) extends LazyLogging {

  protected def inSelected(sheetName: String): Boolean = {
    config.sheetList.isEmpty || config.sheetList.filter(_.name == sheetName).headOption.isDefined
  }

  def doRead(): Unit
}

object ExcelReader {

  def apply(config: ExcelConfig,
            rowHandler: (Int, Array[String]) => Unit,
            sheetEndHandler: (String, Int, String) => Unit,
            sheetStartHandler: (String) => Unit,
            maxRecords: Int = Int.MaxValue): ExcelReader = {
    config.fileType match {
      case ".XLS" => new XlsReader(config, rowHandler, sheetEndHandler, sheetStartHandler, maxRecords)
      case ".XLSX" => new XlsxReader(config, rowHandler, sheetEndHandler, sheetStartHandler, maxRecords)
      case _ => throw new Exception(s"unsupported file type, fileType=${config.fileType}")
    }
  }
}
