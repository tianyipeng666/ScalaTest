package udf

/**
 * UDF 配置对象
 *
 * @param name        udf 名称（SQL 中使用的名字）
 * @param implType    实现类型：spark / hive
 * @param className   实现类全限定名
 * @param returnType  Spark UDF 的返回类型（hive 时可 None）
 * @param jarPath  jar路径
 */

case class UdfConfig(name: String,
                     implType: String,
                     className: String,
                     returnType: Option[String],
                     jarPath: String)
