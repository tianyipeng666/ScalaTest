package sql.parser

import antlr.sql.{SqlScriptBaseListener, SqlScriptParser}

import java.util
import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.parsing.json._
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeWalker, TerminalNode}
import org.json4s._
import org.json4s.jackson.JsonMethods._
import sql.SqlUtils
import antlr.sql.SqlScriptParser._


class SqlScriptProcessor(parser: SqlScriptParser) extends SqlScriptBaseListener {
  private val tokens = parser.getTokenStream.asInstanceOf[BufferedTokenStream]
  // todo 窗口函数中可能包含的关键字, 不全
  private val keyword = Set("by", "order", "group")
  private val alaisWord = Set("SELECT", "FROM", "ADD", "AS", "ALL", "DISTINCT", "WHERE", "GROUP", "BY", "GROUPING",
    "SETS", "CUBE", "ORDER", "HAVING", "LIMIT", "AT", "OR", "AND", "IN", "NOT", "NO", "EXISTS", "BETWEEN", "LIKE",
    "IS", "NULL", "TRUE", "FALSE", "NULLS", "ASC", "DESC", "FOR", "INTERVAL", "CASE", "WHEN", "THEN", "ELSE", "END",
    "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "SEMI", "RIGHT", "FULL", "NATURAL", "ON", "LATERAL", "WINDOW", "OVER",
    "PARTITION", "RANGE", "ROWS", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "FIRST", "AFTER", "LAST", "ROW",
    "WITH", "VALUES", "CREATE", "TABLE", "VIEW", "REPLACE", "INSERT", "DELETE", "INTO", "DESCRIBE", "EXPLAIN",
    "FORMAT", "LOGICAL", "CODEGEN", "COST", "CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", "PARTITIONS",
    "FUNCTIONS", "DROP", "UNION", "EXCEPT", "SETMINUS", "INTERSECT", "TO", "TABLESAMPLE", "STRATIFY", "ALTER",
    "RENAME", "ARRAY", "MAP", "STRUCT", "COMMENT", "SET", "RESET", "DATA", "START", "TRANSACTION", "COMMIT",
    "ROLLBACK", "IGNORE")

  // 状态码, 1: 解析字段中, 2: 解析公式中, 3: 解析带表别名的字段, 4: 解析公式中带表别名的字段
  private var status = 0
  private var tableType = "default"
  // 所有临时表的表名
  private val tempTableNames = new util.HashSet[String]()
  // temp
  private val SQL_TB = "sql"

  // 当前表select语句中的字段
  private var currentSelectFields = new util.ArrayList[JSONObject]()
  private var subCurrentSelectFields = new util.ArrayList[JSONObject]()
  // 当前表依赖的表
  private var currentRelyTables = new util.ArrayList[JSONObject]()
  // 当前表依赖的字段
  private var currentRelyFields = new mutable.HashMap[String, util.HashSet[String]]()
  // 使用别名排序
  private var sortBefore = new util.HashSet[String]()
  // 当前表的全部信息
  private var currentTable = new mutable.HashMap[String, Any]()
  // 当前字段的全部信息
  private var currentField = new mutable.HashMap[String, String]()

  private var unionFilter = false
  // 上层需要的所有临时表的信息, 包括sql, 字段信息, 依赖表的信息
  val tempTables = new util.ArrayList[JSONObject]()
  // 依赖哪些基础表的哪些字段
  var relyBaseTables = new mutable.HashMap[String, util.HashSet[String]]()
  // 用户定义的json变量
  val jsonVariables = new util.ArrayList[JSONObject]()

  // 标记当前处理的临时表是否是机器学习表
  private var isMlTempTb = false
  private var functionName = ""
  // 函数是否检验带别名， 0 检验， 1不检验
  private var functionAlaisStatus = 0
  // 不能确定字段属于哪个表，把不确定的字段和表放在这个变量里面
  var moreFieldsTable = new util.ArrayList[JSONObject]()
  private var lateralAsFields = new util.HashSet[String]()
  // union的时候过滤已经匹配字段的表
  private var unionFilterTable = new util.ArrayList[JSONObject]()

