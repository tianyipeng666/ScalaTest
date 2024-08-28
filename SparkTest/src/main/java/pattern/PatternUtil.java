package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {

    public static void main(String[] args) {
        // 示例SQL语句
        String sql = "SELECT * FROM orders WHERE id = 1; "
                + "SELECT * FROM customers WHERE country = 'US';";

        // 正则表达式匹配表名（假设表名由字母、数字和下划线组成，并且不以数字开头）
        String regex = "(?i)\\s+FROM\\s+(\\w+)\\s+WHERE";

        // 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(sql);

        // 替换操作
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // 给匹配到的表名添加库名
            String tableName = matcher.group(1);
            matcher.appendReplacement(sb, matcher.group(0).replace(tableName, "typ." + tableName));
        }
        matcher.appendTail(sb);

        // 输出替换后的SQL语句
        String updatedSql = sb.toString();
        System.out.println(updatedSql);
    }
}
