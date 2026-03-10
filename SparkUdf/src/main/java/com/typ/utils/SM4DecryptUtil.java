package com.typ.utils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.SM4Engine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Hex;


public class SM4DecryptUtil {

    // 加密模式枚举
    public enum CipherMode {
        ECB, CBC
    }

    // 填充方式枚举
    public enum CipherPadding {
        PKCS7, ZERO
    }

    /**
     * SM4解密核心方法
     */
    public static String decrypt(String cipherTextHex, String keyHex,
                                CipherMode mode, CipherPadding padding, String ivHex) {
        // 1. 基础参数验证
        if (!isValidHex(cipherTextHex)) {
        	 return ("错误：解密过程异常：" );
        }
        if (!isValidHex(keyHex)) {
        	 return ("错误：解密过程异常：");
        }

        // 2. 验证密钥长度
        int keyBitLength = keyHex.length() * 4;
        if (keyBitLength != 128 && keyBitLength != 192 && keyBitLength != 256) {
        	 return ("错误：解密过程异常：");
        }

        // 3. CBC模式IV验证
        if (mode == CipherMode.CBC) {
            if (ivHex == null || !isValidHex(ivHex) || ivHex.length() != 32) {
            	 return ("错误：解密过程异常：");
            }
        }

        try {
            // 4. 选择填充方式（Java 8兼容写法）
            BlockCipherPadding blockPadding;
            switch (padding) {
                case PKCS7:
                    blockPadding = new PKCS7Padding();
                    break;
                case ZERO:
                    blockPadding = new ZeroBytePadding();
                    break;
                default:
                    throw new IllegalArgumentException("错误：不支持的填充方式: " + padding);
            }

            // 5. 初始化SM4引擎和加密模式，并结合填充方式
            PaddedBufferedBlockCipher cipher;
            if (mode == CipherMode.ECB) {
                // ECB模式：直接使用SM4引擎 + 填充方式
                cipher = new PaddedBufferedBlockCipher(new SM4Engine(), blockPadding);
            } else {
                // CBC模式：使用CBC包装的SM4引擎 + 填充方式
                cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new SM4Engine()), blockPadding);
            }

            // 6. 准备密钥和参数
            byte[] keyBytes = Hex.decode(keyHex);
            CipherParameters cipherParams;

            if (mode == CipherMode.CBC) {
                byte[] ivBytes = Hex.decode(ivHex);
                cipherParams = new ParametersWithIV(new KeyParameter(keyBytes), ivBytes);
            } else {
                cipherParams = new KeyParameter(keyBytes);
            }

            // 7. 初始化解密器
            cipher.init(false, cipherParams);

            // 8. 执行解密
            byte[] cipherTextBytes = Hex.decode(cipherTextHex);
            byte[] outputBuffer = new byte[cipher.getOutputSize(cipherTextBytes.length)];
            int processedLen = cipher.processBytes(cipherTextBytes, 0, cipherTextBytes.length, outputBuffer, 0);
            int finalLen = cipher.doFinal(outputBuffer, processedLen);

            // 9. 处理解密结果
            byte[] plainTextBytes = Arrays.copyOf(outputBuffer, processedLen + finalLen);
            return new String(plainTextBytes, StandardCharsets.UTF_8);

        } catch (org.bouncycastle.crypto.InvalidCipherTextException e) {
            String errorDetail = "错误：填充验证失败，可能原因：\n";
            errorDetail += "1. 密钥与加密端不一致；\n";
            errorDetail += "2. 加密模式与加密端不一致；\n";
            errorDetail += "3. 填充方式与加密端不一致；\n";
            errorDetail += "4. 密文被篡改或不完整。";
            return ("错误：解密过程异常：" + e.getMessage());
        } catch (Exception e) {
            return ("错误：解密过程异常：" + e.getMessage());
        }
    }

    /**
     * 验证十六进制字符串有效性
     */
    private static boolean isValidHex(String hexStr) {
        if (hexStr == null || hexStr.isEmpty()) return false;
        if (hexStr.length() % 2 != 0) return false;
        return hexStr.matches("^[0-9a-fA-F]+$");
    }
}
    