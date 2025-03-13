package org.apache.spark.sql.execution.datasources.httpV1Filter

import log.LazyLogging
import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.expressions.aggregate.{AggregateExpression, Count}
import org.apache.spark.sql.catalyst.expressions.{Alias, And, Attribute, AttributeReference, Cast, Contains, EndsWith, EqualNullSafe, EqualTo, Expression, GreaterThan, GreaterThanOrEqual, In, IsNotNull, IsNull, LessThan, LessThanOrEqual, Literal, Not, Or, StartsWith}
import org.apache.spark.sql.catalyst.plans.logical.{Aggregate, Filter, LogicalPlan, SubqueryAlias}
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.types.{IntegerType, StringType}

object HttpPushDownRule extends Rule[LogicalPlan] with LazyLogging{
  def apply(plan: LogicalPlan): LogicalPlan = plan transform {

    case agg@Aggregate(_, aggregateExpressions, child) =>
      findLogicalRelation(child) match {
        case Some(lr@LogicalRelation(rel: HttpFilterRelation, output, catalogTable, isStreaming)) =>
          // 判断聚合表达式是否为简单的 COUNT(1)
          if (isSimpleCount(aggregateExpressions)) {
            logger.info(s"count match")
            // 根据是否有 Filter 节点等构造下推 SQL
            val pushedSql = s"SELECT COUNT(1) AS count FROM ${rel.httpOptions.tableName} ${compileFilters(child)}"
            // val newRel = rel.copy(pushedSql = Some(pushedSql))(rel.sparkSession)
            val newRel = new HttpFilterRelation(rel.pushedCols, Some(pushedSql), rel.httpOptions)(rel.sparkSession)
            // output的schema是spark自身根据计划生成的，如果调整了HttpFilterRelation并返回了新的schema，需要将该schema添加进逻辑计划，否则requireColumns的值还是原始值，类型也是
            // ArrayIndexOutOfBoundsException(output为n列，但是count仅为1列，逻辑计划传参为output)
            // java.lang.Long cannot be cast to org.apache.spark.unsafe.types.UTF8String(count的schema为Long，但是output的列为String)
            LogicalRelation(newRel, newRel.schema.toAttributes, catalogTable, isStreaming)
          } else {
            agg
          }
        case _ =>
          agg
      }

    case limit@GlobalLimit(IntegerLiteral(n), child) =>
      // 当执行show时spark会自带优化，添加limit n（show默认是20 则添加limit 21，若设置show(30) 则添加limit 31，依次类推）
      // 实际使用中获取数据通过df.collect，而不是df.show，则可以不添加if(n == 21)这一段
      if (n == 21) {
        // 跳过Spark默认插入的limit
        logger.info(s"Detected Spark internal limit=21 => skip, but transform child => $child")
        // 定义一个 partial function, 对子树每个节点都再次调用本规则
        val transformPF: PartialFunction[LogicalPlan, LogicalPlan] = {
          case plan => this.apply(plan)
        }
        // 用 transformDown 递归地对 child 子树应用当前规则
        val newChild = child.transformDown(transformPF)
        limit.copy(child = newChild)
      } else if (isAggregate(child)) {
        // 如果 child 中含有聚合(你说不想拦截聚合limit)，则跳过
        logger.info(s"child is aggregator => skip limit")
        limit
      } else {
        // 尝试在 child 中递归查找 HttpFilterRelation
        findLogicalRelation(child) match {
          case Some(lr@LogicalRelation(rel: HttpFilterRelation, output, catalogTable, isStreaming)) =>
            logger.info(s"limit n=>$n")
            // 下推limit
            val cols = parseColumns(child)
            println(s"limit get cols=>${cols.mkString(",")}")
            val pushedSql = s"SELECT ${if (cols.isEmpty) "*" else cols.mkString(", ")} FROM ${rel.httpOptions.tableName} ${compileFilters(child)} LIMIT ${n}"
            val newRel = new HttpFilterRelation(Some(cols), Some(pushedSql), rel.httpOptions)(rel.sparkSession)
            // val newRel = rel.copy(pushedLimit = Some(n))(rel.sparkSession)
            // 用新的Relation替换
            LogicalRelation(newRel, newRel.schema.toAttributes, catalogTable, isStreaming)
          case None =>
            limit
        }
      }

    case other => other
  }

  /**
   * 解析子计划中的列:若有Project =>提取投影列;否则返回空(表示*)
   */
  private def parseColumns(plan: LogicalPlan): Seq[String] = plan match {
    case Project(projectList, _) =>
      // 获取投影列名
      projectList.collect {
        case Alias(attr: Attribute, name) => name
        case attr: Attribute => attr.name
      }
    case LogicalRelation(_, output, _, _) => output.map(_.name)
    case LocalLimit(_, child) => parseColumns(child)
    case GlobalLimit(_, child) => parseColumns(child)
    case Filter(_, child) => parseColumns(child)
    case SubqueryAlias(_, child) => parseColumns(child)
    case _ => Nil
  }

  // 是否Relation里已下推了聚合？
  // 例如HttpFilterRelation(pushedSql=Some("SELECT COUNT(1) ..."))
  // 也可根据schema或其他标志判断
  private def relContainsAggregate(rel: HttpFilterRelation): Boolean = {
    rel.pushedSql match {
      case Some(sql) => sql.toUpperCase.contains("COUNT(1)")
      case None => false
    }
  }

