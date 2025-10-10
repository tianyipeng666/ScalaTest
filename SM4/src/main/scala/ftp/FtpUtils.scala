package ftp

import org.apache.commons.net.ftp.{FTP, FTPClient, FTPFile}
import org.slf4j.LoggerFactory

import java.io.{BufferedReader, File, FileInputStream, FileOutputStream, IOException, InputStream, InputStreamReader, OutputStream, PrintStream}
import java.time.Duration
import java.util
import scala.collection.mutable.ArrayBuffer

object FtpUtils {

  private lazy val ftp: FTPClient = new FTPClient()
  private lazy val ftpFilePath: String = "/typ/excelUpload/test.xlsx"
  private lazy val hdfsFilePath: String = "hdfs://hdcluster/bdp/ftp_tmp/ftp_download_excel/test.xlsx"
  private val checkFileName: String = "_fields2.json"

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

  def copyToOutPutStream(path: String, ftp: FTPClient, out: OutputStream, buffSize: Int = 4096): Unit = {
    val in = getInputStream(path, ftp)
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

  def readHead2Check(): Boolean = {
    false
  }

  private def getInputStream(path: String, ftp: FTPClient): InputStream = {
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

  def previewFile(path: String, ftp: FTPClient, lineNumber: Int = 11): Seq[String] = {
    val inputStream = getInputStream(path, ftp)
    val lines = new ArrayBuffer[String]()
    try {
      val br = new BufferedReader(new InputStreamReader(inputStream))
      var line = br.readLine()
      var no = 1
      // 实验性：多读一些，读的行数比较少的时候，再某些环境下有可能报错
      val readLineNumber = if (lineNumber >= 100) lineNumber else 100
      while (line != null && no <= lineNumber + readLineNumber) {
        lines.append(line)
        no += 1
        line = br.readLine()
      }
      br.close()
    } catch {
      case e: Throwable => throw e
    } finally {
      inputStream.close()
      Thread.sleep(50L)
      ftp.completePendingCommand()
    }
    lines.take(lineNumber)
  }

}
