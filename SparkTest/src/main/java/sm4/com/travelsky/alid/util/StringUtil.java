//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.travelsky.alid.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class StringUtil {
    private static Logger log = LoggerFactory.getLogger(StringUtil.class);
    private static final String CODES = "0123456789ABCDEF";

    private StringUtil() {
    }

    public static boolean isAlpha(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static String addEqualsSign(String msg) {
        StringBuilder res = new StringBuilder(msg);
        int eqIndex = msg.indexOf("=");
        if (eqIndex == -1 || msg.length() - eqIndex > 20) {
            res.append("\r\n=");
        }

        return res.toString();
    }

    public static boolean isNullOrEmpty(String str) {
        return null == str || str.length() == 0;
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static boolean isContainsWithComma(String string, String item) {
        return isContains(string, item, "\\s+");
    }

    public static boolean isContains(String string, String item, String spliter) {
        if (!isNullOrEmpty(string) && !isNullOrEmpty(item) && !isNullOrEmpty(spliter)) {
            String[] strings = string.split(spliter);
            String[] var4 = strings;
            int var5 = strings.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String s = var4[var6];
                if (item.equals(s)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean isMatch(String str, String regex) {
        return !isNullOrEmpty(str) && !isNullOrEmpty(regex) && str.matches(regex);
    }

    private static char randomChar() {
        Random r = new Random();
        int index = r.nextInt("0123456789ABCDEF".length());
        return "0123456789ABCDEF".charAt(index);
    }

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            sb.append(randomChar());
        }

        return sb.toString();
    }

    public static InputStream getProperties(String filename) throws IOException {
        InputStream input = null;
        String dbPath = "config/" + filename;
        File file = new File(dbPath);
        if (!file.exists()) {
            log.info("from jar read file.");
            input = StringUtil.class.getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                log.info("from class resource read file.");
                URL url = StringUtil.class.getClassLoader().getResource(filename);
                if (url == null) {
                    log.error("db resource db.properties not found.");
                    throw new IllegalArgumentException(String.format("db resource %s not found.", filename));
                }

                input = new FileInputStream(url.getPath());
            }
        } else {
            log.info("from outsite read file.");
            input = new FileInputStream(dbPath);
        }

        return (InputStream)input;
    }
}
