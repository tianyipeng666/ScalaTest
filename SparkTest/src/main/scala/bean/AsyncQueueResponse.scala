package bean

case class AsyncQueueResponse(status: Int,
                              errMsg: String,
                              result: String,
                              queue: String,
                              method: String
                             )
