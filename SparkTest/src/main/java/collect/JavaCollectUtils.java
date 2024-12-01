package collect;

import bean.FieldInfo3;
import org.apache.parquet.format.Util;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectUtils {

    // 列表
    public static List<String> getSpecialIndexList(List<String[]> list, Integer index) {
        // stream流类似scala处理方式
        List<String> collect = list.stream().map(v -> v[index]).collect(Collectors.toList());
       return collect;
    }

    // 数组
    public static List<String> getSpecialIndexDyadicArray(Object[][] objArr, Integer index) {
        List<String> collect = Arrays.stream(objArr).map(v -> v[index].toString()).collect(Collectors.toList());
        return collect;
    }

    // StringBuilder
    public static String getTransformString(StringBuilder baseBuilder, List<String> list) {
        StringBuilder addBuilder = new StringBuilder();
        for (String elem : list) {
//            String.format("%s %s comment '%s',",
//                    fieldSchema.getName(),
//                    fieldSchema.getDataType(),
//                    (fieldSchema.getComments() == null || fieldSchema.getComments().isEmpty()) ? "" : fieldSchema.getComments())
            addBuilder.append(elem + " String,");
        }
        addBuilder.deleteCharAt(addBuilder.length() - 1);
        baseBuilder.append("add columns (" + addBuilder + ")");
        return baseBuilder.toString();
    }

    public static String getSpecialDelimiterSplitStr(List<String> list, String delimiter) {
        return list.stream().collect(Collectors.joining(delimiter));
    }

    // 列表
    public static List<String> getStringList(List<FieldInfo3> list) {
        // stream流类似scala处理方式
        // import scala.jdk.CollectionConverters._
        // scala：val names: List[String] = javaList.asScala.toList.map(_.name)
        List<String> collect = list.stream().map(FieldInfo3::getName).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        FieldInfo3 a = new FieldInfo3("typ", 30, false);
        FieldInfo3 b = new FieldInfo3("typ", 30, false);
        FieldInfo3 c = new FieldInfo3("typ", 30, false);
        ArrayList<FieldInfo3> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(getStringList(list));
    }
}
