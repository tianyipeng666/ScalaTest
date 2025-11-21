package udf

import java.io.{File, InputStream}
import java.util.Properties
import java.util.concurrent.{Executors, ScheduledExecutorService, TimeUnit}
import java.util.jar.JarFile
import java.net.URLClassLoader
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.api.java._
import org.apache.spark.sql.hive.HiveContext

import scala.collection.concurrent.TrieMap
import scala.util.{Failure, Success, Try}
import scala.collection.JavaConverters._

class DynamicUdfRegister(spark: HiveContext, udfBaseDir: String, scanIntervalSeconds: Long = 60L) {

  // jar 的 lastModified 缓存，避免重复注册
  private val jarTimestampCache = TrieMap.empty[String, Long]

  private val scheduler: ScheduledExecutorService =
    Executors.newSingleThreadScheduledExecutor()

  /** 启动定时扫描 */
  def start(): Unit = {
    val runnable = new Runnable {
      override def run(): Unit = {
        Try(scanOnce()) match {
          case Failure(e) =>
            System.err.println(s"[UdfHotLoader] scanOnce failed: ${e.getMessage}")
            e.printStackTrace()
          case Success(_) =>
        }
      }
    }

    scheduler.scheduleWithFixedDelay(
      runnable,
      10L,
      scanIntervalSeconds,
      TimeUnit.SECONDS
    )

    println(
      s"[UdfHotLoader] started, watching dir = $udfBaseDir, interval = $scanIntervalSeconds s"
    )
  }

  def stop(): Unit = scheduler.shutdown()

  /** 扫描一次目录 */
  private def scanOnce(): Unit = {
    val dir = new File(udfBaseDir)
    if (!dir.exists() || !dir.isDirectory) {
      System.err.println(
        s"[UdfHotLoader] udfBaseDir not exists or not a directory: $udfBaseDir"
      )
      return
    }

    val jars = dir.listFiles { f =>
      f.isFile && f.getName.toLowerCase.endsWith(".jar")
    }

    if (jars == null || jars.isEmpty) return

    jars.foreach { jarFile =>
      val path = jarFile.getAbsolutePath
      val lastModified = jarFile.lastModified()

      val needReload = jarTimestampCache.get(path) match {
        case None => true
        case Some(oldTime) => lastModified > oldTime
      }

      if (needReload) {
        println(s"[UdfHotLoader] found new or updated jar: $path")
        registerJar(jarFile) match {
          case Success(_) =>
            jarTimestampCache.put(path, lastModified)
            println(s"[UdfHotLoader] jar registered: $path")
          case Failure(e) =>
            System.err.println(s"[UdfHotLoader] failed to register jar $path: ${e.getMessage}")
            e.printStackTrace()
        }
      }
    }
  }

  /** 处理单个 jar：ADD JAR + 加载 udf.properties + 注册所有 UDF */
  private def registerJar(jarFile: File): Try[Unit] = Try {
    val absPath = jarFile.getAbsolutePath

    // 1) 下发 jar 到 executors
    spark.sql(s"ADD JAR '$absPath'")
    // spark.sparkContext.addJar(absPath) // 可选：双保险

    // 2) 打开 udf.properties
    val jar = new JarFile(jarFile)
    try {
      val entry = jar.getJarEntry("udf.properties")
      if (entry == null) {
        println(s"[UdfHotLoader] jar ${jarFile.getName} has no udf.properties, skip")
        return Success(())
      }

      val in: InputStream = jar.getInputStream(entry)
      val props = new Properties()
      props.load(in)
      in.close()

      val jarPath = jarFile.getAbsolutePath

      // 3) 解析每一个 UDF 配置
      for ((udfName, rawValue) <- props.asScala) {
        val cfgTry = parseUdfConfig(udfName, rawValue, jarPath)
        cfgTry match {
          case Success(cfg) =>
            registerSingleUdf(cfg)
          case Failure(e) =>
            System.err.println(s"[UdfHotLoader] invalid udf config for key=$udfName: ${e.getMessage}")
        }
      }
    } finally {
      jar.close()
    }
  }

