package string


import scala.collection.mutable.ArrayBuffer
import scala.math.pow

object StringUtils {

  def getTransformPartitionColumn(partitionColumn: String): String = {
    val partitionArr = partitionColumn.split(",")
    val builder = new StringBuilder()
    val length = partitionArr.length
    for (i <- 0 to length - 1) {
      val offset = length - i - 1
      if (offset > 0) {
        builder.append(s"${partitionArr(i)} * ${pow(100, offset).toString().stripSuffix(".0")} +")
      } else {
        builder.append(s"${partitionArr(i)}")
      }
    }
    builder.toString()
  }

  def zipPartitionUnitWithValue(partitionList: ArrayBuffer[String], partitionColumn:String):String = {
    // year=2024/month=12/day=03
    val partitionColumnArr = partitionColumn.split(",")
    val partitionStr = partitionList.map { p =>
      val partitionUnitArr = p.split(",")
      s"PARTITION `${
        partitionColumnArr.zip(partitionUnitArr)
          .map {
            case (c, v) => s"${c.trim}=${v.trim}"
          }.mkString("/")
      }` VALUES IN (${partitionUnitArr.mkString})"
    }.mkString("(", ", ", ")")
    partitionStr
  }

}
