package hdfs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

import scala.collection.mutable.ArrayBuffer

object HDFSUtil {

  def main(args: Array[String]): Unit = {
    val buffer = new ArrayBuffer[String]()
    val resBuffer = new ArrayBuffer[String]()
    buffer.append("/20240713")
    buffer.append("/20240714")
    buffer.append("/20240715")
    buffer.foreach(parentPath => {
      resBuffer.appendAll(getFilesName("hdfs://hdcluster/excel/testExcel2/" + parentPath)
        .filter(!_.startsWith("_"))
        .map(parentPath + "/" + _))
    })
    resBuffer.foreach(elem => {
      rename("hdfs://hdcluster/excel/testExcel2/" + elem, "hdfs://hdcluster/excel/externalExcel/" + elem)
    })
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

}
