package bean

import bean.EnumBean.EnumBean
import bean.EnumJava

case class SerTestBean(str: String,
                       list: Seq[String],
                       pojoType: Person,
                       bool: Boolean,
                       optionType: Option[String],
                       time: Long,
                       enumType: EnumBean,
                       enmJavaType: EnumJava)
