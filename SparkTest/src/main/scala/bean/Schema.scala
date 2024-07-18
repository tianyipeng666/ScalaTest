package bean

case class Schema(name: String, seq_no: Int, `type`: String, options: Option[String] = None)
