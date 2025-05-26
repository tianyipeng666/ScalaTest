public class UDFStringSplit {

    public static String strSplit(String str, String pat, long n) {
        try {
            String[] strArr = str.split(pat);
            return strArr[(int)n];
        } catch (Exception e) {
            return null;
        }
    }
}
