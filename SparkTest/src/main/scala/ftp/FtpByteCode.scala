package ftp

import org.apache.commons.net.ftp.{FTP, FTPClient, FTPFile}

import java.io.ByteArrayInputStream
import java.nio.charset.{Charset, StandardCharsets}

object FtpByteCode {

  def main(args: Array[String]): Unit = {

    val iso8859Str = new String("text".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1)
    println(s"iso8859Str = ${iso8859Str}")
    val transformStr = new String(iso8859Str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8)
    println(s"transformStr = ${transformStr}")
    val suffix = ".tmp"
    val tmp = s"$iso8859Str$suffix"
    println(s"tmp = ${tmp}")

    val ftp = new FTPClient()
    ftp.connect("123.126.105.70", 21)
    ftp.login("share", "haizhi1234")
    // ftp.setControlEncoding("UTF-8")
    ftp.enterLocalPassiveMode()
    ftp.setFileType(FTP.BINARY_FILE_TYPE)


    val dir = "/typ"
    println(s"CWD $dir = " + ftp.changeWorkingDirectory(dir) + ", " + ftp.getReplyString)
    println("PWD(after) = " + ftp.printWorkingDirectory())

    // 上传 ASCII 名称
    val name = s"${tmp}"
    val ok = ftp.storeFile(s"$dir/$name",
      new ByteArrayInputStream("String".getBytes(StandardCharsets.UTF_8)))
    println(s"store ok = $ok, reply=" + ftp.getReplyString)

    // 直接 MLST/SIZE 验证
    val file = ftp.mlistFile(s"$dir/$name")
    println("mlst = " + file)
    println("size via MLST = " + (if (file != null) file.getSize else -1))

    // 尝试列目录，看是否有列权限
    val files = ftp.listFiles(dir)
    println("listFiles count = " + files.length)
    files.foreach(f => println(" -> " + f.getName))

    ftp.rename(s"$dir/$name", s"$dir/typByteCode2.txt")
  }


  def checkFtpByteCode(host: String, user: String, pass: String): String = {
    val ftp = new FTPClient()
    try {
      ftp.connect(host, 21)
      ftp.login(user, pass)
      ftp.enterLocalPassiveMode()
      ftp.setFileType(FTP.BINARY_FILE_TYPE)

      // 优先尝试开启 UTF-8
      ftp.sendCommand("OPTS", "UTF8 ON")
      val rc = ftp.getReplyCode
      println(s"${rc}")

      val detected: String =
        if (rc == 200 || rc == 202) {
          ftp.setControlEncoding("UTF-8")
          "UTF-8"
        } else {
          // 逐个试探常见非 UTF-8 编码
          val encodings = List("ISO-8859-1", "windows-1252", "GBK")
          val utf8Name = "probe-ñ-€.txt"

          var found: Option[String] = None
          for (enc <- encodings if found.isEmpty) {
            ftp.setControlEncoding(enc)
            val remoteName =
              new String(utf8Name.getBytes(StandardCharsets.UTF_8), Charset.forName(enc))
            val ok = ftp.storeFile(remoteName, new ByteArrayInputStream(Array.emptyByteArray))
            if (ok) {
              // 清理探针文件
              ftp.deleteFile(remoteName)
              found = Some(enc)
            }
          }
          found.getOrElse("UNKNOWN")
        }

      println(s"[encoding detected] $detected")
      // 之后你的正式上传，使用 detected 作为 controlEncoding 即可：
      // ftp.setControlEncoding(detected)
      detected
    } finally {
      try ftp.logout() catch {
        case _: Throwable =>
      }
      try ftp.disconnect() catch {
        case _: Throwable =>
      }
    }
  }
}

