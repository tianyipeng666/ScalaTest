package bean

case class AsyncQueueMessage(data: String,
                             dbType: String = "",
                             traceId: String,
                             queue: String = "",
                             requestTime: Long = System.currentTimeMillis())
