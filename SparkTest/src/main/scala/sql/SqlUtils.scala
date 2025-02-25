package sql

import antlr.sql.{SqlScriptLexer, SqlScriptParser}
import log.LazyLogging
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import antlr.sql.SqlScriptParser.SqlScriptContext
import sql.parser.{ANTLRNoCaseStringStream, SqlScriptProcessor}

import scala.collection.mutable

object SqlUtils extends LazyLogging {

  def parseSQL(sql: String): (SqlScriptContext, SqlScriptProcessor) = {
    val lexer = new SqlScriptLexer(new ANTLRNoCaseStringStream(sql))
    val tokenStream = new CommonTokenStream(lexer)
    val parser = new SqlScriptParser(tokenStream)

    val tree = parser.sqlScript()
    val walker = new ParseTreeWalker()
    val processor = new SqlScriptProcessor(parser)
    walker.walk(processor, tree)
    (tree, processor)
  }
}
