package bean

case class CommitInfo(tbName: String,
                      path: String,
                      mode: Int,
                      traceId: String)
