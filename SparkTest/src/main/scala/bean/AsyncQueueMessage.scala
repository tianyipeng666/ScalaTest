package bean

case class AsyncQueueMessage(data: String,
                             traceId: String,
                             queue: String = "",
                             requestTime: Long = System.currentTimeMillis())
