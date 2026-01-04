package sql.parser

import antlr.sql.{SqlScriptBaseListener, SqlScriptLexer, SqlScriptParser}
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeWalker, TerminalNode}
import antlr.sql.SqlScriptParser._

import java.util
import scala.collection.JavaConverters._
import scala.collection.mutable
import json.source.JSONObject

class OriginSqlScriptProcessor(parser: SqlScriptParser) extends SqlScriptBaseListener {
  private val tokens = parser.getTokenStream.asInstanceOf[BufferedTokenStream]

  // 状态码, 1: 解析字段中, 2: 解析公式中, 3: 解析带表别名的字段, 4: 解析公式中带表别名的字段
  private var status = 0

  // 所有临时表的表名
  private val tempTableNames = new util.HashSet[String]()
  // 当前表依赖的字段
  private var currentRelyFields = new mutable.HashMap[String, util.HashSet[mutable.HashMap[String, String]]]()
  // 当前表依赖的表
  private var currentRelyTables = new util.ArrayList[mutable.HashMap[String, String]]()

  private val subQueryName = new StringBuffer("")
  private var functionName = ""
  // 上层替换字段时需要的字段信息及字段位置
  var replaceFields = new mutable.HashMap[String, JSONObject]()

  private var currentSelectFields = new mutable.HashMap[String, util.ArrayList[String]]()
  private var currentTable = new mutable.HashMap[String, mutable.HashMap[String, util.ArrayList[String]]]()
  var replaceTables = new mutable.HashMap[String, JSONObject]()
  var tempfields = new mutable.HashMap[String, String]()
  var tempTBName = "default"
  var temflag = true

  //  tempfieldVariable 过滤每个表达式中的常量
  private var tempfieldVariable = new util.ArrayList[String]()
  // 实际每个字段中用到的变量值
  private var fieldVariable = new util.ArrayList[String]()
  // 字段对应常量值，不包含 表达式中的变量
  val fieldContainVariables = new util.ArrayList[JSONObject]()
  // 函数是否检验带别名， 0 检验， 1不检验
  private var functionAlaisStatus = 0

  private var excludeSubTableName = new util.ArrayList[String]()

  private var subQuery = new mutable.HashMap[String, util.ArrayList[String]]()

  /**
   * 修改状态, 表示现在已经进入解析字段
   */
  override def enterNamedExpression(ctx: NamedExpressionContext): Unit = {
    status = 1
  }

  /**
   *  进入解析公式
   */
  override def enterFunctionCall(ctx: FunctionCallContext): Unit = {
    status = 2
  }

  /**
   *  进入带别名的字段处理
   */
  override def enterDereference(ctx: DereferenceContext): Unit = {
    status match {
      case 0 => status = 5
      case 1 => status = 3
      case 2 => status = 4
      case _ =>
    }
  }

  override def enterQuery(ctx: SqlScriptParser.QueryContext): Unit = {
    functionAlaisStatus = 0
    functionName = ""
  }

  override def exitFromClause(ctx: SqlScriptParser.FromClauseContext): Unit = {
    functionAlaisStatus = 1
  }

  /**
   * 针对字段的处理, status为3, 4时, 此处处理的是表别名, 并非真实字段
   */
  override def exitColumnReference(ctx: ColumnReferenceContext): Unit = {
    status match {
      case 3 =>
      case 4 =>
      case 5 =>
      case _ =>
        val field = new mutable.HashMap[String, String]()
        field.put("name", ctx.getText)
        field.put("rely", "")
        field.put("type", "default")
        field.put("start", ctx.getStart.getStartIndex.toString)
        field.put("stop", ctx.getStop.getStopIndex.toString)
        tempfields = field
        addCurrentRelyFields(field)
    }
  }

  /**
   * 针对带表别名字段的处理
   */
  override def exitDereference(ctx: DereferenceContext): Unit = {
    status match {
      case 5 => status = 0
      case 3 => status = 1
      case 4 => status = 2
      case _ =>
    }
    val field = new mutable.HashMap[String, String]()
    val tbName = transformChar(ctx.getStart.getText)
    if (tbName != ctx.getStart.getText) {
      field.put("tb_type", "alias")
    }

    field.put("name", ctx.getStop.getText)
    field.put("rely", tbName)
    field.put("type", "alias")
    field.put("start", ctx.getStart.getStartIndex.toString)
    field.put("stop", ctx.getStop.getStopIndex.toString)
    tempfields = field
    tempTBName = tbName
    addCurrentRelyFields(field, tbName)
  }

  override def enterConstantDefault (ctx: SqlScriptParser.ConstantDefaultContext): Unit = {
    tempfieldVariable.add(ctx.getText)
  }

