package source

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

object HttpSourceUtils {

  def fullQuantityPull(session: SparkSession): Unit = {
    val start = System.currentTimeMillis()
    val df = session.read.format("http_v1")
      .option("url", "http://192.168.1.166:44120")
      .option("name", "z98eb6b13d7540979a10b8ca8d07b340")
      .option("db", "bdp")
      .load
    df.createOrReplaceTempView("partition_temp")
    session.table("partition_temp").persist(StorageLevel.MEMORY_AND_DISK)
    session.sql("select count(1) from partition_temp").show()
    session.sql("select * from partition_temp").show(50)
    val end = System.currentTimeMillis()
    println(s"cost time => ${(end - start) / 1000 / 60}")
    df.unpersist(false)
  }

  def filterQuantityPull(): Unit = {

  }

}
