//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.travelsky.alid.util;

import com.ciphergateway.crypto.CGCipher;
import com.ciphergateway.crypto.ConvertUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import javax.xml.bind.DatatypeConverter;

public class SM4Util {

    private static final boolean DEBUG =
            Boolean.parseBoolean(System.getProperty("sm4.debug", "true"));
    private static byte[] KEYS = new byte[]{-2, -1, -23, -110, -122, 101, 115, 28, 109, 106, -113, -108, 103, 48, -125, 8};
    private static byte[] IV = new byte[]{-103, -86, 62, 104, -19, -127, 115, -96, -18, -48, 102, -124, -18, -48, 102, -124};

    public SM4Util() {
    }

    public static String encrypt(String content, String keyHex, String ivHex, String mode) {
        CGCipher sm4 = CGCipher.getInstance("sm4", mode);
        byte[] input = DatatypeConverter.parseHexBinary(content);
        byte[] cipher = sm4.sm4_encrypt(1, input, DatatypeConverter.parseHexBinary(keyHex), DatatypeConverter.parseHexBinary(ivHex));
        return cipher == null ? null : DatatypeConverter.printHexBinary(cipher);
    }

    public static String decrypt(String content, String keyHex, String ivHex, String mode) {
        CGCipher sm4 = CGCipher.getInstance("sm4", mode);
        byte[] input = DatatypeConverter.parseHexBinary(content);
        byte[] plain = sm4.sm4_decrypt(1, input, DatatypeConverter.parseHexBinary(keyHex), DatatypeConverter.parseHexBinary(ivHex));
        return plain == null ? null : DatatypeConverter.printHexBinary(plain);
    }

//    public static InputStream decryptProperties(InputStream input) throws IOException {
//        if (input == null) {
//            return null;
//        } else {
//            ByteArrayOutputStream byteos = new ByteArrayOutputStream();
//            CGCipher sm4 = CGCipher.getInstance("SM4", "CBC");
//            // byte[] tbuffer = new byte[4112];
//            byte[] tbuffer = new byte[4096];
//            int readNum;
//            while((readNum = input.read(tbuffer)) != -1) {
//                byte[] buffer = Arrays.copyOf(tbuffer, readNum);
//                byte[] temp = sm4.sm4_decrypt(1, buffer, KEYS, IV);
//                byteos.write(temp, 0, temp.length);
//            }
//
//            byteos.flush();
//            input.close();
//            return new ByteArrayInputStream(byteos.toByteArray());
//        }
//    }

//    public static InputStream decryptProperties(InputStream in) throws IOException {
//        if (in == null) return null;
//
//        final String ALGO = "SM4";
//        final String MODE = "CBC";        // 你的实际模式
//        final int PADDING_PKCS7 = 1;      // 你们 JNI 约定：1=PKCS7/PKCS5
//
//        CGCipher sm4 = CGCipher.getInstance(ALGO, MODE);
//
//        byte[] buf = new byte[4096];
//        int n;
//        Boolean firstBlock = true;
//
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            while ((n = in.read(buf)) != -1) {
//                byte[] chunk = (n == buf.length) ? buf : java.util.Arrays.copyOf(buf, n);
//                if (firstBlock) {
//                    dumpArgs(MODE, PADDING_PKCS7, KEYS, IV, chunk);
//                    firstBlock = false;
//                }
//                byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, chunk, KEYS, IV);
//                out.write(plain);
//            }
//            out.flush();
//            return new ByteArrayInputStream(out.toByteArray());
//        }
//    }

    public static InputStream decryptProperties(InputStream in) throws IOException {
        if (in == null) return null;

        byte[] raw = readAll(in);
        if (DEBUG) {
            System.out.printf("[SM4] rawLen=%d rawHead=%s%n",
                    raw.length, ConvertUtils.bytesToHex(head(raw, 32)));
        }

        // 尝试识别并解码文本形式（HEX/Base64）
        byte[] cipher = decodeIfText(raw);
        if (DEBUG) {
            System.out.printf("[SM4] cipherLen=%d cipherHead=%s%n",
                    cipher.length, ConvertUtils.bytesToHex(head(cipher, 32)));
        }

        // CBC+PKCS7：整体长度必须是 16 的倍数
        if ((cipher.length & 0x0F) != 0) {
            throw new IllegalArgumentException(
                    "Cipher length must be multiple of 16, but was " + cipher.length);
        }

        final String MODE = "CBC";
        final int PADDING_PKCS7 = 1; // 你们 JNI 约定

        if (DEBUG) {
            System.out.printf("[SM4] mode=%s padding=%d key=%d iv=%d in=%d%n",
                    MODE, PADDING_PKCS7,
                    KEYS == null ? -1 : KEYS.length,
                    IV   == null ? -1 : IV.length,
                    cipher.length);
            // 如不想泄露，可只打前 4/后 4 个字节
            System.out.println("[SM4] keyHeadTail=" + mask(ConvertUtils.bytesToHex(KEYS)));
            System.out.println("[SM4] ivHeadTail =" + mask(ConvertUtils.bytesToHex(IV)));
            System.out.println("[SM4] inHead     =" + ConvertUtils.bytesToHex(head(cipher, 32)));
        }

        CGCipher sm4 = CGCipher.getInstance("SM4", MODE);
        byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, cipher, KEYS, IV);

        if (DEBUG) {
            System.out.printf("[SM4] plainLen=%d plainHead=%s%n",
                    plain.length, ConvertUtils.bytesToHex(head(plain, 32)));
        }

        return new ByteArrayInputStream(plain);
    }

