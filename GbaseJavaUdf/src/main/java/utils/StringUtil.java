package utils;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {

    public static int getIndex(String str, String sub, int index, int seq, int count){
        if(str.length()==0 || sub.length()== 0)
            return 0;
        if(Math.abs(index) > str.length())
            return 0;
        if(seq!=0 && seq!= 1)
            return 0;
        if(count <= 0)
            return 0;

        if(index < 0){
            index = str.length() + index ;
            if(seq == 1)
                index+=1;
        }
        else {
            index -= 1;
        }
        for(int i = 0; i < count ; i++){
            if(seq == 0){
                index = str.indexOf(sub,index+1);
            }
            else {
                index = str.lastIndexOf(sub, index-1);
            }
            if(index == -1)
                    return 0;
        }
        return index +1 ;
    }

    public static int getIndex(String str, String sub, int start){
        // src.position(start) can't accept negative numbers.
        int length = str.length() - start;
        if (start < 0 || length < 0 || length < sub.length()) {
            return 0;
        }
        if (sub.length() == 0) {
            return 0;
        }
        if (length == 0) {
            return 0;
        }

        int index = str.indexOf(sub, start);
        return index + 1;
    }

    public static ArrayList<String> urlKeys(String url) {
        if (url == null) {
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<String>();

        try {
            URL urlObj = new URL(url);
            String query = urlObj.getQuery();
            String[] params = query.split("&");
            for (String param : params) {
                String name = param.split("=")[0];
                res.add(name);
            }
        } catch (Exception e) {
            return res;
        }
        return res;
    }

    public static String parseUrl(String inputUrl, String obj, String... args) throws UnsupportedEncodingException,MalformedURLException {
        if (inputUrl == null) {
            return inputUrl;
        }
        inputUrl = StringUtil.validURL(inputUrl);

        URL aURL = new URL(inputUrl);

        switch (obj.toLowerCase()) {
            case "protocol":
                return aURL.getProtocol();
            case "host":
                return aURL.getHost();
            case "port":
                return aURL.getPort() + "";
            case "path":
                return aURL.getPath();
            case "query":
                if (args.length < 1) {
                    return URLDecoder.decode(aURL.getQuery(), "UTF-8");
                } else {
                    String query = aURL.getQuery();
                    String key = args[0];
                    for (String pair : query.split("&")) {
                        if (pair.contains("=")) {
                            int idx = pair.indexOf("=");
                            String k = pair.substring(0, idx);
                            if (k.equals(key)) {
                                return URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
                            }
                        }
                    }
                    return null;
                }
            case "REF":
                return aURL.getRef();
            default:
                return null;
        }
    }

    private static String validURL(String inputUrl) {
        inputUrl = inputUrl.replace("%23", "#");
        inputUrl = inputUrl.replace("%3f", "?");
        inputUrl = inputUrl.replace("%26", "&");
        inputUrl = inputUrl.replace("?", "&");
        inputUrl = inputUrl.replace("#", "&");
        inputUrl = inputUrl.replaceFirst("&", "?");
        return inputUrl;
    }

    public static int decimalPrecision(double value){
        value = value + 1d;
        if ((int)value == value){
            return 0;
        }
        String[] s = String.valueOf(value).split("\\.");
        return s[s.length - 1].length();
    }

    public static String formatDecimal(double number, int digits, boolean isMillesimal) {
        StringBuilder a = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            if (i == 0)
                a.append(".");

            a.append("0");
        }

        DecimalFormat df;
        if (isMillesimal) {
            df = new DecimalFormat(",###" + a.toString());
        } else {
            df = new DecimalFormat("#" + a.toString());
        }

        return df.format(number);
    }

    private static boolean isValidKeywordString(String keyword) {
        char[] c = keyword.toCharArray();

        for(int i = 0; i < c.length; i++){
            if ((int)c[i] > 127) {
                return false;
            }
        }
        return true;
    }

    public static String getValueFromURL(String urls[], String keys[]) {
        // SEM里从网址里提取关键词ID(或者创意ID)的通用方法
        // 逻辑是 从url1里拿key1的值,拿不到则从url2里拿key1,再拿不到就从url1里拿key2的值,再拿不到就拿url2里的key2的值
        String res;
        try {
            for (String url : urls) {
                if (StringUtils.isBlank(url))
                    continue;
                for (String key : keys) {
                    try {
                        res = StringUtil.parseUrl(url, "QUERY", key);
                        if (StringUtils.isNotBlank(res))
                            return res;
                    } catch (Exception ae) {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static String getKeywordFromURL(String urls[], String keys[]) {
        String res = StringUtil.getValueFromURL(urls, keys);
        if (StringUtils.isNotBlank(res) && !res.equals("{keywordid}") && StringUtil.isValidKeywordString(res))
            return res;

        // 正则提取
        Pattern p = Pattern.compile("[&#/\\?](\\w{2,3}-\\w+)&");
        for (String url : urls) {
            if (StringUtils.isBlank(url))
                continue;
            Matcher match = p.matcher(url);
            if (match.find()){
                return match.group(1);
            }
        }
        return null;
    }

}
