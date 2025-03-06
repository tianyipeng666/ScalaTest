package org.apache.spark.sql.execution.datasources.httpV1Filter

import log.LazyLogging
import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.expressions.aggregate.{AggregateExpression, Count}
import org.apache.spark.sql.catalyst.expressions.{Alias, And, AttributeReference, Cast, EqualTo, Expression, GreaterThan, GreaterThanOrEqual, IsNotNull, IsNull, LessThan, LessThanOrEqual, Literal, Not, Or}
import org.apache.spark.sql.catalyst.plans.logical.{Aggregate, Filter, LogicalPlan, SubqueryAlias}
import org.apache.spark.sql.catalyst.rules.Rule
import org.apache.spark.sql.execution.datasources.LogicalRelation

object HttpPushDownRule extends Rule[LogicalPlan] with LazyLogging{
  def apply(plan: LogicalPlan): LogicalPlan = plan transform {

    case agg@Aggregate(_, aggregateExpressions, child) =>
      findLogicalRelation(child) match {
        case Some(lr@LogicalRelation(rel: HttpFilterRelation, output, catalogTable, isStreaming)) =>
          // 判断聚合表达式是否为简单的 COUNT(1)
          if (isSimpleCount(aggregateExpressions)) {
            // 根据是否有 Filter 节点等构造下推 SQL
            val pushedSql = s"SELECT COUNT(1) AS count FROM ${rel.httpOptions.tableName} ${compileFilters(child)}"
            val newRel = new HttpFilterRelation(Some(pushedSql), rel.httpOptions)(rel.sparkSession)
            LogicalRelation(newRel, output, catalogTable, isStreaming)
          } else {
            logger.info("Come in")
            agg
          }
        case _ =>
          logger.info("Come out")
          agg
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

  // 解包
  private def unwrapCast(expr: Expression): Expression = expr match {
    case Cast(child, _, _) => unwrapCast(child)
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
    case _ =>
      throw new UnsupportedOperationException(s"Unsupported filter expression for pushdown: $expr")
  }
}
