package path

import java.io.File

object PathUtil {

  def main(args: Array[String]): Unit = {
    // hdfs:/hdfsCluster/temp/tbName
    val path = "/test.xlsx/aaa/bbbb/"
    val rootPath = if (path.endsWith("/")) path.replaceAll("/$", "") else path
    println(rootPath)
  }

  def getParent(absolutePath: String): String = {
    new File(absolutePath).getParent
  }

}
