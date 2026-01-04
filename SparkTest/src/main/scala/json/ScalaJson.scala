package json

import json.source.{JSONObject, JSONArray}

object ScalaJson {
  def main(args: Array[String]): Unit = {
    val obj = JSONObject(Map(
      "a" -> 1,
      "b" -> "hello",
      "c" -> true
    ))

    val arr = JSONArray(List(
      1,
      "x",
      false,
      3.14
    ))

    println("JSONObject: " + obj.toString())
    println("JSONArray : " + arr.toString())

    // 简单包含性检查（不依赖顺序）
    val s = obj.toString()
    assert(s.contains("\"a\"") && s.contains("1"))
    assert(s.contains("\"b\"") && s.contains("\"hello\""))
    assert(s.contains("\"c\"") && s.contains("true"))

    val a = arr.toString()
    assert(a.startsWith("[") && a.endsWith("]"))
    assert(a.contains("1") && a.contains("\"x\"") && a.contains("false"))
  }
}
