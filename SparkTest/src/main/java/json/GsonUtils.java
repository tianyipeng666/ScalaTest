package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtils {

    private static Gson gson = new Gson();

    public static String toJSONString(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> List<T> parseList(Object obj, Class<T> clazz) {
        // new TypeToken<List<T>>() {}.getType(), 通过该方式转换获取到的list封装为linkedTreeMap，遍历获取值时会报com.google.gson.internal.LinkedTreeMap cannot be cast to
        // return gson.fromJson(gson.toJson(obj), new TypeToken<List<T>>() {}.getType());
        Type listType = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, clazz);
        return gson.fromJson(gson.toJson(obj), listType);
    }
}
