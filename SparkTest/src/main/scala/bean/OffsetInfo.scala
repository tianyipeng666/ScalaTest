package bean

case class OffsetInfo(topic: String, lastOffset: Long, var currentOffset: Long)
