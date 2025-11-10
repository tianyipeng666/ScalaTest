package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FastJsonUtils {

    public static String configStr = "{\n" +
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

    public static void main(String[] args) throws IOException{
        //parseJsonPath(configStr);
        generateJsonFile();
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

    public static void generateJsonFile() throws IOException{
        Path out = Paths.get("data/fastjson_records.txt");

        // 创建父目录（若不存在）
        if (out.getParent() != null) {
            Files.createDirectories(out.getParent());
        }

        // 以 UTF-8 编码写入，覆盖已存在文件
        try (BufferedWriter writer = Files.newBufferedWriter(
                out,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            // 生成 10 条记录，每条包含 5 个 String 字段
            for (int i = 1; i <= 10; i++) {
                JSONObject obj = new JSONObject(true); // true 保持插入顺序
                for (int k = 1; k <= 5; k++) {
                    obj.put("key" + k, "value_" + i + "_" + k);
                }
                // 写成一行 JSON（NDJSON）
                writer.write(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
                writer.newLine();
            }
        }

        System.out.println("Done. File written to: " + out.toAbsolutePath());
    }
}
