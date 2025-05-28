import com.alibaba.fastjson.JSONObject;
import conf.UdfConf;
import okhttp3.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UDFHttp {
    private static final String APPLICATION_JSON = "application/json; charset=utf-8";
    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(UdfConf.udfApiConnectTimeout(), TimeUnit.SECONDS)
            .readTimeout(UdfConf.udfApiReadTimeout(), TimeUnit.SECONDS)
            .build();

    private static String encode(String params) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (params == null || params.trim().isEmpty()) {
            return "";
        }
        JSONObject json = JSONObject.parseObject(params);
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            sb.append(URLEncoder.encode(String.valueOf(entry.getKey()), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static Map<String, String> getHeaderMap(String params) {
        Map<String, String> map = new HashMap<>();
        if (params == null || params.trim().isEmpty()) return map;
        JSONObject json = JSONObject.parseObject(params);
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            map.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    public String evaluate(String requestUrl, String method, String params, String headerStr, String bodyStr) {
        try {
            String url = requestUrl;
            HttpUrl httpUrl = HttpUrl.parse(requestUrl).newBuilder().build();
            String paramsStr = encode(params);
            if (httpUrl.querySize() == 0) {
                if (requestUrl.endsWith("?")) {
                    url += paramsStr;
                } else {
                    url += "?" + paramsStr;
                }
            } else {
                url += "&" + paramsStr;
            }

            Map<String, String> headersMap = getHeaderMap(headerStr);
            String mediaType = headersMap.get("Content-Type");
            if (mediaType == null) {
                mediaType = APPLICATION_JSON;
                headersMap.put("Content-Type", APPLICATION_JSON);
            }
            RequestBody body = bodyStr == null ? null : RequestBody.create(MediaType.parse(mediaType), bodyStr);
            Request request = new Request.Builder()
                    .url(url)
                    .method(method, body)
                    .headers(Headers.of(headersMap))
                    .build();
            Response response = httpClient
                    .newCall(request)
                    .execute();
            return response.body().string();

        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();//创建json对象
            jsonObject.put("status", 1);
            jsonObject.put("timestamp", new Date().toString());
            jsonObject.put("error", e.getClass().getName());
            jsonObject.put("message", e.getMessage());
            return jsonObject.toJSONString();
        }
    }
}