  var tmpTableField = new mutable.HashMap[String, util.Set[String]]()
  var tmprelyTable = new mutable.HashMap[String, util.Set[String]]()
  val fieldMap = new mutable.HashMap[String, util.HashSet[String]]()
  private var usedRelyTable = new util.HashSet[String]()

  private var inSubQuery = false

  private val queryBuffer = ListBuffer[String]()
  /**
   * 修改状态, 表示现在已经进入解析字段
   */
  override def enterNamedExpression(ctx: NamedExpressionContext): Unit = {
    if (!inSubQuery) {
      status = 1
    }
  }

  /**
   *  进入解析公式
   */
  override def enterFunctionCall(ctx: FunctionCallContext): Unit = {
    status match {
      case 5 =>
      case _ => status = 2
    }
  }

  /**
   *  进入带别名的字段处理
   */
  override def enterDereference(ctx: DereferenceContext): Unit = {
    status match {
      case 1 => status = 3
      case 2 => status = 4
      case _ =>
    }
  }

  override def enterFromClause(ctx: FromClauseContext): Unit = {
    status = 5
  }

  override def enterSortItem(ctx: SortItemContext): Unit = {
    if (currentRelyFields.get("default").isDefined) {
      currentRelyFields("default").asScala.foreach(sortBefore.add(_))
    }
  }

  override def exitSortItem(ctx: SortItemContext): Unit = {
    if (currentRelyFields.get("default").isDefined) {
      currentRelyFields("default").asScala.diff(sortBefore.asScala).filter(f => {
        currentSelectFields.asScala.filter(_.obj("name").toString == f).size == 1
      }).foreach(currentRelyFields("default").remove(_))
    }
  }

  override def enterQuerySpecification(ctx: SqlScriptParser.QuerySpecificationContext): Unit = {
    queryBuffer += ctx.getText
  }

  /**
   * {@inheritDoc }
   *
   * <p>The default implementation does nothing.</p>
   */
  override def exitQuerySpecification(ctx: SqlScriptParser.QuerySpecificationContext): Unit = {
    if (queryBuffer.lastOption.contains(ctx.getText)) {
      queryBuffer.remove(queryBuffer.length - 1)
    }
  }

  /**
   * 针对字段的处理, status为3, 4时, 此处处理的是表别名, 并非真实字段
   */
  override def exitColumnReference(ctx: ColumnReferenceContext): Unit = {
    status match {
      case 3 =>
        val tbName = transformChar(ctx.getText)
        currentField.put("rely_alias", tbName)
      case 4 =>
      case 5 =>
      case _ =>
        addCurrentRelyFields(transformChar(ctx.getText))
    }
  }

  /**
   * 针对带表别名字段的处理
   */
  override def exitDereference(ctx: DereferenceContext): Unit = {
    status match {
      case 3 => status = 1
      case 4 => status = 2
      case _ =>
    }
    var tbName = transformChar(ctx.getStart.getText)
    addCurrentRelyFields(transformChar(ctx.getStop.getText), tbName)
  }

  /**
   * 解析标识符, 需要根据当前status判断解析的是什么
   * status为1,3时, 此处是字段信息
   */
  override def exitIdentifier(ctx: IdentifierContext): Unit = {
    status match {
      case 1 =>
        lateralAsFields.add(ctx.getText)
        currentField.put("name", transformChar(ctx.getText))
        if (currentField.get("rely_alias").isEmpty) {
          currentField.put("rely_alias", "")
        }
        if (currentField.get("genre").isEmpty) {
          currentField.put("genre", "default")
        }
        if (currentField.get("rely_field").isEmpty) {
          currentField.put("rely_field", transformChar(ctx.getText))
        }
      case 3 =>
        currentField.put("rely_field", transformChar(ctx.getText))
        currentField.put("name", transformChar(ctx.getText))
        currentField.put("genre", "default")
      case _ =>
    }
  }

  /**
   * 转换函数
   */
  override def enterQualifiedName(ctx: SqlScriptParser.QualifiedNameContext): Unit = {
    if (status == 2) {
      val token = getChild(ctx)
      token.setText(s"${token.getText.toUpperCase()}")
    }
  }

