package bean

/**
 *
 * @param batchId: 批次号
 * @param triggerTimestamp：批次触发时间
 * @param numInputRows：输入行数
 * @param durationTime：批次处理时间（毫秒）
 * @param offsetsBehindLatest：平均落后条数
 * @param inputRowsPerSecond：每秒输入行数
 * @param processedRowsPerSecond：每秒处理行数
 */
case class StreamingMonitorInfo(batchId: Integer,
                                triggerTimestamp: String,
                                numInputRows: Integer,
                                durationTime: Integer,
                                offsetsBehindLatest: Long,
                                inputRowsPerSecond: Integer,
                                processedRowsPerSecond: Integer)
