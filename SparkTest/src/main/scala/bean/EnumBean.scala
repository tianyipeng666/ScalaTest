package bean

object EnumBean extends Enumeration {
  type EnumBean = EnumBean.Value

  // 文件类型
  val TEXT = Value("text")
  val PARQUET = Value("parquet")
  val ORC = Value("orc")
  val EXCEL = Value("excel")

}
