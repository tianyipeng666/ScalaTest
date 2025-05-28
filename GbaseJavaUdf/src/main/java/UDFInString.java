import utils.StringUtil;

public class UDFInString {

    public static long inStr2Params(String str, String sub) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, 0, 0, 1);
    }

    public static long inStr3Params(String str, String sub, long start) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, (int) start, 0, 1);
    }

    public static long inStr4Params(String str, String sub, long start, long seq, long count) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, (int) start, (int) seq, (int) count);
    }
}
