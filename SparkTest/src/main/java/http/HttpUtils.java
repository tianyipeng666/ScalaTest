package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.lianjiatech.retrofit.spring.boot.exception.ReadResponseBodyException;
import com.github.lianjiatech.retrofit.spring.boot.util.RetrofitUtils;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    public static void main(String[] args) throws Exception {
        JSONObject toMo = new JSONObject();
        toMo.put("sql", String.format("select * from %s.%s limit 1", "bdp", "z8cb4be38af1481aa82172987fc01325"));
        JSONObject res = JSON.parseObject(doPostForm("http://192.168.1.166:44120/db/query", toMo));
        System.out.println(res.getString("status"));
        System.out.println(res.getJSONArray("schema").toString());
    }

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.MINUTES)
            .build();

    public static String doPostForm(String url, JSONObject params) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()){
            builder.add(key, params.getString(key));
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        return execute(request);
    }

    private static String execute(Request request) throws IOException {
        okhttp3.Response execute = httpClient.newCall(request).execute();
        try {
            return RetrofitUtils.readResponseBody(execute);
        } catch (ReadResponseBodyException e) {
            e.printStackTrace();
            return null;
        }
    }
}