  private def compileFilters(plan: LogicalPlan): String = {
    // 从 plan 中收集所有 Filter 节点的条件表达式
    val conditions: Seq[Expression] = plan.collect { case Filter(condition, _) => condition }
    logger.info(s"Filter Expression ==> ${conditions.size}, ${conditions.mkString(",")}")
    if (conditions.nonEmpty) {
      try {
        // 如果存在多个 Filter 条件，则使用 And 将它们连接起来
        val combinedCondition = conditions.reduce(And)
        s"WHERE ${compileCondition(combinedCondition)}"
      } catch {
        case e: Exception =>
          logger.warn(s"Match Error => ${e.printStackTrace()}")
          ""
      }
    } else {
      ""
    }
  }

  // 判断聚合表达式是否为简单的COUNT(1)
  private def isSimpleCount(exprs: Seq[Expression]): Boolean = {
    exprs.size == 1 && (exprs.head match {
      case alias: Alias =>
        val unwrapped = unwrapCast(alias.child)
        unwrapped match {
          case aggExpr: AggregateExpression =>
            aggExpr.aggregateFunction match {
              case count: Count =>
                count.children match {
                  case Seq(literal: Literal) =>
                    logger.info(s"Found literal: $literal, value: ${literal.value}")
                    literal.value == 1 || literal.value == 1L
                  case _ => false
                }
              case _ => false
            }
          case _ => false
        }
      case count: Count =>
        count.children match {
          case Seq(literal: Literal) =>
            literal.value == 1 || literal.value == 1L
          case _ => false
        }
      case _ =>
        false
    })
  }

  // 提取int值
  object IntegerLiteral {
    def unapply(expr: Expression): Option[Int] = expr match {
      case Literal(value, IntegerType) => Some(value.asInstanceOf[Int])
      case _ => None
    }
  }

  // 如果遇到 Project / Filter / SubqueryAlias / Limit 等包装节点，就继续递归检查其子节点
  private def isAggregate(plan: LogicalPlan): Boolean = plan match {
    case Aggregate(_, _, _) => true
    case Project(_, child) =>
      isAggregate(child)
    case Filter(_, child) =>
      isAggregate(child)
    case SubqueryAlias(_, child) =>
      isAggregate(child)
    case GlobalLimit(_, child) =>
      isAggregate(child)
    case LocalLimit(_, child) =>
      isAggregate(child)
    // 其他不关心的节点则认为“未找到Aggregate”
    case _ =>
      logger.info(s"limit match false=>${plan.getClass.getName}")
      false
  }

  // 解包
  private def unwrapCast(expr: Expression): Expression = expr match {
    // 2.4.6的Cast需要3个参数，3.2.2的Cast需要4个参数，这种匹配就可兼顾不同版本
    case c: Cast => unwrapCast(c.child)
    case other => other
  }

  private def findLogicalRelation(plan: LogicalPlan): Option[LogicalRelation] = plan match {
    case lr: LogicalRelation if lr.relation.isInstanceOf[HttpFilterRelation] => Some(lr)
    case SubqueryAlias(_, child) => findLogicalRelation(child)
    case Project(_, child) => findLogicalRelation(child)
    case Filter(_, child) => findLogicalRelation(child)
    case GlobalLimit(_, child) => findLogicalRelation(child)
    case LocalLimit(_, child) => findLogicalRelation(child)
    case _ => None
  }

  // 将过滤条件转换为 SQL WHERE 子句部分
  private def compileCondition(expr: Expression): String = expr match {
    case EqualTo(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} = '$value'"
    case Not(EqualTo(attr: AttributeReference, Literal(value, _))) =>
      s"${attr.name} != '$value'"
    case GreaterThan(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} > '$value'"
    case LessThan(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} < '$value'"
    case GreaterThanOrEqual(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} >= '$value'"
    case LessThanOrEqual(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} <= '$value'"
    case And(left, right) =>
      s"(${compileCondition(left)} AND ${compileCondition(right)})"
    case Or(left, right) =>
      s"(${compileCondition(left)} OR ${compileCondition(right)})"
    case IsNotNull(attr: AttributeReference) =>
      s"${attr.name} IS NOT NULL"
    case IsNull(attr: AttributeReference) =>
      s"${attr.name} IS NULL"
    case StartsWith(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} LIKE '${value}%'"
    case EndsWith(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} LIKE '%${value}'"
    case Contains(attr: AttributeReference, Literal(value, _)) =>
      s"${attr.name} LIKE '%${value}%'"
    case In(attr: AttributeReference, list) =>
      val vs = list.map {
        case Literal(v, _) => s"'$v'"
        case _ => "NULL"
      }.mkString(", ")
      s"${attr.name} IN ($vs)"
    case EqualNullSafe(attr: AttributeReference, Literal(v, _)) =>
      s"(NOT(${attr.name} != '$v' OR ${attr.name} IS NULL OR '$v' IS NULL) OR (${attr.name} IS NULL AND '$v' IS NULL))"
    case _ =>
      logger.info(s"can not match=>${expr}")
      "1 = 1"
  }
}
