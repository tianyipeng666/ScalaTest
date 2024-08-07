package bean

case class TablePartitionInfo(
                               partitionType: TablePartitionType = NotPartitionType,
                               partitionKeyType: TablePartitionKeyType = UnsupportedPartitionKeyType(),
                               enumType: EnumBean.Value = EnumBean.EXCEL,
                               var commitPartitionList: Seq[String] = Seq(),
                               var needMergePartitionList: Seq[String] = Seq(),
                               var deletedPartitionList: Seq[String] = Seq(),
                               var needClean: Boolean = false)
