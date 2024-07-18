package data

import scala.collection.mutable.ArrayBuffer

object DataSetUtils {

  def dataTrim(row: Array[String]): Array[String] = {
    row.map { col =>
      if (col == null) {
        ""
      } else {
        col.trim
      }
    }
  }

  def adaptedRow(rowData: Array[String], headerLen: Int): Array[String] = {
    if (rowData.length > headerLen) {
      rowData.zipWithIndex.filter(_._2 < headerLen).map(_._1)
    } else if (rowData.length < headerLen) {
      rowData ++ Array.fill[String](headerLen - rowData.length)("")
    } else {
      rowData
    }
  }

  def cleanEmptyCol(row: Array[String], colMarks: Seq[Int]): Array[String] = {
    val rowBuffer = new ArrayBuffer[String]()
    for (i <- 0 until row.length) {
      if (i < colMarks.length && colMarks(i) == 1) {
        rowBuffer.append(row(i))
      }
    }
    rowBuffer.toArray
  }

  def markEmptyCol(rows: Array[Array[String]]): Seq[Int] = {
    val maxRowLen = rows.map(_.length).max
    val colMarks = Array.fill(maxRowLen)(1)
    var i = 0
    while (i < maxRowLen) {
      val isEmptyCol = rows.filter { row =>
        (i < row.length) && (row(i) != null) && (row(i) != "")
      }.isEmpty
      if (isEmptyCol) {
        colMarks(i) = 0
      }
      i += 1
    }
    return colMarks
  }

  def inferRowOffset(dataset: Array[Array[String]]): Int = {
    if (dataset.length == 0) return 0
    val maxRowLen = dataset.map(_.length).max
    val headerLen = maxRowLen + rightColOffset(dataset, maxRowLen)
    var rowOffset = 0
    var i = 0
    def needOffset(i: Int): Boolean = {
      if (i < dataset.length) {
        dataset(i).filter { col =>
          col != null && col.trim != ""
        }.length * 2 < headerLen
      } else {
        false
      }
    }
    while (needOffset(i)) {
      rowOffset += 1
      i += 1
    }
    if (rowOffset >= dataset.length) {
      rowOffset = dataset.length - 1
    }
    rowOffset
  }

  def rightColOffset(dataset: Array[Array[String]], rowLength: Int): Int = {
    var rightOffset = 0
    var i = rowLength - 1
    def needOffset(i: Int): Boolean = {
      dataset.filter( row => row.length > i && row(i) != "" && row(i) != null).isEmpty
    }
    while (needOffset(i)) {
      rightOffset -= 1
      i -= 1
    }
    rightOffset
  }

  def checkRowNotEmpty(data: Array[String]): Boolean = {
    data != null && data.filter(c => c != null && c.trim.nonEmpty).size > 0
  }

  def filterEmptyAndTrim(iter: Iterator[String]): Iterator[String] = {
    iter.filter { line =>
      line != null && line.trim.nonEmpty
    }.map(_.trim)
  }

  def makeHeader(dataset: Array[Array[String]], rowOffset: Int = 0): Array[String] = {
    val maxRowLen = dataset.map(_.length).max
    val headerLen = maxRowLen + rightColOffset(dataset, maxRowLen)
    val headRow = adaptedRow(dataset(rowOffset), headerLen)
    headRow.map { value =>
      if (value == null) {
        ""
      } else {
        value
      }
    }
  }

}
