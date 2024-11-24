package ftp

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import ftp.FtpUtils.ftp
import hdfs.HDFSUtil
import org.apache.commons.net.ftp.{FTP, FTPClient, FTPFile}
import org.slf4j.LoggerFactory

import java.io.{BufferedReader, File, FileInputStream, FileOutputStream, IOException, InputStream, InputStreamReader, OutputStream, PrintStream}
import java.time.Duration
import java.util

object FtpUtils {

  private final val logger = LoggerFactory.getLogger(FtpUtils.getClass)

  private lazy val ftp: FTPClient = new FTPClient()
  private lazy val ftpFilePath: String = "/typ/excelUpload/test.xlsx"
  private lazy val hdfsFilePath: String = "hdfs://hdcluster/bdp/ftp_tmp/ftp_download_excel/test.xlsx"
  private val checkFileName: String = "_fields.json"

  def connect(host:String, port:Int, userName:String, password:String): Unit = {
    ftp.setControlKeepAliveTimeout(Duration.ofSeconds(300))
    ftp.setConnectTimeout(10000)
    ftp.setControlEncoding("UTF-8")
    ftp.connect(host, port)
    if (ftp.login(userName, password)) {
      ftp.setFileType(FTP.BINARY_FILE_TYPE)
    } else {
      throw new Exception(s"ftp login failed, host: $host, port: $port, userName: $userName, password: $password")
    }
    logger.info(s"ftp login success!")
  }

  def getConnect(host: String, port: Int, userName: String, password: String): FTPClient = {
    val client = new FTPClient()
    client.setControlKeepAliveTimeout(Duration.ofSeconds(300))
    client.setConnectTimeout(10000)
    client.setControlEncoding("UTF-8")
    client.connect(host, port)
    if (client.login(userName, password)) {
      client.setFileType(FTP.BINARY_FILE_TYPE)
    } else {
      throw new Exception(s"ftp login failed, host: $host, port: $port, userName: $userName, password: $password")
    }
    println(s"ftp login success!")
    client
  }

  def checkRootPathFile(path: String, ftp: FTPClient): Boolean = {
    val rootPath = if (path.endsWith("/")) path.replaceAll("/$", "") else path
    val fileArr = listFiles(rootPath, ftp)
    if (fileArr.size == 1 && rootPath.equals(fileArr.head.getName)) {
      true
    } else {
      false
    }
  }

  def fileMove(remotePath:String, desPath:String): Unit = {
    // val inputStream = ftp.retrieveFileStream(remotePath)
    val file = new File(remotePath)
    val output = new FileOutputStream(desPath + "/" + file.getName)
    val input = new FileInputStream(remotePath)
    val buffer = new Array[Byte](2048)
    var bytesRead = 0
    while ({bytesRead = input.read(buffer); bytesRead != -1}) {
      output.write(buffer, 0, bytesRead)
    }
    System.out.println("File copied successfully.")
  }

  def copyToOutPutStream(path: String, out: OutputStream, buffSize: Int = 4096): Unit = {
    val in = getInputStream(path)
    try {
      copyBytes(in, out, buffSize)
    } finally {
      in.close()
      // 完成拉取关闭
      ftp.completePendingCommand()
    }
  }

  def listFiles(path: String, ftp: FTPClient): Array[FTPFile] = {
    var fixedPath = if (path.startsWith("/")) path else s"/$path"
    ftp.listFiles(fixedPath).map { file =>
      val fileName = file.getName
      if (path.endsWith(fileName) && file.isFile) {
        val newName = path
        file.setName(newName)
        file.setRawListing(file.getRawListing.replace(fileName, newName))
      } else if (!fileName.startsWith(fixedPath)) {
        fixedPath = if (fixedPath.endsWith("/")) fixedPath else s"$fixedPath/"
        val newName = s"$fixedPath$fileName"
        file.setName(newName)
        file.setRawListing(file.getRawListing.replace(fileName, newName))
      }
      file
    }
  }

  def  resolveFtpJson(path: String, ftp: FTPClient): util.HashMap[String, JsonNode] = {
    val checkMap = new util.HashMap[String, JsonNode]
    try {
      var fixedPath = if (path.startsWith("/")) path else s"/$path"
      val checkFile = ftp.listFiles(fixedPath).filter(_.getName.equals(checkFileName))
      if (checkFile.length == 0) {
        logger.warn(s"The path:$path doesn't have the check file, please add and then retry...")
        checkMap
      } else {
        // 读取
        val inputStream = ftp.retrieveFileStream(path + s"/$checkFileName")
        val reader = new BufferedReader(new InputStreamReader(inputStream))
        val fileContent = reader.lines().toArray.mkString("\n")
        reader.close()
        ftp.completePendingCommand()

        // 转换为json
        // 依赖jackson-module-scala与jackson-databind
        val objectMapper = new ObjectMapper()
        // 注册 Scala 模块支持
        objectMapper.registerModule(DefaultScalaModule)
        val jsonArray: JsonNode = objectMapper.readTree(fileContent)

        // JsonNode转为map
        if (jsonArray.isArray){
          // JsonNode遍历方式
          val iterator = jsonArray.elements()
          while (iterator.hasNext) {
            val node = iterator.next()
            checkMap.put(node.get("name").asText(), node)
          }
        } else {
          logger.warn(s"The transform result from $checkFileName is not the type of Array, please check file data")
        }
        checkMap
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
        checkMap
    } finally {
      // 断开连接
      if (ftp.isConnected) {
        ftp.logout()
        ftp.disconnect()
      }
    }
  }

  def readHead2Check(): Boolean = {
    false
  }

  private def getInputStream(path: String): InputStream = {
    // ftp拉取文件
    ftp.retrieveFileStream(path)
  }

  private def copyBytes(in: InputStream, out: OutputStream, buffSize: Int = 4096): Unit = {
    val ps = out match {
      case stream: PrintStream => stream
      case _ => null
    }
    val buf = new Array[Byte](buffSize)
    var bytesRead = in.read(buf)
    while ( {
      bytesRead >= 0
    }) {
      out.write(buf, 0, bytesRead)
      if ((ps != null) && ps.checkError) throw new IOException("Unable to write to output stream.")
      bytesRead = in.read(buf)
    }
  }

  def main(args: Array[String]): Unit = {
    connect("123.126.105.70", 21, "share", "haizhi1234")
    // outPutStream需关闭，否则数据无法刷写到磁盘，导致写入数据为0
    val out = HDFSUtil.openOutputStreamByUDF(hdfsFilePath, true)
    copyToOutPutStream(ftpFilePath, out, 4096)
    if (out != null) {
      out.close()
    }
  }

}
