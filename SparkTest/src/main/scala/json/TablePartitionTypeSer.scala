package json

import bean.{NotPartitionType, TablePartitionType}
import org.json4s.{CustomSerializer, JField, JInt, JObject, JString}

class TablePartitionTypeSer extends CustomSerializer[TablePartitionType](format => ( {
  case JObject(JField("code", JInt(c)) :: JField("name", JString(n)) :: Nil) => TablePartitionType(c.toInt)
}, {
  case obj: TablePartitionType => JObject(JField("code", JInt(BigInt(obj.code))) :: JField("name", JString(obj.name)) :: Nil)
}
))
