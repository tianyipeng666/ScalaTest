package streaming

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.{Properties, Timer, TimerTask}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import _root_.log.LazyLogging
import bean.{OffsetInfo, StreamingMonitorInfo}
import json.JsonService
import org.apache.hadoop.fs.Path
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.{PartitionInfo, TopicPartition}
import org.apache.spark.sql.execution.streaming.OffsetSeqLog
import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.streaming.kafka010.OffsetRange
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse
import org.json4s.jackson.Serialization._

import java.util.concurrent.{ConcurrentHashMap, Executors, TimeUnit}
import java.time.ZoneId
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import scala.util.Random
import scala.collection.JavaConverters._
import scala.collection.mutable

object StreamingUtils extends LazyLogging{

  implicit val format = DefaultFormats

  private val streamingScheduleExecutor = Executors.newFixedThreadPool(1)
  private val produceDataScheduleExecutor = Executors.newFixedThreadPool(1)
  private val monitorInfoScheduleExecutor = Executors.newScheduledThreadPool(1)
  private val queryModel = new ConcurrentHashMap[String, StreamingQuery]
  private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
  private val isKafkaEnabledKerberos = false

  private val producerParam = Map(
    ProducerConfig.ACKS_CONFIG -> "all",
    ProducerConfig.RETRIES_CONFIG -> "0",
    ProducerConfig.BATCH_SIZE_CONFIG -> "16384",
    ProducerConfig.LINGER_MS_CONFIG -> "1",
    ProducerConfig.BUFFER_MEMORY_CONFIG -> "33554432",
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer"
  )

  private val consumerParam = Map(
    ConsumerConfig.GROUP_ID_CONFIG -> s"fetch-offset-${Random.nextInt()}-${System.currentTimeMillis()}",
    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
    ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG -> "true",
    ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG -> "1000",
    ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG -> "30000"
  )

  private val kafkaParams = producerParam ++ consumerParam

  def produceData(kafkaServer: String, topic: String): Unit = {
    logger.warn("Start produce data")
    produceDataScheduleExecutor.submit(new Runnable{
      override def run(): Unit = {
        val props = new Properties()
        props.put("bootstrap.servers", s"$kafkaServer")
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

        val producer = new KafkaProducer[String, String](props)
        val timer = new Timer()

        // 每隔1秒发送1000条随机JSON消息
        timer.scheduleAtFixedRate(new TimerTask {
          override def run(): Unit = {
            for (_ <- 1 to 1000) {
              val recordKey = Random.nextInt(10).toString
              val recordValue = s"""{"userId":${Random.nextInt(1000)},"action":"click","ts":${System.currentTimeMillis()}}"""
              producer.send(new ProducerRecord(topic, recordKey, recordValue))
            }
          }
        }, 0, 1000)

        // JVM退出时关闭producer
        sys.addShutdownHook {
          timer.cancel()
          producer.close()
        }
      }
    })
  }

  def kafkaStreamProcess(sparkSession: SparkSession,
                         produceKafka: String,
                         productTopic: String,
                         insertKafka: String,
                         insertTopic: String
                        ): Unit = {
    logger.warn("Start stream data dispose")
    streamingScheduleExecutor.submit(new Runnable {

      override def run(): Unit = {
        import sparkSession.implicits._

        val inputDF = sparkSession.readStream
          .format("kafka")
          .option("groupIdPrefix", "monitorTest")
          .option("kafka.bootstrap.servers", s"$produceKafka")
          .option("subscribe", s"$productTopic")
          .option("maxOffsetsPerTrigger", 20000)
          .option("startingOffsets", "earliest")
          .load()

        // value是二进制，要先转为String，再用get_json_object提取字段
        val selected = inputDF
          .selectExpr("CAST(value AS STRING) as json_str")
          .select(
            get_json_object($"json_str", "$.userId").cast("int").alias("userId"),
            get_json_object($"json_str", "$.action").alias("action"),
            get_json_object($"json_str", "$.ts").cast("long").alias("eventTime")
          )

        // 将选出的字段封装回JSON，用作写入Kafka的value
        val outputDF = selected
          .select(to_json(struct($"userId", $"action", $"eventTime")).alias("value"))

        // 首次通过配置读取，后续通过写入checkpoint决定从哪个部分读取并写入
        val query = outputDF.writeStream
          .format("kafka")
          .option("kafka.bootstrap.servers", s"$insertKafka")
          .option("topic", s"$insertTopic")
          .option("checkpointLocation", s"/tmp/$insertTopic")
          .trigger(Trigger.ProcessingTime(10, TimeUnit.SECONDS))
          .queryName("monitorTest")
          .outputMode("append")
          .start()

        queryModel.put("monitorTest", query)
        // query.awaitTermination()
      }
    })
  }