    /* ============ helpers ============ */

    private static byte[] readAll(InputStream in) throws IOException {
        byte[] buf = new byte[4096];
        int n;
        try (java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream()) {
            while ((n = in.read(buf)) != -1) out.write(buf, 0, n);
            return out.toByteArray();
        }
    }

    /** 如果是 HEX/Base64 文本，先解码成二进制；否则直接返回原始字节 */
    private static byte[] decodeIfText(byte[] raw) {
        String txt;
        try { txt = new String(raw, java.nio.charset.StandardCharsets.UTF_8).trim(); }
        catch (Exception e) { txt = null; }

        if (txt == null || txt.isEmpty()) {
            if (DEBUG) System.out.println("[SM4] treat as BINARY");
            return raw;
        }
        String s = txt.replaceAll("\\s+", "");
        if (s.startsWith("0x") || s.startsWith("0X")) s = s.substring(2);

        if (s.matches("(?i)[0-9a-f]+")) {
            if (DEBUG) System.out.println("[SM4] detect HEX text -> decode");
            return ConvertUtils.hexStringToBytes(s);
        }
        try {
            if (DEBUG) System.out.println("[SM4] try BASE64 -> decode");
            return java.util.Base64.getMimeDecoder().decode(txt);
        } catch (IllegalArgumentException ignore) {
            if (DEBUG) System.out.println("[SM4] treat as BINARY (not hex/base64)");
            return raw;
        }
    }

    private static byte[] head(byte[] a, int n) {
        if (a == null) return new byte[0];
        int len = Math.min(Math.max(n, 0), a.length);
        return java.util.Arrays.copyOf(a, len);
    }

    private static String mask(String hex) {
        if (hex == null || hex.length() <= 8) return hex;
        return hex.substring(0, 8) + "..." + hex.substring(hex.length() - 8);
    }

    private static void dumpArgs(String mode, int padding, byte[] key, byte[] iv, byte[] input) {
        System.out.printf("[SM4] mode=%s padding=%d key=%d iv=%d in=%d%n",
                mode, padding, key==null?-1:key.length, iv==null?-1:iv.length, input.length);
        System.out.println("[SM4] key="+ ConvertUtils.bytesToHex(key));
        System.out.println("[SM4] iv ="+(iv==null?"null":ConvertUtils.bytesToHex(iv)));
        System.out.println("[SM4] in0="+ConvertUtils.bytesToHex(java.util.Arrays.copyOf(input, Math.min(32, input.length))));
    }
}