  override def enterWindowDef(ctx: WindowDefContext): Unit = {
    if (status == 2) {
      ctx.children.asScala.foreach{ children =>
        if (keyword.apply(children.getText.toLowerCase())) {
          children.getPayload.asInstanceOf[CommonToken].setText(s"${children.getText.toUpperCase()}")
        }
      }
    }
  }

  /**
   *  记录字段的公式信息
   */
  override def exitFunctionCall(ctx: FunctionCallContext): Unit = {
    status match {
      case 5 =>
      case _ => status = 1
    }
    functionName = ctx.getText
    currentField.put("genre", "function")
    currentField.put("formula", tokens.getText(ctx.getSourceInterval))
    fixIdentifierTokenText(ctx.getSourceInterval)
    currentField.put("fix_formula", tokens.getText(ctx.getSourceInterval))
  }

  override def exitCast(ctx: CastContext): Unit = {
    currentField.put("genre", "function")
    currentField.put("formula", tokens.getText(ctx.getSourceInterval))
    fixIdentifierTokenText(ctx.getSourceInterval)
    currentField.put("fix_formula", tokens.getText(ctx.getSourceInterval))
  }

  /**
   * 常量公式
   */
  override def exitParenthesizedExpression(ctx: ParenthesizedExpressionContext): Unit = {
    currentField.put("genre", "function")
    currentField.put("formula", tokens.getText(ctx.getSourceInterval))
    fixIdentifierTokenText(ctx.getSourceInterval)
    currentField.put("fix_formula", tokens.getText(ctx.getSourceInterval))
  }

  override def exitStringLiteral(ctx: StringLiteralContext): Unit = {
    status match {
      case 1 =>
        currentField.put("genre", "function")
        currentField.put("formula", ctx.getText)
        currentField.put("fix_formula", ctx.getText)
      case _ =>
    }
  }
  override def enterQuery(ctx: SqlScriptParser.QueryContext): Unit = {
    inSubQuery = false
    functionAlaisStatus = 0
    functionName = ""
  }

  /**
   *  退出字段解析的时候, 把收集的上一个字段的信息存到fields里, 清空map继续收集下一个字段
   */
  override def exitNamedExpression(ctx: NamedExpressionContext): Unit = {
    status match {
      case 5 =>
      case _ =>
        if (!inSubQuery && !"*".equals(ctx.getStop.getText)) {
          if (currentField.isEmpty) {
            throw new Exception("brackets are not matched")
          }
          if (currentField.get("rely_alias").isEmpty) {
            currentField.put("rely_alias", "")
          }
          if (currentField.get("name").isEmpty) {
            currentField.put("name", currentField("formula"))
          }
          val field = currentField
          if (queryBuffer.size == 1) {
            currentSelectFields.add(JSONObject(field.toMap))
          }
        }
    }

    if (Seq(2, 3).contains(ctx.getChildCount)) {
      functionName = ""
    } else if (functionAlaisStatus == 0 && functionName != "") {
      throw new Exception(s"expression lack aliases: $functionName")
    } else {
      if (functionAlaisStatus == 0 && ctx.getText.startsWith("(") && ctx.getText.endsWith(")")) {
        throw new Exception(s"expression lack aliases: $functionName")
      } else if (ctx.getText.startsWith("(")) {
        throw new Exception("brackets are not matched")
      }
    }
    currentField = currentField.empty
  }

  override def enterBooleanDefault(ctx: SqlScriptParser.BooleanDefaultContext): Unit = {
    status = 1
  }

  override def enterQueryTermDefault(ctx: QueryTermDefaultContext): Unit = {
    if (ctx.getText.contains("<missing ')'>")) {
      throw new Exception("brackets are not matched")
    }
    val op = ctx.getParent.getChild(1).getText.toLowerCase
    if (op == "union" && currentTable.nonEmpty) {
      tableType = "union"
      filterAllRelyTableFields()
      unionFilter = true
      currentRelyFields = new mutable.HashMap[String, util.HashSet[String]]()
      if (currentSelectFields.size > 0) {
        val selectLength = currentSelectFields.size()
        for (i <- 0 until selectLength) {
          val selectObject = currentSelectFields.get(i).obj
          if (selectObject.get("rely_alias").getOrElse("") == "") {
            if (currentRelyTables.size() > 0 ) {
              val tbNameMap = currentRelyTables.get(currentRelyTables.size() - 1).obj
              val tbName = if (tbNameMap.get("tb_name").nonEmpty) {
                tbNameMap.get("tb_name").getOrElse("")
              } else {
                tbNameMap.get("tb_alias").getOrElse("")
              }
              currentSelectFields.remove(i)
              currentSelectFields.add(i, JSONObject(selectObject.updated("rely_alias", tbName)))
            }
          }
        }
      }
      val tmpCurrentTable = currentTable("rely_tables").asInstanceOf[util.ArrayList[JSONObject]]
      unionFilterTable.add(tmpCurrentTable.get(tmpCurrentTable.size() - 1))
    }
  }

