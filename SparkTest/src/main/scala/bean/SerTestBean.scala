package bean

import bean.EnumBean.EnumBean

case class SerTestBean(str: String,
                       list: Seq[String],
                       pojoType: Person,
                       bool: Boolean,
                       optionType: Option[String],
                       time: Long,
                       enumType: EnumBean)
