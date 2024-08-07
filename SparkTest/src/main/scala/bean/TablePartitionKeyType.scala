package bean

import org.joda.time.DateTime

import scala.collection.mutable.ArrayBuffer

sealed abstract class TablePartitionKeyType(val code: Int, val name: String) extends Serializable {
  override def toString: String = name
  def partitionKeys: Seq[String] = Seq()
  def realPartitionKeys: Seq[String] = Seq()
  def getPartitionValue(data: Any): ArrayBuffer[Any] = ArrayBuffer()
}


object TablePartitionKeyType {
  def apply(keyType: Int, unit: String, keyList: Seq[String]): TablePartitionKeyType = {
    keyType match {
      case 1 =>
        unit match {
          case "year" => YearPartitionKeyType(keyList)
          case _ => UnsupportedPartitionKeyType()
        }
      case 2 => CustomPartitionKeyType(keyList)
      case _ => UnsupportedPartitionKeyType()
    }
  }

  def getSub(keyType: Int, keyList: Seq[String]): TablePartitionKeyType = {
    keyType match {
      case 1 => YearPartitionKeyType(keyList)
      case 2 => CustomPartitionKeyType(keyList)
      case _ => UnsupportedPartitionKeyType()
    }
  }
}

case class YearPartitionKeyType(keyList: Seq[String])
  extends TablePartitionKeyType(1, "时间字段 按(年)分区") {
  override def partitionKeys: Seq[String] = keyList
  override def realPartitionKeys: Seq[String] = Seq("year")
  override def getPartitionValue(data: Any): ArrayBuffer[Any] = {
    if (data != null) {
      val date = data.asInstanceOf[DateTime]
      ArrayBuffer(date.toString("yyyy"))
    } else ArrayBuffer("0000")
  }
}

case class CustomPartitionKeyType(keyList: Seq[String])
  extends TablePartitionKeyType(5, "按自定义的业务字段分区") {
  override def partitionKeys: Seq[String] = keyList
  override def realPartitionKeys: Seq[String] = keyList
  override def getPartitionValue(data: Any): ArrayBuffer[Any] = ArrayBuffer()
}

case class UnsupportedPartitionKeyType(keyList: Seq[String] = Seq()) extends TablePartitionKeyType(-1, "不支持的分区键类型")