  /**
   *  获取临时表依赖的父表
   */
  override def exitTableName(ctx: TableNameContext): Unit = {
    val rely = new mutable.HashMap[String, String]()
    val tbName = transformChar(ctx.getStart.getText)
    if (alaisWord.apply(ctx.getStop.getText.toUpperCase)) {
      throw new Exception("Exception: alais not valid")
    }
    val tbAlias = transformChar(ctx.getStop.getText)
    rely.put("tb_name", tbName)
    rely.put("tb_alias", tbAlias)
    currentRelyTables.add(JSONObject(rely.toMap))
    if (currentSelectFields.size() > 0) {
      var existsRely = true
      val selectLength = currentSelectFields.size()
      for (i <- 0 until selectLength) {
        val selectObject = currentSelectFields.get(i).obj
        val rely_alias = selectObject.get("rely_alias").getOrElse("").toString
        existsRely = true
        if (currentRelyTables.size() > 0 && rely_alias == "") {
          for (i <- 0 until currentRelyTables.size()) {
            val tbNameMap = currentRelyTables.get(i).obj
            if (tbNameMap.contains("tb_alias") && tbNameMap("tb_alias").toString.equals(rely_alias)) {
              existsRely = false
            }
            if (tbNameMap.contains("tb_name") && tbNameMap("tb_name").toString.equals(rely_alias)) {
              existsRely = false
            }
          }
        } else {
          if ((!(tbName.nonEmpty && tbName.equals(rely_alias)) &&
            !(tbAlias.nonEmpty && tbAlias.equals(rely_alias)) ) || rely_alias.isEmpty) {
            existsRely = false
          }
        }

        if (existsRely) {
          currentSelectFields.remove(i)
          currentSelectFields.add(i, JSONObject(selectObject.updated("rely_alias", tbName)))
        }
      }
    }

    currentTable.put("rely_tables", currentRelyTables)
  }

  override def enterAliasedQuery (ctx: SqlScriptParser.AliasedQueryContext): Unit = {
    if (subCurrentSelectFields.size() == 0) {
      for (i <- 0 until currentSelectFields.size) {
        subCurrentSelectFields.add(JSONObject(currentSelectFields.get(i).obj.updated("rely_alias", "")))
      }
    }
  }

  /**
   * 全部sql遍历结束
   */
  override def exitOutputTable(ctx: OutputTableContext): Unit = {
    if (ctx.tb != null) {
      implicit val formats = DefaultFormats
      var outputName = transformChar(ctx.tb.getText)
      var output: JValue = null
      var outputIndex = 0
      for (i <- 0 until tempTables.size()) {
        val temp = tempTables.get(i)
        if (temp.obj.getOrElse("tb_name", "").toString == outputName) {
          output = parse(temp.toString)
          outputIndex = i
        }
      }
      output = output.replace("tb_name" :: Nil, JString("output"))
      if (outputIndex >= tempTables.size()) {
        throw new Exception(s"Exception: sql parser error")
      }

      try {
        tempTables.remove(outputIndex)
        val tb = JSON.parseRaw(compact(output)).get
        tempTables.add(tb.asInstanceOf[JSONObject])
      } catch {
        case exception: Exception =>
          throw new Exception(s"Exception: sql parser error")
      }

    } else {
      val interval = ctx.query().getSourceInterval
      fixIdentifierTokenText(interval)
      val outputSql = tokens.getText(interval)
      if (outputSql.split("\\sFROM\\s").length == 1 && outputSql.split("\\sfrom\\s").length == 1) {
        throw new Exception(s"output table sql missing 'FROM', sql: $outputSql")
      }

      currentTable.put("tb_name", "output")
      currentTable.put("sql", outputSql)
      if (subCurrentSelectFields.size() > 0) {
        currentTable.put("fields", subCurrentSelectFields)
      } else {
        currentTable.put("fields", currentSelectFields)
      }
      currentTable.put("sql_type", SQL_TB)
      tempTables.add(JSONObject(currentTable.toMap))
      filterAllRelyTableFields()
      clean()
    }
  }

