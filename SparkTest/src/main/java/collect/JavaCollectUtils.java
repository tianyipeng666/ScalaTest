package collect;

import java.util.List;
import java.util.stream.Collectors;

public class JavaCollectUtils {

    public static List<String> getSpecialIndexList(List<String[]> list, Integer index) {
        // stream流类似scala处理方式
        List<String> collect = list.stream().map(v -> v[index]).collect(Collectors.toList());
       return collect;
    }
}
