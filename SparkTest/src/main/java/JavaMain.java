import bean.FieldInfo;
import bean.FieldInfo2;
import collect.JavaCollectUtils;
import json.GsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaMain {
    public static void main(String[] args) {
        jsonDispose();
    }

    public static void collectDispose() {

    }

    public static void jsonDispose() {
        ArrayList<FieldInfo> list = new ArrayList<FieldInfo>();
        list.add(new FieldInfo("AAA", "AAA", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("BBB", "BBB", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("CCC", "CCC", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("DDD", "DDD", true, new HashMap<String, Object>()));
        List<FieldInfo2> fieldInfo2s = GsonUtils.parseList(list, FieldInfo2.class);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (FieldInfo2 fieldInfo2 : fieldInfo2s) {
            resultMap.put(fieldInfo2.getName(),"");
        }
        System.out.println(fieldInfo2s);
        System.out.println(resultMap);
    }
}
