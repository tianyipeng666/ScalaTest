package source.http

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources.{BaseRelation, DataSourceRegister, RelationProvider}

class HttpRelationProvider extends DataSourceRegister with RelationProvider{
  override def shortName(): String = "http"

  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String]): BaseRelation = {
    val httpOptions = new HttpOptions(parameters)
    val (schema, count) = HttpRelation.getTableInfo(httpOptions)
    val num = HttpRelation.columnQueryNum(httpOptions)
    HttpRelation(sqlContext.sparkSession, httpOptions, schema, num)
  }
}
