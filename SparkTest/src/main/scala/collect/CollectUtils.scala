package collect

import java.util
object CollectUtils {

  def main(args: Array[String]): Unit = {
    val checkMap = new util.LinkedHashMap[String, String]
    checkMap.put("1", "")
    checkMap.put("2 ", "")
    checkMap.put("3", "")
    checkMap.put("4 ", "")
    checkMap.put("5", "")
    val str = "1,2,3,4,5"
    val arr = str.split(",")
    println(checkIsSameOrder(checkMap, arr))
  }

  def checkIsSameOrder(map: util.Map[String, String], arr: Array[String]): Boolean = {
    map.keySet().toArray.sameElements(arr)
  }

}
