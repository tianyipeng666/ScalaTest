package com.typ.udf

import org.apache.hadoop.hive.ql.exec.UDF

class UDFIpPrefix extends UDF {
  // ip_prefix('192.168.1.100') -> '192.168.1'
  def evaluate(ip: String): String = {
    if (ip == null) return null
    val parts = ip.split("\\.")
    if (parts.length < 3) return ip
    parts(0) + "." + parts(1) + "." + parts(2)
  }
}
