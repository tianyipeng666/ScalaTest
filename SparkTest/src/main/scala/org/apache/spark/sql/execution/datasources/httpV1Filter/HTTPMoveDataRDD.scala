package org.apache.spark.sql.execution.datasources.httpV1Filter

import com.alibaba.fastjson.JSONObject
import constant.ConstantPath
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.UTF8String
import org.apache.spark.util.SerializableConfiguration
import org.apache.spark.{Partition, SparkContext, TaskContext}

object HTTPMoveDataRDD {

  def scanTable(sc: SparkContext,
                schema: StructType,
                requiredColumns: Array[String],
                parts: Array[Partition],
                serHadoopConf: SerializableConfiguration,
                httpOptions: HttpOptions): RDD[Row] = {
    new HTTPMoveDataRDD(sc,
      pruneSchema(schema, requiredColumns),
      parts,
      serHadoopConf,
      httpOptions)
  }

  /**
   * Prune all but the specified columns from the specified Catalyst schema.
   *
   * @param schema  - The Catalyst schema of the master table
   * @param columns - The list of desired columns
   * @return A Catalyst schema corresponding to columns in the given order.
   */
  private def pruneSchema(schema: StructType, columns: Array[String]): StructType = {
    val fieldMap = Map(schema.fields.map(x => x.name -> x): _*)
    new StructType(columns.map(name => fieldMap(name)))
  }
}

private[httpV1Filter] class HTTPMoveDataRDD(@transient sc: SparkContext,
                                            schema: StructType,
                                            partitions: Array[Partition],
                                            serHadoopConf: SerializableConfiguration,
                                            httpOptions: HttpOptions)
  extends RDD[Row](sc, Nil) {

  //
  override def compute(split: Partition, context: TaskContext): Iterator[Row] = {
    val httpUrl = httpOptions.url + "/stream/downloadTempFile"
    val partition = split.asInstanceOf[HTTPMoveDataPartition]
    // local模式没有问题，但是非local模式会报读取不到，通封装在case class中，通过参数传进来可解决
    val writePath = ConstantPath.hdfsPath + "/remote_get" + partition.filePath.split("remote")(1)
    val hadoopConf = serHadoopConf.value
    println(s"Partition ${context.partitionId} ==> source file path ${partition.filePath}")
    println(s"Partition ${context.partitionId} ==> des file path ${writePath}")
    println(s"${schema.fields.mkString(",")}")
    try {
      val params = new JSONObject
      params.put("filePath", partition.filePath)
      val isTransmit = HttpHelper.doPostFormByte(httpUrl, params, writePath)
      if (isTransmit) {
        val filePath = new Path(writePath)
        ParquetReaderUtil.getParquetMessage(hadoopConf, filePath, schema)
      } else {
        null
      }
    } catch {
      case exception: Exception => throw exception
    } finally {
      // 清除文件
      val fs = FileSystem.get(hadoopConf)
      val path = new Path(writePath)
      if (fs.exists(path)) {
        fs.delete(path, true)
      }
      removeTempData(partition.filePath)
    }
  }

  private def removeTempData(path: String): Boolean = {
    val httpUrl = httpOptions.url + "/db/removeTempData"
    val params = new JSONObject
    params.put("filePath", path)
    val data = HttpHelper.doPostForm(httpUrl, params)
    if (!data.contains("\"status\" : 0")) {
      throw new Exception(data)
    }
    true
  }

  override protected def getPartitions: Array[Partition] = partitions
}