  override def enterTempTable(ctx: TempTableContext): Unit = {
    isMlTempTb = Option(ctx.mlStatement()).isDefined
  }

  /**
   *  遍历完一个临时表
   */
  override def exitTempTable(ctx: TempTableContext): Unit = {
    val tb = transformChar(ctx.tb.getText)

    val interval = ctx.query().getSourceInterval
    fixIdentifierTokenText(interval)
    // 获取查询sql
    val querySql = tokens.getText(interval)


    if (querySql.split("\\sFROM\\s").length == 1 && querySql.split("\\sfrom\\s").length == 1) {
      throw new Exception(s"temp table sql missing 'FROM', name: $tb, sql: $querySql")
    }

    currentTable.put("tb_name", tb)
    currentTable.put("sql", querySql)
    if (subCurrentSelectFields.size() > 0) {
      currentTable.put("fields", subCurrentSelectFields)
    } else {
      currentTable.put("fields", currentSelectFields)
    }
    currentTable.put("sql_type", SQL_TB)
    tempTables.add(JSONObject(currentTable.toMap))
    filterAllRelyTableFields()

    if (tempTableNames.contains(tb)) {
      throw new Exception(s"temp table name duplicate, name: $tb")
    } else {
      tempTableNames.add(tb)
    }
    tmpTableField.put(tb, currentSelectFields.asScala.map(_.obj.get("name").getOrElse("").toString).toSet.asJava)
    tmprelyTable.put(tb, currentRelyTables.asScala.map(_.obj.get("tb_name").getOrElse("").toString).toSet.asJava)
    usedRelyTable.clear()
    clean()
  }

  /**
   *
   * <p>The default implementation does nothing.</p>
   */
  override def exitSquareBracketIdentifier(ctx: SquareBracketIdentifierContext): Unit = {
    replaceTokenByIdentifier(ctx, 1) { token =>
      token.setText(s"`${token.getText}`")
      token
    }
  }

  override def enterLateralView(ctx: LateralViewContext): Unit = {
    lateralAsFields.clear()
  }

  override def exitLateralView(ctx: LateralViewContext): Unit = {
    if (currentRelyFields.contains("default")) {
      lateralAsFields.remove(currentField("rely_field"))
      lateralAsFields.asScala.foreach(currentRelyFields("default").remove(_))
    }
    lateralAsFields.clear()
  }

  override def exitAliasedQuery(ctx: AliasedQueryContext): Unit = {
    filterAllRelyTableFields()
    if (currentRelyFields.contains("default")) {
      currentRelyFields.remove("default")
    }
    currentRelyTables.asScala.foreach(x => usedRelyTable.add(x.obj("tb_name").toString))
  }

  /** Remove the back ticks from an Identifier. */
  override def exitQuotedIdentifier(ctx: QuotedIdentifierContext): Unit = {
    replaceTokenByIdentifier(ctx, 1) { token =>
      // Remove the double back ticks in the string.
      token.setText(token.getText.replace("``", "`"))
      token
    }
  }

  override def exitUnquotedIdentifier(ctx: UnquotedIdentifierContext): Unit = {
    replaceTokenByIdentifier(ctx, 0) { token =>
      val text = token.getText
      if (hasCNChar(text)) {
        token.setText(s"`${token.getText}`")
      }
      token
    }
  }

  /** Treat non-reserved keywords as Identifiers. */
  override def exitNonReserved(ctx: NonReservedContext): Unit = {
    replaceTokenByIdentifier(ctx, 0)(identity)
  }

  override def enterUdtStatement(ctx: UdtStatementContext): Unit = {
    this.status = -1
  }

