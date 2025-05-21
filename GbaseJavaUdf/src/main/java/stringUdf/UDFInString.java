package stringUdf;


public class UDFInString {

    public static int inStr2Params(String str, String sub) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, 0, 0, 1);
    }

    public static int inStr3Params(String str, String sub, int start) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, start, 0, 1);
    }

    public static int inStr4Params(String str, String sub, int start, int seq, int count) {
        if (str == null || sub == null) {
            return 0;
        }
        return StringUtil.getIndex(str, sub, start, seq, count);
    }
}
