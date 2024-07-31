package constant

object ConstantKey {

  /**
   * REDIS
   */
  val redisKeyPrefix = "redisPrefix"

  val ASYNC_COMMIT_TMP_TASK = s"$redisKeyPrefix:m:commit_tmp:task:typ"

  val ASYNC_COMMIT_TASK = s"$redisKeyPrefix:m:commit:task:typ"

  def asyncResult(tbName: String, traceId: String): String = s"$redisKeyPrefix:m:commit:result:$tbName:$traceId"

  def lockTable(tbName: String): String = s"$redisKeyPrefix:locktable:$tbName"

}
