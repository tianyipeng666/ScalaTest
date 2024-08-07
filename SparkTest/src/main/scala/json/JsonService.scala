package json

import bean.{AsyncQueueMessage, EnumBean, EnumJava, IncrementalPartitionType, Person, SerTestBean, TablePartitionInfo, TablePartitionKeyType, TablePartitionType, YearPartitionKeyType}
import org.json4s.ext.{EnumNameSerializer, JavaEnumNameSerializer}
import com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_INTEGER_FOR_INTS
import com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS
import com.fasterxml.jackson.databind.ObjectMapper
import org.json4s.{DefaultFormats, FileInput, Formats, JValue, JsonInput, ReaderInput, StreamInput, StringInput}
import org.json4s.jackson.Json4sScalaModule
import org.json4s.jackson.Serialization._
import org.json4s.JsonDSL._
import org.json4s._
import json.TablePartitionTypeSer

import scala.collection.mutable.ArrayBuffer

object JsonService {

  // 导入format隐式转换，对时间格式化 + 枚举类序列化 + Java枚举序列化 + 自定义序列化（case object）
  implicit val formats: Formats = DefaultFormats +
    new EnumNameSerializer(EnumBean) +
    new JavaEnumNameSerializer[EnumJava]() +
    new TablePartitionTypeSer +
    new TablePartitionKeyTypeSer


  private[this] lazy val _defaultMapper = {
    val m = new ObjectMapper()
    m.registerModule(new Json4sScalaModule)
    m.configure(USE_BIG_INTEGER_FOR_INTS, true)
    m
  }

  def mapper = _defaultMapper

  def getSerObject(): SerTestBean = {
    val seq = new ArrayBuffer[String]()
    seq.append("list1", "list2", "list3")
    val person = Person("typ2", "30")
    val bean = SerTestBean("typ2", seq, person, true, Some("option"), 1000, EnumBean.ORC, Option(null).getOrElse(EnumJava.EMPTY))

    println("before transform==>" + bean.enumType)
    println("before transform==>" + bean.enmJavaType)
    println("before transform==>" + bean.optionType)
    println("before transform==>" + bean.pojoType)

    bean
  }

  def getSerCaseObject(): TablePartitionInfo = {
    val list = List("20240806", "20240807")
    TablePartitionInfo(partitionType = IncrementalPartitionType, partitionKeyType=YearPartitionKeyType(list), needClean = true)
  }

  def getSerFromObject(obj: SerTestBean): String = {
    write (
        ("traceId" -> "test3") ~
        ("data" -> write(obj))
    )
  }

  def getSerTableFromObject(obj: TablePartitionInfo): String = {
    write(
      ("traceId" -> "test3") ~
        ("data" -> write(obj))
    )
  }


  def getDeSerToObject(str: String): AsyncQueueMessage = {
    // 转换的对象，对象属性未赋默认值的需同str相匹配
    parse(str).extract[AsyncQueueMessage]
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
