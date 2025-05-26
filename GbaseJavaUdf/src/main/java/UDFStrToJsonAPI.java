import com.alibaba.fastjson.JSONObject;

public class UDFStrToJsonAPI {

    public static String str2json(String... args) {
        JSONObject jsonObject = new JSONObject();//创建json对象
        int length = args.length;
        for (int i = 0; i < args.length; ) {
            if (length % 2 == 1) {   //是奇数
                if (length - 1 != i) {
                    try {
                        jsonObject.put(args[i], args[i + 1]);//拼接数据
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jsonObject.put(args[i], "");//拼接数据
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {  //是偶数
                try {
                    jsonObject.put(args[i], args[i + 1]);//拼接数据
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i = i + 2;
        }
        return jsonObject.toString();
    }

}
