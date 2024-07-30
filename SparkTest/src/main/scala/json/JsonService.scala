package json

import bean.{EnumBean, SerTestBean}
import org.json4s.ext.EnumNameSerializer
import com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_INTEGER_FOR_INTS
import com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS
import com.fasterxml.jackson.databind.ObjectMapper
import org.json4s.{DefaultFormats, FileInput, Formats, JValue, JsonInput, ReaderInput, StreamInput, StringInput}
import org.json4s.jackson.{Json4sScalaModule, Serialization}

object JsonService {

  // 导入format隐式转换，对时间格式化 + 枚举类序列化
  implicit val formats: Formats = DefaultFormats + new EnumNameSerializer(EnumBean)


  private[this] lazy val _defaultMapper = {
    val m = new ObjectMapper()
    m.registerModule(new Json4sScalaModule)
    // for backwards compatibility
    m.configure(USE_BIG_INTEGER_FOR_INTS, true)
    m
  }

  def mapper = _defaultMapper

  def getSerFromObject(obj: SerTestBean): String = {
    Serialization.write(obj)
  }

  def getDeSerToObject(str: String): SerTestBean = {
    parse(str).extract[SerTestBean]
  }

  def parse(in: JsonInput, useBigDecimalForDouble: Boolean = false, useBigIntForLong: Boolean = true): JValue = {
    var reader = mapper.readerFor(classOf[JValue])
    if (useBigDecimalForDouble) reader = reader `with` USE_BIG_DECIMAL_FOR_FLOATS
    if (useBigIntForLong) reader = reader `with` USE_BIG_INTEGER_FOR_INTS

    in match {
      case StringInput(s) => reader.readValue(s)
      case ReaderInput(rdr) => reader.readValue(rdr)
      case StreamInput(stream) => reader.readValue(stream)
      case FileInput(file) => reader.readValue(file)
    }
  }

}