  def getMonitorInfo(): Unit = {
    println("Start monitor info")
    monitorInfoScheduleExecutor.scheduleAtFixedRate(new Runnable {
      override def run(): Unit = {
        try {
          if (queryModel.size > 0) {
            val streamQuery = queryModel.get("monitorTest")
            if (streamQuery.lastProgress == null) {
              logger.warn("lastProgress is null, please wait...")
            }
            val recentProcess = streamQuery.recentProgress
            if (recentProcess.length > 0) {
              val latestSlice = recentProcess
                .takeRight(math.min(recentProcess.length, 20))
                .reverse
              val streamingMonitorInfo: Array[StreamingMonitorInfo] = latestSlice.map { batch =>
                // 平均落后offset(spark2.4.6没有)
                // val avgBehind = batch.sources.head.metrics.getOrDefault("avgOffsetsBehindLatest", "0")
                // 带有时区时间戳转换
                val odt = OffsetDateTime.parse(batch.timestamp)
                val local = odt.atZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime
                val formattedTs = local.format(formatter)

                StreamingMonitorInfo(
                  batch.batchId.toInt,
                  formattedTs,
                  batch.numInputRows.toInt,
                  batch.durationMs.getOrDefault("triggerExecution", 0L)
                    .toInt,
                  10,
                  //avgBehind.toDouble.toLong,
                  batch.inputRowsPerSecond.toInt,
                  batch.processedRowsPerSecond.toInt
                )
              }
              println(streamingMonitorInfo.toSeq.mkString(","))
            }
          }
        } catch {
          case e: Throwable =>
            e.printStackTrace()
        }
      }
    }, 5, 10, TimeUnit.SECONDS)
  }

  def getOffsetInfo(sparkSession: SparkSession, kafkaServer: String, topicSeq: Seq[String], checkpointLocation: String): Seq[OffsetInfo] = {
    val offsetMap = mutable.Map[String, OffsetInfo]()
    // 获取最新的offset
    topicSeq.foreach(topic => {
      val offsetRanges = getOffset(topic, kafkaServer)
      if (offsetRanges.isEmpty) {
        offsetMap.put(topic, OffsetInfo(topic, -1, -1))
      } else {
        val lastOffset = offsetRanges.maxBy(_.untilOffset).untilOffset
        offsetMap.put(topic, OffsetInfo(topic, lastOffset, -1))
      }
    })

    // 获取已消费的offset
    // parse方法需要导入import org.json4s.jackson.JsonMethods.parse，并添加implicit val format = DefaultFormats
    val offsetSeqLog = new OffsetSeqLog(sparkSession, new Path(new Path(checkpointLocation), "offsets").toString)
    offsetSeqLog.getLatest() match {
      case Some((_, nextOffsets)) =>
        nextOffsets.offsets.foreach {
          case Some(offsetString) =>
            val info = parse(offsetString.json()).extract[(String, Map[String, Long])]
            val topic = info._1
            val maxOffset = info._2.values.max
            val offsetInfo = offsetMap(topic)
            offsetInfo.currentOffset = maxOffset
          case None =>
            logger.warn(s"current streaming maybe do not process data ")
        }
      case None =>
        logger.warn(s"current streaming maybe do not process data ")
    }
    offsetMap.values.toSeq
  }

  private def getConsumer(servers: String, parameters: Option[Map[String, String]] = None): KafkaConsumer[String, String] = {
    var options = Map(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> servers) ++ parameters.getOrElse(Map.empty)
    if (isKafkaEnabledKerberos) {
      logger.debug("kafka cluster enable kerberos")
      options = options ++ Map(
        "security.protocol" -> "SASL_PLAINTEXT",
        "sasl.mechanism" -> "GSSAPI",
        "sasl.kerberos.service.name" -> "kafka",
        "sasl.kerberos.kinit.cmd" -> "kinit",
        "kerberos.domain.name" -> ""
      )
    }
    val props = new Properties()
    (kafkaParams ++ options).foreach { case (k, v) => props.setProperty(k, v) }
    logger.debug(s"Kafka Consumer config is ${props}")
    new KafkaConsumer[String, String](props)
  }

  private def getOffset(topic: String, servers: String, parameters: Option[Map[String, String]] = None): Array[OffsetRange] = {
    val consumer = getConsumer(servers, parameters)
    try {
      val partitionInfos = listPartitionInfos(topic, consumer)
      if (partitionInfos.isEmpty) {
        return Array.empty[OffsetRange]
      }
      val topicPartitions = partitionInfos.get.sortBy(_.partition()).flatMap { p =>
        // no leader
        if (p.leader() == null) {
          None
        } else {
          Some(new TopicPartition(p.topic, p.partition))
        }
      }
      val endOffsets = consumer.endOffsets(topicPartitions.asJava).asScala.toMap
      val startOffsets = consumer.beginningOffsets(topicPartitions.asJava).asScala.toArray
      startOffsets.map { p =>
        val endOffset = endOffsets(p._1)
        OffsetRange(p._1, p._2, endOffset)
      }
    } finally {
      consumer.close()
    }
  }

  private def listPartitionInfos(topic: String, consumer: KafkaConsumer[String, String]): Option[Seq[PartitionInfo]] = {
    val partitionInfos = consumer.listTopics.asScala.filterKeys(_ == topic).values.flatMap(_.asScala).toBuffer
    if (partitionInfos.isEmpty) {
      None
    } else {
      Some(partitionInfos)
    }
  }

}
