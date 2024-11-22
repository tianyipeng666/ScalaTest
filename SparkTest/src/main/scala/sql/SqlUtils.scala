package sql

import log.LazyLogging
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import sql.SqlScriptParser.SqlScriptContext
import sql.parser.{ANTLRNoCaseStringStream, SqlScriptProcessor}

import scala.collection.mutable

/**
 * Created by wangyang on 15/9/15.
 */
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
