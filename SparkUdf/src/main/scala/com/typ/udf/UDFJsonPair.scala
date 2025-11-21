package com.typ.udf

import org.apache.hadoop.hive.ql.exec.Description
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector
import org.apache.hadoop.io.Text


@Description(name = "json_pair", value = "_FUNC_(k, v) - return '{\"k\":\"v\"}' string")
class UDFJsonPair extends GenericUDF {
  private var keyOI: StringObjectInspector = null
  private var valOI: StringObjectInspector = null
  final private val result = new Text

  override def initialize(arguments: Array[ObjectInspector]): ObjectInspector = {
    keyOI = arguments(0).asInstanceOf[StringObjectInspector]
    valOI = arguments(1).asInstanceOf[StringObjectInspector]
    PrimitiveObjectInspectorFactory.writableStringObjectInspector
  }

  @throws[org.apache.hadoop.hive.ql.metadata.HiveException]
  override def evaluate(arguments: Array[GenericUDF.DeferredObject]): AnyRef = {
    val k = keyOI.getPrimitiveJavaObject(arguments(0).get)
    val v = valOI.getPrimitiveJavaObject(arguments(1).get)
    if (k == null || v == null) result.set("null")
    else result.set("{\"" + k + "\":\"" + v + "\"}")
    result
  }

  override def getDisplayString(children: Array[String]): String = "json_pair(" + children(0) + "," + children(1) + ")"
}
