package hdfs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs
import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}

import java.io.OutputStream
import java.time.Instant
import java.time.temporal.ChronoUnit
import scala.collection.mutable.ArrayBuffer

object HDFSUtil {

  def main(args: Array[String]): Unit = {
    println(deleteInternalTempFile("/bdp/remote_haizhi/", 0))
  }

  def getFs(): FileSystem = {
    val config = new Configuration
    val fs = FileSystem.get(config)
    fs
  }

  def getFilesName(path: String): Seq[String] = {
    val config = new Configuration
    val fs = FileSystem.get(config)
    fs.listStatus(new Path(path)).map(fs => {
      fs.getPath.getName
    }).filter(!_.startsWith("_SUCCESS"))
  }

  def rename(src: String, des: String): Unit = {
    val config = new Configuration
    val fs = FileSystem.get(config)
    val hdfsPath = new Path(src)
    val desPath = new Path(des)
    val targetPath = new Path(des).getParent
    if (!fs.exists(targetPath)) {
      fs.mkdirs(targetPath)
    }
    if (fs.exists(desPath)) {
      fs.delete(desPath, true)
    }
    if (fs.exists(hdfsPath)) {
      fs.rename(hdfsPath, desPath)
    }
  }

  def openOutputStreamByUDF(filePath: String, overwrite: Boolean = true): OutputStream = {
    val config = new Configuration()
    val fs = FileSystem.get(config)
    val path = new Path(filePath)
    fs.create(path, overwrite)
  }

  def getFilePath(filePath: String): Seq[String] = {
    val config = new Configuration()
    val fs = FileSystem.get(config)
    val buffer = new ArrayBuffer[String]()
    val fixFilePath = if (filePath.endsWith("/")) filePath else filePath + "/"
    val tempFileIter = fs.listFiles(new Path(filePath), false)
    while(tempFileIter.hasNext){
      val fileStatus = tempFileIter.next()
      val fileName = fileStatus.getPath.getName
      if (!fileName.startsWith("_SUCCESS")) {
        buffer.append(fixFilePath + fileName)
      }
    }
    buffer.toSeq
  }

  def deleteInternalTempFile(filePath: String, timeInternal: Int): Int = {
    val config = new Configuration()
    val fs = FileSystem.get(config)
    val currentTime = Instant.now()
    var count = 0
    val fileStatuses: Array[FileStatus] = fs.listStatus(new Path(filePath))
    // 递归删除
    fileStatuses.foreach(status => {
      if (status.isFile) {
        val filePath = status.getPath
        val modificationTime = Instant.ofEpochMilli(status.getModificationTime)

        // 判断文件是否超过保留天数
        val daysOld = ChronoUnit.DAYS.between(modificationTime, currentTime)
        if (daysOld >= timeInternal) {
          fs.delete(filePath, false)
          count += 1
        }
      } else {
        count += deleteInternalTempFile(status.getPath.toString, timeInternal)
      }
    })
    count
  }

  def deleteHiveTableData(dataPath: String, keepDir: Boolean = false): Boolean = {
    var result = true
    val dataFilePath = new Path(dataPath)
    val config = new Configuration()
    val fs = FileSystem.get(config)
    try {
      if (fs.exists(dataFilePath)) {
        fs.delete(dataFilePath, true)
        if (keepDir) {
          fs.mkdirs(dataFilePath)
        }
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
        result = false
    }
    result
  }

  def getContentLength(paths: String*): Long = {
    val config = new Configuration()
    val fs = FileSystem.get(config)
    var length = 0L
    paths.foreach { path =>
      val filePath = new Path(path)
      if (fs.exists(filePath)) {
        val summary = fs.getContentSummary(filePath)
        length += summary.getLength
      }
    }
    length
  }
}
