package hdfs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs
import org.apache.hadoop.fs.{FileSystem, Path}

import java.io.OutputStream
import scala.collection.mutable.ArrayBuffer

object HDFSUtil {

  def main(args: Array[String]): Unit = {
    val config = new Configuration
    val fs = FileSystem.get(config)
    val path = new Path("/bdp/remote_haizhi/z98eb6b13d7540979a10b8ca8d07b340/1735553969484/part-00001-67d228ce-c582-4aad-a62b-5c0429419fa9-c000.gz.parquet")
    // hdfs://hdcluster/bdp/remote_haizhi/z98eb6b13d7540979a10b8ca8d07b340/1735553969484
    println(fs.getFileStatus(path).getPath.getParent.toString)
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
    val targetPath = new Path(des).getParent
    if (!fs.exists(targetPath)) {
      fs.mkdirs(targetPath)
    }
    if (fs.exists(hdfsPath)) {
      fs.rename(hdfsPath, new Path(des))
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
}