  override def exitComparison(ctx: SqlScriptParser.ComparisonContext): Unit = {
    if ( ctx.getChildCount == 3 ) {
      if (tempfieldVariable.contains(ctx.getChild(0).getText)) {
        tempfieldVariable.remove(ctx.getChild(0).getText)
      }

      if (tempfieldVariable.contains(ctx.getChild(2).getText)) {
        tempfieldVariable.remove(ctx.getChild(2).getText)
      }
      tempfieldVariable.asScala.foreach(x => {
        if ( x.startsWith("'")) {
          fieldVariable.add("\"" + x.substring(1, x.length -1) + "\"")
        } else {
          fieldVariable.add(x)
        }
      })
      tempfieldVariable.clear()
    }
    val cc = ctx.getText
  }

  override def exitFunctionCall(ctx: FunctionCallContext): Unit = {
    functionName = transformChar(ctx.getText)
    status = 1
  }

  override def exitNamedExpression(ctx: NamedExpressionContext): Unit = {
    if (Seq(2, 3).contains(ctx.getChildCount)) {
      val childCnt = if (ctx.getChildCount == 3) {
        2
      } else {
        1
      }
      val name1 = transformChar(ctx.getChild(0).getText)
      val name2 = transformChar(ctx.getChild(childCnt).getText)
      val alaisName = ctx.getChild(childCnt).getText
      if (name1.equals(name2)) {
        tempfields.put("field_alias", alaisName)
        addCurrentRelyFields(tempfields, tempTBName)
      }

      if (tempfieldVariable.size() > 0) {
        tempfieldVariable.asScala.foreach(x => {
          if ( x.startsWith("'") ) {
            fieldVariable.add("\"" + x.substring(1, x.length -1) + "\"")
          } else {
            fieldVariable.add(x)
          }
        })
      }
      if (fieldVariable.size() > 0) {
        fieldContainVariables.add(new JSONObject(Map(alaisName -> fieldVariable.clone())))
      }
      tempfieldVariable.clear()
      fieldVariable.clear()
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

    status = 0
  }

  /**
   *  获取临时表依赖的父表
   */
  override def exitTableName(ctx: TableNameContext): Unit = {
    val rely = new mutable.HashMap[String, String]()
    val table = new mutable.HashMap[String, String]()

    val tbName = transformChar(ctx.getStart.getText)
    val tbAlias = transformChar(ctx.getStop.getText)
    if (tbName.equals(tbAlias)) {
      table.put("type", "default")
    } else {
      table.put("type", "alias")
    }
    rely.put("tb_name", tbName)
    rely.put("tb_alias", tbAlias)

    table.put("name", tbName)
    table.put("rely", ctx.getStart.getText)
    table.put("alias", tbAlias)
    table.put("start", ctx.getStart.getStartIndex.toString)
    table.put("stop", ctx.getStart.getStopIndex.toString)
    replaceTables.put(ctx.getStart.getStartIndex.toString, JSONObject(table.toMap))
    currentRelyTables.add(rely)
  }

  override def exitOutputTable(ctx: SqlScriptParser.OutputTableContext): Unit = {
    if (ctx.tb == null) {
      sortCurrentRelyTableByAddReverse()
      filterAllRelyTableFields()
      cleanSqlTempTable()
    }
  }

  override def exitTempTable(ctx: SqlScriptParser.TempTableContext): Unit = {
    val tb = ctx.tb.getText
    sortCurrentRelyTableByAddReverse()
    filterAllRelyTableFields()
    tempTableNames.add(tb)

    currentTable.put(tb, currentSelectFields)
    cleanSqlTempTable()
  }

  override def enterQueryTermDefault(ctx: QueryTermDefaultContext): Unit = {
    if (ctx.getText.contains("<missing ')'>")) {
      throw new Exception("brackets are not matched")
    }
    val op = ctx.getParent.getChild(1).getText.toLowerCase
    if (op == "union") {
      sortCurrentRelyTableByAddReverse()
      filterAllRelyTableFields()
    }
  }

  override def exitAliasedQuery(ctx: SqlScriptParser.AliasedQueryContext): Unit = {
    val existTableName = currentSelectFields.map(_._1).toList
    filterAllRelyTableFields()
    if (ctx.getStop.getText != ")") {
      val queryList = new util.ArrayList[String]()
      currentSelectFields.filter(tb => !existTableName.contains(tb._1)).foreach(tb => {
        queryList.add(tb._1)
        val tmpMap = new mutable.HashMap[String, util.ArrayList[String]]()
        tmpMap.put(tb._1, tb._2)
        currentTable.put(tb._1, tmpMap)
      })
      subQuery.put(ctx.getStop.getText, queryList)
      val rely = new mutable.HashMap[String, String]()
      rely.put("tb_name", ctx.getStop.getText)
      rely.put("tb_alias", ctx.getStop.getText)
      currentRelyTables.add(rely)
    }
    val defaultMax = currentRelyFields.get(s"default${subQueryName.length()}")
    val default = currentRelyFields.get("default")
    if (defaultMax.nonEmpty) {
      if (default.isEmpty) {
        currentRelyFields.put("default", defaultMax.get)
      } else {
        currentRelyFields.get("default").get.addAll(defaultMax.get)
      }
      currentRelyFields.remove(s"default${subQueryName.length()}")
      subQueryName.deleteCharAt(0)
    }
  }

  override def enterAliasedQuery(ctx: SqlScriptParser.AliasedQueryContext): Unit = {
    if (currentRelyFields.get("default").nonEmpty) {
      subQueryName.append("1")
      currentRelyFields.put(s"default${subQueryName.length()}", currentRelyFields.get("default").get)
      currentRelyFields.remove("default")
    } else {
      if (currentRelyFields.size == 1) {
        subQueryName.append("1")
        val keys = currentRelyFields.keysIterator.next()
        val values = currentRelyFields.get(keys).get
        val hs = new util.HashSet[mutable.HashMap[String, String]]()
        currentRelyFields.get(keys).get.asScala.map(item => {
          val map = new mutable.HashMap[String, String]()
          item.keySet.foreach(key => {
            map.put(key, item.get(key).get)
          })
          map.put("rely_replace", map("rely"))
          map.put("rely", "")
          hs.add(map)
        })
        currentRelyFields.put(s"default${subQueryName.length()}", hs)
        currentRelyFields.remove(keys)
      }
    }
  }

  override def enterSubqueryExpression(ctx: SqlScriptParser.SubqueryExpressionContext): Unit = {
    if (currentRelyFields.get("default").nonEmpty) {
      subQueryName.append("1")
      currentRelyFields.put(s"default${subQueryName.length()}", currentRelyFields.get("default").get)
      currentRelyFields.remove("default")
    } else {
      if (currentRelyFields.size == 1) {
        subQueryName.append("1")
        val keys = currentRelyFields.keysIterator.next()
        currentRelyFields.put(s"default${subQueryName.length()}", currentRelyFields.get(keys).get)
        currentRelyFields.remove(keys)
      }
    }
  }

  override def exitSubqueryExpression(ctx: SqlScriptParser.SubqueryExpressionContext): Unit = {
    filterAllRelyTableFields()
    val default = currentRelyFields.get("default")
    val defaultMax = currentRelyFields.get(s"default${subQueryName.length()}")
    if (defaultMax.nonEmpty) {
      if (default.isEmpty) {
        currentRelyFields.put("default", defaultMax.get)
      } else {
        currentRelyFields.get("default").get.addAll(defaultMax.get)
      }
      currentRelyFields.remove(s"default${subQueryName.length()}")
      currentRelyTables.remove(currentRelyTables.size() - 1)
      subQueryName.deleteCharAt(0)
    }
  }

  /**
   * 每遍历到一个sql中出现的字段, 把字段添加到对应的依赖列表里, 用于获得最后的基础表依赖字段列表
   * @param field 字段信息
   * @param tbName 所属表的别名
   */
  private def addCurrentRelyFields(field: mutable.HashMap[String, String], tbName: String = "default"): Unit = {
    if (currentRelyFields.get(tbName).isEmpty) {
      val fields = new util.HashSet[mutable.HashMap[String, String]]()
      fields.add(field)
      currentRelyFields.put(tbName, fields)
    } else {
      val fields = currentRelyFields(tbName)
      fields.add(field)
      currentRelyFields.put(tbName, fields)
    }
  }

  /**
   * 整理当前表所依赖的全部字段, 非基础表的丢弃掉
   */
  private def filterAllRelyTableFields(): Unit = {
    currentRelyTables.asScala.foreach{ tb =>
      val tbName = tb("tb_name")
      val alias = tb("tb_alias")
      addRelyBaseTableFields(tbName, alias)
    }

  }

  /**
   * 每轮遍历完一个临时表后, 把依赖的基础表的字段信息汇总
   *
   * @param tbName 字段所属表的表名
   * @param alias  字段所属表的别名
   */
  private def addRelyBaseTableFields(tbName: String, alias: String = "default"): Unit = {
    val relyFields = if (currentRelyFields.get(alias).isEmpty) {
      currentRelyFields.getOrElse("default", null)
    } else {
      val default = new util.HashSet[mutable.HashMap[String, String]]()
      currentRelyFields.getOrElse("default",
        new util.HashSet[mutable.HashMap[String, String]]()).asScala.foreach { f => default.add(f.clone()) }
      currentRelyFields(alias).addAll(default)
      currentRelyFields(alias)
    }
    if (relyFields != null) {

      val tempSelectFields = if ( currentTable.get(tbName).nonEmpty ) {
        currentTable.get(tbName).get
      } else {
        null
      }

      if (tempTableNames.contains(tbName)) {
        relyFields.asScala.foreach { f =>
          val tmpTB = f("rely")
          if (tempSelectFields != null) {
            tempSelectFields.foreach {
              x =>
                val list = new util.ArrayList[String]()
                if (x._2.contains(transformChar(f("name"))) || x._2.contains(s"[${transformChar(f("name"))}]") ||
                  x._2.contains(s"`${transformChar(f("name"))}`")) {
                  f.put("rely", x._1)
                  list.add(f("name"))
                  if (!tbName.equals("default")) {
                    currentSelectFields.put(x._1, list)
                  }
                  if (replaceFields.get(f("start")).nonEmpty) {
                    f.put("rely_replace",
                      replaceFields.get(f("start")).get.obj.get("rely_replace").getOrElse(x._1).toString)
                    replaceFields.put((f("start").toInt + 1).toString, JSONObject(f.toMap))
                  } else {
                    f.put("rely_replace", tmpTB)
                    replaceFields.put(f("start"), JSONObject(f.toMap))
                  }
                }
            }
          }
        }
      } else if (subQuery.get(tbName).nonEmpty) {
        relyFields.asScala.foreach { f =>
          val tmpTB = f("rely")
          val listTempSelectFields = subQuery(tbName).asScala.filter(tb => currentTable.get(tb).nonEmpty)
            .map(currentTable(_))
          if (listTempSelectFields != null) {
            listTempSelectFields.foreach (tempSelectFields => {
              tempSelectFields.foreach {
                x =>
                  val list = new util.ArrayList[String]()
                  if (x._2.contains(transformChar(f("name"))) || x._2.contains(s"[${transformChar(f("name"))}]") ||
                    x._2.contains(s"`${transformChar(f("name"))}`")) {
                    f.put("rely", x._1)
                    list.add(f("name"))
                    if (!tbName.equals("default")) {
                      currentSelectFields.put(x._1, list)
                    }
                    if (replaceFields.get(f("start")).nonEmpty) {
                      f.put("rely_replace",
                        replaceFields.get(f("start")).get.obj.get("rely_replace").getOrElse(x._1).toString)
                      replaceFields.put((f("start").toInt + 1).toString, JSONObject(f.toMap))
                    } else {
                      f.put("rely_replace", tmpTB)
                      replaceFields.put(f("start"), JSONObject(f.toMap))
                    }
                  }
              }
            })
          }
        }
      } else {
        val list = new util.ArrayList[String]()
        relyFields.asScala.foreach { f =>
          if (f.get("field_alias").isEmpty) {
            list.add(f("name"))
          }
          if (f("rely") == "" || f("rely") == alias) {
            f.put("rely", tbName)
            if (f.get("rely_replace").isEmpty) {
              f.put("rely_replace", alias)
            }
          } else if (f("rely") != "" && f("rely") != alias) {
            if (f.get("rely_replace").isEmpty) {
              f.put("rely_replace", alias)
            }
          }
          if (replaceFields.get(f("start")).nonEmpty) {
            replaceFields.put((f("start").toInt + 1).toString, JSONObject(f.toMap))
          } else {
            replaceFields.put(f("start"), JSONObject(f.toMap))
          }
        }
        currentSelectFields.put(tbName, list)
      }
    }
  }

  // 取添加顺序倒序，仅为union时字段指定表名
  private def sortCurrentRelyTableByAddReverse(): Unit = {
    if (currentRelyTables.size() > 1) {
      val it = currentRelyTables.iterator()
      val arr = new util.ArrayList[mutable.HashMap[String, String]]()
      while (it.hasNext) {
        arr.add(it.next())
      }
      currentRelyTables.clear()
      for (i <- 0 until arr.size) {
        currentRelyTables.add(arr.get(arr.size - 1 - i))
      }
    }
  }

  private def transformChar(name: String): String = {
    if (name.charAt(0) == '[' || name.charAt(0) == '`') {
      name.substring(1, name.length-1)
    } else {
      name
    }
  }

  /**
   * 遍历完一个临时表后的清理工作
   */
  private def cleanSqlTempTable(): Unit = {
    currentRelyTables = new util.ArrayList[mutable.HashMap[String, String]]()
    currentRelyFields = new mutable.HashMap[String, util.HashSet[mutable.HashMap[String, String]]]()
    currentSelectFields = new mutable.HashMap[String, util.ArrayList[String]]()
  }
}
