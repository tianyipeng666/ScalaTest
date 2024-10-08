package string;

public class StringTransformUtils {

    public static void main(String[] args) {
        getLastSubString("sss limit 12 34 limit ttt limit 555", "LIMIT");
    }

    public static void getLastSubString(String str, String subStr) {
        int lastIndex = str.toUpperCase().lastIndexOf(subStr);
        System.out.println(str.substring(0, lastIndex));
        System.out.println(str.substring(lastIndex + 4));
    }

}
