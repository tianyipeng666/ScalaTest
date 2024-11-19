package string;

import java.util.ArrayList;

public class StringTransformUtils {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        Object obj = list;
        ArrayList<Object> list1 = (ArrayList<Object>) obj;
        System.out.println(Integer.parseInt(list1.get(0).toString()));
    }

    public static void getLastSubString(String str, String subStr) {
        int lastIndex = str.toUpperCase().lastIndexOf(subStr);
        System.out.println(str.substring(0, lastIndex));
        System.out.println(str.substring(lastIndex + 4));
    }

}
