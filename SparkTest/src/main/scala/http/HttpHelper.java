package http;

import okhttp3.OkHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HttpHelper {

    // http早期实现版本
    public String send(String url, ArrayList<NameValuePair> param) throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8));
        CloseableHttpResponse res = client.execute(post);
        HttpEntity entity = res.getEntity();
        String data = "empty";
        //获取返回内容
        if (entity != null) {
            data = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        }
        client.getConnectionManager().shutdown();
        return data;
    }

    public String sendNew(String url, ArrayList<NameValuePair> param) throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(param, HTTP.UTF_8));
        CloseableHttpResponse res = client.execute(post);
        HttpEntity entity = res.getEntity();
        String data = "empty";
        //获取返回内容
        if (entity != null) {
            data = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        }
        client.getConnectionManager().shutdown();
        return data;
    }

}
