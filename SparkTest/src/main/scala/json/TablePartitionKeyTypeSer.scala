package json

import bean.{TablePartitionKeyType, TablePartitionType}
import json.JsonService.formats
import org.json4s.{CustomSerializer, JArray, JField, JInt, JObject, JString, JValue}
import org.json4s.JsonDSL._

class TablePartitionKeyTypeSer extends CustomSerializer[TablePartitionKeyType](format => ( {
  case JObject(fields) => {
    val code = fields.find(_._1 == "code").map(_._2.extract[Int]).getOrElse(-1)
    val keyList = fields.find(_._1 == "keyList").map(_._2.extract[Seq[String]]).getOrElse(Seq())
    TablePartitionKeyType.getSub(code, keyList)
  }
}, {
  case obj: TablePartitionKeyType => JObject(JField("code", JInt(BigInt(obj.code))) :: JField("keyList", JArray(obj.partitionKeys.arr)) :: Nil)
}
))
