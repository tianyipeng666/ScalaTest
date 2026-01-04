package sql

import antlr.sql.{SqlScriptLexer, SqlScriptParser}
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import sql.parser.{ANTLRNoCaseStringStream, OriginSqlScriptProcessor}

import json.source.JSONObject

object SqlParserService {

  def parseSql(sql: String): (String, String, String, String, String, String, String, String) = {
    val (tree, processor) = SqlUtils.parseSQL(sql)

    val map = processor.relyBaseTables.map { case (key, value) =>
      (key, value.toString)
    }.toMap
    val relyBaseTables = JSONObject(map)
    val tempTables = processor.tempTables
    val moreFieldsTable = processor.moreFieldsTable
    val variables = processor.jsonVariables
    val parsedSql = tree.getText

    val lexer2 = new SqlScriptLexer(new ANTLRNoCaseStringStream(sql))
    val tokenStream2 = new CommonTokenStream(lexer2)
    val parser2 = new SqlScriptParser(tokenStream2)

    val tree2 = parser2.sqlScript()
    val walker2 = new ParseTreeWalker()
    val processor2 = new OriginSqlScriptProcessor(parser2)
    walker2.walk(processor2, tree2)

    val replaceFields = JSONObject(processor2.replaceFields.toMap)
    val replaceTables = JSONObject(processor2.replaceTables.toMap)
    val fieldVariables = processor2.fieldContainVariables

    (parsedSql, relyBaseTables.toString(), replaceFields.toString(), tempTables.toString, replaceTables.toString(),
      variables.toString, fieldVariables.toString, moreFieldsTable.toString())
  }
}
