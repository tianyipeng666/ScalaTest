package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class FastJsonUtils {

    public static void main(String[] args) {
        String configStr = "{\n" +
                "    \"sinks\":[\n" +
                "        {\n" +
                "            \"config\":{\n" +
                "                \"unit\":2,\n" +
                "                \"tbName\":\"dadc39ca1b984222a658377f347ad30f\",\n" +
                "                \"keep\":-1,\n" +
                "                \"type\":\"hdfs\"\n" +
                "            },\n" +
                "            \"isUsing\":1,\n" +
                "            \"status\":2,\n" +
                "            \"jobKey\":\"job_c8e4a182a4d440639cd57f826636c686\",\n" +
                "            \"jobName\":\"export_fa8b781ac7b74af19f02562c481a9743\",\n" +
                "            \"streamingId\":null\n" +
                "        },\n" +
                "        {\n" +
                "            \"config\":{\n" +
                "                \"tbName\":\"df972ef241ab4b32b0d0ebb91868031f\",\n" +
                "                \"type\":\"kafka\",\n" +
                "                \"topic\":\"typ_df972ef241ab4b32b0d0ebb91868031f\"\n" +
                "            },\n" +
                "            \"isUsing\":1,\n" +
                "            \"status\":1,\n" +
                "            \"jobKey\":\"\",\n" +
                "            \"jobName\":\"\",\n" +
                "            \"streamingId\":null\n" +
                "        }\n" +
                "    ],\n" +
                "    \"triggerTimeS\":3,\n" +
                "    \"startFromEarliest\":1\n" +
                "}";
        parseJsonPath(configStr);
    }

    public static void parseJsonPath(String configStr) {
        JSONArray configArr = (JSONArray) JSONPath.eval(JSON.parseObject(configStr),
                "$.sinks[*].config[?(@.type == 'kafka')]");
        System.out.println(configArr);
        JSONObject kafkaConfig = configArr.getJSONObject(0);
        System.out.println(kafkaConfig);
        String topic = kafkaConfig.getString("topic");
        if (topic == null || topic.isEmpty()) {
            topic = kafkaConfig.getString("tbName");
        }
        System.out.println(topic);
    }
}
