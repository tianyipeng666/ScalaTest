import collect.JavaCollectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaMain {
    public static void main(String[] args) {
        collectDispose();
    }

    public static void collectDispose() {
        ArrayList<String[]> list = new ArrayList<>();
        String[] a = {"1", "2"};
        list.add(a);
        list.add(a);
        System.out.println(JavaCollectUtils.getSpecialIndexList(list, 0));
    }
}
