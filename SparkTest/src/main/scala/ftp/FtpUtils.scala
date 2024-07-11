package ftp

import org.apache.commons.net.ftp.{FTP, FTPClient}
import org.slf4j.LoggerFactory

import java.io.{File, FileInputStream, FileOutputStream}
import java.time.Duration

object FtpUtils {

  private final val logger = LoggerFactory.getLogger(FtpUtils.getClass)

  private lazy val ftp: FTPClient = new FTPClient()

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

  def main(args: Array[String]): Unit = {
    // connect("dmc-offline.haizhi.com", 22, "bdp", "hzwj1122@#$")
    // fileMove("/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/files/excel2.xls", "/Users/tianyipeng/IdeaProjects/ScalaSTest/SparkTest/desFiles")
  }

}
