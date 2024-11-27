package collect;

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
}