  override def exitFromClause(ctx: SqlScriptParser.FromClauseContext): Unit = {
    functionAlaisStatus = 1
  }

  override def exitVariableDefined(ctx: VariableDefinedContext): Unit = {
    val variableName = ctx.variableName.getText
    val jsonBody = ctx.jsonValue().getText
    this.jsonVariables.add(new JSONObject(Map("variableName" -> variableName, "jsonBody" -> jsonBody)))
  }

  private def getChild(tree: ParseTree): CommonToken = {
    if (tree.getChildCount != 0) {
      getChild(tree.getChild(0))
    } else {
      tree.getPayload.asInstanceOf[CommonToken]
    }
  }

  /**
   * 每轮遍历完一个临时表后, 把依赖的基础表的字段信息汇总
   * @param tbName 字段所属表的表名
   * @param alias  字段所属表的别名
   */
  private def addRelyBaseTableFields(tbName: String, alias: String = "default",
                                     relyTable: mutable.HashSet[String]): Unit = {
    if (!tempTableNames.contains(tbName)) {
      val relyFields = if (currentRelyFields.get(alias).isEmpty) {
        currentRelyFields.getOrElse("default", null)
      } else {
        currentRelyFields(alias).addAll(currentRelyFields.getOrElse("default", new util.HashSet[String]()))
        currentRelyFields(alias)
      }
      if (relyFields != null) {
        if (relyBaseTables.get(tbName).isEmpty) {
          relyBaseTables.put(tbName, relyFields)
          relyTable.add(tbName)
        } else {
          val fields = relyBaseTables(tbName)
          relyFields.asScala.foreach{ a =>
            fields.add(a)
          }
          relyTable.add(tbName)
          relyBaseTables.put(tbName, fields)
        }
      } else {
        if (currentRelyTables.asScala.filter(obj => obj.obj.get("tb_name").get == tbName).size == 0
          && relyBaseTables.get(tbName).isEmpty) {
          relyTable.add(tbName)
          relyBaseTables.put(tbName, new util.HashSet[String]())
        }
      }
    }
  }

  /**
   * 每遍历到一个sql中出现的字段, 把字段添加到对应的依赖列表里, 用于获得最后的基础表依赖字段列表
   * @param fieldName 字段名
   * @param tbName 所属表的别名
   */
  private def addCurrentRelyFields(fieldName: String, tbName: String = "default"): Unit = {
    if (currentRelyFields.get(tbName).isEmpty) {
      val fields = new util.HashSet[String]()
      fields.add(fieldName)
      currentRelyFields.put(tbName, fields)
    } else {
      val fields = currentRelyFields(tbName)
      fields.add(fieldName)
      currentRelyFields.put(tbName, fields)
    }
  }

  /**
   * 整理当前表所依赖的全部字段, 非基础表的丢弃掉
   */
  private def filterAllRelyTableFields(): Unit = {
    if (currentTable.get("rely_tables").isEmpty) {
      return
    }
    val rely = currentTable("rely_tables").asInstanceOf[util.ArrayList[JSONObject]]
    val relyTable = new mutable.HashSet[String]()
    rely.asScala.diff(unionFilterTable.asScala).foreach{ tb =>
      implicit val formats = DefaultFormats
      val table = parse(tb.toString()).extract[Map[String, String]]
      val tbName = table("tb_name")
      val alias = table("tb_alias")
      addRelyBaseTableFields(tbName, alias, relyTable)
    }
    val all = rely.asScala.map(_.obj.get("tb_name").get.toString).filter(tmprelyTable.contains(_))
      .flatMap(tmprelyTable(_).toArray)
    val tbNameFields = new mutable.HashMap[String, String]()
    if ( !unionFilter && currentRelyFields.contains("default") ) {
      rely.asScala.map(_.obj.get("tb_name").get.toString).filter(tb => relyTable.contains(tb)
        && !usedRelyTable.contains(tb)).foreach(tb => {
        currentRelyFields("default").asScala.foreach(field => {
          if (tbNameFields.get(field).isDefined) {
            tbNameFields.put(field, s"${tbNameFields(field)}\001${tb}")
          } else {
            tbNameFields.put(field, s"${tb}")
          }
        })
      })
      rely.asScala.map(_.obj.get("tb_name").get.toString).filter(tmprelyTable.contains(_)).foreach(tb => {
        tmprelyTable(tb).asScala.foreach(tb2 => {
          currentRelyFields("default").asScala.foreach(field => {
            if (tmpTableField.get(field).isDefined && tmpTableField(tb).contains(field)) {
              if (relyBaseTables.get(tb2).isDefined && relyBaseTables(tb2).contains(field)) {
                if (tbNameFields.get(field).isDefined) {
                  tbNameFields.put(field, s"${tbNameFields(field)}\001${tb2}")
                } else {
                  tbNameFields.put(field, s"${tb2}")
                }
              }
            }
          })
        })
      })
      val tmp = tbNameFields.map(x => (x._1, x._2.split("\001").toSet)).filter(_._2.size > 1)
        .map(x => (x._1, x._2.mkString("\001"))).groupBy(_._2)
        .mapValues(r => {r.map(r => {r._1}).toSet.asJava.toString})
      if (tmp.size > 0) {
        moreFieldsTable.add(JSONObject(tmp))
      }
    }
    unionFilter = false
  }

