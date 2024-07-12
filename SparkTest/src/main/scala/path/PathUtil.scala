package path

import java.io.File

object PathUtil {

  def main(args: Array[String]): Unit = {
    // hdfs:/hdfsCluster/temp/tbName
    println(getParent("hdfs://hdfsCluster/temp/tbName/test.xlsx"))
  }

  def getParent(absolutePath: String): String = {
    new File(absolutePath).getParent
  }

}
