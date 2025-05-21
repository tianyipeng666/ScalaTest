package stringUdf;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UDFStringFunc {

    public static String strFunc(String text, String beginText, String endText){
        int keepBegin = 0;
        int keepEnd = 0;
        Pattern bgnPat = Pattern.compile(beginText);
        Pattern endPat = Pattern.compile(endText);
        Matcher m = bgnPat.matcher(text);
        int begin = -1;
        if (m.find()) {
            begin = keepBegin>0 ? m.start() : m.end();
        }
        if (begin < 0){
            return text;
        }
        Matcher n = endPat.matcher(text);
        int end = -1;
        int pos = begin;
        while (n.find(pos)) {
            end = keepEnd>0 ? n.end() : n.start();
            if (pos == n.end()) break;
            pos = n.end();
        }
        if (end <= begin){
            return text.substring(begin);
        }
        return text.substring(begin, end);
    }

}