  /**
   * 遍历完一个临时表后的清理工作
   */
  private def clean(): Unit = {
    status = 0
    currentSelectFields = new util.ArrayList[JSONObject]()
    subCurrentSelectFields = new util.ArrayList[JSONObject]()
    currentRelyTables = new util.ArrayList[JSONObject]()
    currentRelyFields = new mutable.HashMap[String, util.HashSet[String]]()
    currentTable = currentTable.empty
    currentField = currentField.empty
    unionFilterTable.clear()
    isMlTempTb = false
  }

  private def replaceTokenByIdentifier(ctx: ParserRuleContext, stripMargins: Int)
                                      (f: CommonToken => CommonToken = identity): Unit = {
    val parent = ctx.getParent
    parent.removeLastChild()
    val token = ctx.getChild(0).getPayload.asInstanceOf[Token]
    parent.addChild(f(new CommonToken(
      new org.antlr.v4.runtime.misc.Pair(token.getTokenSource, token.getInputStream),
      SqlScriptParser.IDENTIFIER,
      token.getChannel,
      token.getStartIndex + stripMargins,
      token.getStopIndex - stripMargins)))
  }

  private def fixIdentifierTokenText(interval: Interval): Unit = {
    // 将[xxx]转换为`xxx`
    val squareBracketTokens = tokens.getTokens(interval.a, interval.b, SqlScriptParser.SQUARE_BRACKET_IDENTIFIER)

    if (squareBracketTokens != null) {
      for (i <- 0 until squareBracketTokens.size()) {
        val token = squareBracketTokens.get(i)
        val text = token.getText
        token.asInstanceOf[CommonToken].setText(s"`${text.substring(1, text.length - 1)}`")
      }
    }
    // 将中文的identifier附加``,便于Spark识别
    val identifierTokens = tokens.getTokens(interval.a, interval.b, SqlScriptParser.IDENTIFIER)
    if (identifierTokens != null) {
      for (i <- 0 until identifierTokens.size()) {
        val token = identifierTokens.get(i)
        val text = token.getText
        if (hasCNChar(text)) {
          token.asInstanceOf[CommonToken].setText(s"`$text`".replace("``", "`"))
        }
      }
    }
  }

  /**
   * 判断字符串中是否包含中文
   * @param str
   * @return
   */
  private def hasCNChar(str: String): Boolean = {
    str.exists(c => {
      val i = c.toInt
      i >= 0x4e00 && i <= 0x9fa5
    })
  }

  private def transformChar(name: String): String = {
    if (name.charAt(0) == '[' || name.charAt(0) == '`') {
      name.substring(1, name.length-1)
    } else {
      name
    }
  }

  private def getOrNullValue[I, O](orNull: I)(f: I => O): Option[O] = {
    handleOption(Option(orNull))(f)
  }

  private def handleOption[I, O](opt: Option[I])(f: I => O): Option[O] = {
    opt match {
      case Some(v) => Some(f(v))
      case None => None
    }
  }

}
