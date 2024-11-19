package pattern;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {

    public static void main(String[] args) {
        // 匹配
        boolean b = Pattern.matches("(\\d+|\\d+\\s*,\\s*\\d+)", "10 , 10)");
        System.out.println(b);
        // 抽取
        System.out.println(patternMatch("10 , 30", "(\\d+|\\d+\\s*,\\s*\\d+)"));

        boolean c = Pattern.matches("\\*+", "***a***");
        System.out.println(c);

    }

    public static ArrayList<Object> patternMatch(String patternStr, String regex) {
        // 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(patternStr);

        ArrayList<Object> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(0));
        }

        return list;
    }

}
