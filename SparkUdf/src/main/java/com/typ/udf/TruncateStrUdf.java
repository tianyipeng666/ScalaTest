package com.typ.udf;


import org.apache.spark.sql.api.java.UDF2;

// truncate_str(str, len) -> 把 str 截断到 len 长度
public class TruncateStrUdf implements UDF2<String, Integer, String> {
    @Override
    public String call(String s, Integer len) {
        if (s == null || len == null || len <= 0) return null;
        return s.length() <= len ? s : s.substring(0, len);
    }
}
