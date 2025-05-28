import utils.DateUtil;

public class UDFDateConvert {

    public static String timeConvertStr(String value1) {
        try {
            Long value = Long.parseLong(value1);
            return DateUtil.dateConvert(value);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String evaluate(String value1, long value2) {
        try {
            Long value = Long.parseLong(value1) / 1000;
            return DateUtil.dateConvert(value);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String timeConvertLong(long value1) {
        if (value1 == 0L) {
            return "";
        }
        return DateUtil.dateConvert(value1);
    }

    public static String evaluate(long value1, long value2) {
        if (value1 == 0L) {
            return "";
        }
        return DateUtil.dateConvert(value1 / 1000);
    }

}
