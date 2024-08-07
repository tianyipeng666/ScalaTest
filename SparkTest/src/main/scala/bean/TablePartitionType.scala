package bean

sealed abstract class TablePartitionType(val code: Int, val name: String) extends Serializable  {
  override def toString: String = name
}

object TablePartitionType {
  def apply(code: Int): TablePartitionType = {
    code match {
      case 1 => NotPartitionType
      case 2 => NormalPartitionType
      case 3 => IncrementalPartitionType
      case _ => UnsupportedPartitionType
    }
  }
}

case object NotPartitionType extends TablePartitionType(1, "非分区表")
case object NormalPartitionType extends TablePartitionType(2, "高性能pk分区表")
case object IncrementalPartitionType extends TablePartitionType(3, "增量分区表")
case object UnsupportedPartitionType extends TablePartitionType(-1, "不支持的分区类型")
