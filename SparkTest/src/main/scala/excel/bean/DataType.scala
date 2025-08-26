package excel.bean

abstract class DataType {
  val id: Int
}
object DataType {
  def apply(id: Int): DataType = id match {
    case 0 => NullType
    case 1 => NumberType
    case 2 => StringType
    case 3 => DateTimeType
    case 4 => PointType
    case 5 => LineStringType
    case 6 => PolygonType
  }
}
class NullType private() extends DataType {
  override val id: Int = 0
}
case object NullType extends NullType

class NumberType private() extends DataType {
  override val id: Int = 1
}
case object NumberType extends NumberType

class StringType private() extends DataType {
  override val id: Int = 2
}
case object StringType extends StringType

class DateTimeType private() extends DataType {
  override val id: Int = 3
}
case object DateTimeType extends DateTimeType

class PointType private() extends DataType {
  override val id: Int = 4
}
case object PointType extends PointType

class LineStringType private() extends DataType {
  override val id: Int = 5
}
case object LineStringType extends LineStringType

class PolygonType private() extends DataType {
  override val id: Int = 6
}
case object PolygonType extends PolygonType
