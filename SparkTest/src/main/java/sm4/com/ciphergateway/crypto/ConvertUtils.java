package sm4.com.ciphergateway.crypto;

public final class ConvertUtils {
    private static final char[] HEX_UPPER = "0123456789ABCDEF".toCharArray();
    private static final char[] HEX_LOWER = "0123456789abcdef".toCharArray();

    private ConvertUtils() {}

    /* =========================
       bytes -> hex
       ========================= */

    /** 默认输出大写十六进制（无空格、连续字符串）。 */
    public static String bytesToHex(byte[] bytes) {
        return bytesToHex(bytes, 0, bytes == null ? 0 : bytes.length, true);
    }

    /** 指定大小写。upper=true 输出大写，false 输出小写。 */
    public static String bytesToHex(byte[] bytes, boolean upper) {
        return bytesToHex(bytes, 0, bytes == null ? 0 : bytes.length, upper);
    }

    /** 指定区间与大小写。 */
    public static String bytesToHex(byte[] bytes, int off, int len, boolean upper) {
        if (bytes == null) return "";
        if (off < 0 || len < 0 || off + len > bytes.length) {
            throw new IndexOutOfBoundsException("off/len out of range");
        }
        final char[] dict = upper ? HEX_UPPER : HEX_LOWER;
        char[] out = new char[len << 1];
        int p = 0;
        for (int i = 0; i < len; i++) {
            int v = bytes[off + i] & 0xFF;
            out[p++] = dict[v >>> 4];
            out[p++] = dict[v & 0x0F];
        }
        return new String(out);
    }

    /* =========================
       hex -> bytes
       ========================= */

    /**
     * 将十六进制字符串转为字节数组。
     * 规则：
     *  - 忽略所有空白（空格、制表、换行等）
     *  - 允许以 "0x"/"0X" 开头
     *  - 奇数字符或包含非十六进制字符会抛 IllegalArgumentException
     */
    public static byte[] hexStringToBytes(String hex) {
        if (hex == null) return new byte[0];

        // 去掉空白字符
        String s = hex.replaceAll("\\s+", "");
        // 去掉 0x/0X 前缀
        if (s.startsWith("0x") || s.startsWith("0X")) {
            s = s.substring(2);
        }
        if (s.length() == 0) return new byte[0];
        if ((s.length() & 1) != 0) {
            throw new IllegalArgumentException("Hex string length must be even: " + s.length());
        }

        int len = s.length();
        byte[] out = new byte[len >> 1];
        for (int i = 0, j = 0; i < len; i += 2, j++) {
            int hi = hexDigit(s.charAt(i));
            int lo = hexDigit(s.charAt(i + 1));
            if (hi < 0 || lo < 0) {
                throw new IllegalArgumentException("Invalid hex char at pos " + i + ": " + s.charAt(i) + s.charAt(i + 1));
            }
            out[j] = (byte) ((hi << 4) | lo);
        }
        return out;
    }

    /** 只转前 n 个字节对应的 hex（便于调试头部）。 */
    public static String headToHex(byte[] bytes, int n, boolean upper) {
        if (bytes == null) return "";
        int len = Math.min(Math.max(n, 0), bytes.length);
        return bytesToHex(bytes, 0, len, upper);
    }

    /* =========================
       helpers
       ========================= */

    /** 返回 0..15；非法返回 -1。比 Character.digit 更轻量。 */
    private static int hexDigit(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'A' && c <= 'F') return c - 'A' + 10;
        if (c >= 'a' && c <= 'f') return c - 'a' + 10;
        return -1;
    }

}