  /** 解析一行配置： name = implType, className, [returnType] */
  private def parseUdfConfig(name: String, raw: String, jarPath: String): Try[UdfConfig] = Try {
    val parts = raw.split(",").map(_.trim).filter(_.nonEmpty)
    if (parts.length < 2) {
      throw new IllegalArgumentException(
        s"invalid udf config '$raw', expected: implType, className[, returnType]"
      )
    }
    val implType = parts(0).toLowerCase
    val className = parts(1)
    val returnType = if (parts.length >= 3) Some(parts(2).toLowerCase) else None

    implType match {
      case "spark" =>
        if (returnType.isEmpty) {
          throw new IllegalArgumentException(
            s"spark udf '$name' must specify returnType"
          )
        }
      case "hive" =>
      // hive 类型可以不写返回类型
      case other =>
        throw new IllegalArgumentException(s"unknown implType: $other")
    }

    UdfConfig(name.trim, implType, className.trim, returnType, jarPath)
  }

  /** 注册一个 UDF：根据 implType 分发 */
  private def registerSingleUdf(cfg: UdfConfig): Unit = {
    cfg.implType match {
      case "hive" => registerHiveUdf(cfg)
      case "spark" => registerSparkUdf(cfg)
      case other => throw new IllegalArgumentException(s"Unsupported implType: $other")
    }
  }

  /** Hive UDF / GenericUDF / UDAF 走 CREATE TEMPORARY FUNCTION */
  private def registerHiveUdf(cfg: UdfConfig): Unit = {
    val sql = s"CREATE TEMPORARY FUNCTION ${cfg.name} AS '${cfg.className}'"
    println(s"[UdfHotLoader] (hive) registering UDF: ${cfg.name} -> ${cfg.className}")
    spark.sql(sql)
  }

  /** Spark Java UDF（UDF1~UDF22）走 spark.udf.register */
  private def registerSparkUdf(cfg: UdfConfig): Unit = {
    val parent = Thread.currentThread().getContextClassLoader
    val loader = new URLClassLoader(Array(new java.io.File(cfg.jarPath).toURI.toURL), parent)
    val clazz = Class.forName(cfg.className, true, loader)
    val instance = clazz.getDeclaredConstructor().newInstance().asInstanceOf[AnyRef]
    val dt = parseDataType(cfg.returnType.get)

    println(s"[UdfHotLoader] (spark) registering UDF: ${cfg.name} -> ${cfg.className}, returnType=${cfg.returnType.get}")

    instance match {
      case f: UDF1[_, _] =>
        spark.udf.register(cfg.name, f, dt)
      case f: UDF2[_, _, _] =>
        spark.udf.register(cfg.name, f, dt)
      case f: UDF3[_, _, _, _] =>
        spark.udf.register(cfg.name, f, dt)
      case f: UDF4[_, _, _, _, _] =>
        spark.udf.register(cfg.name, f, dt)
      case f: UDF5[_, _, _, _, _, _] =>
        spark.udf.register(cfg.name, f, dt)
      // 如有需要，可以继续加到 UDF22
      case other =>
        throw new IllegalArgumentException(
          s"class ${cfg.className} is not instance of supported UDF1~UDF5, actual=${other.getClass.getName}"
        )
    }
  }

  /** 简单的 returnType 字符串 -> DataType 映射 */
  private def parseDataType(name: String): DataType = name.toLowerCase match {
    case "string" => StringType
    case "int" => IntegerType
    case "integer" => IntegerType
    case "long" => LongType
    case "double" => DoubleType
    case "boolean" => BooleanType
    case "float" => FloatType
    case other =>
      throw new IllegalArgumentException(s"Unsupported returnType: $other")
  }

}
