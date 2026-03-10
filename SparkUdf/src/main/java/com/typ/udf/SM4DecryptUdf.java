package com.typ.udf;


import com.typ.utils.SM4DecryptUtil;
import org.apache.spark.sql.api.java.UDF1;

// sm4_decrypt(str, str) -> 按照对应密钥解密密文
public class SM4DecryptUdf {

    public static void main(String[] args) {
        // 填入密文
        System.out.println(call(""));
    }

    public static  String call(String encryptedData) {
        SM4DecryptUtil decipher = new SM4DecryptUtil();
        // 填入密钥
        String keyHex = "";
        SM4DecryptUtil.CipherMode mode = SM4DecryptUtil.CipherMode.ECB;
        SM4DecryptUtil.CipherPadding padding = SM4DecryptUtil.CipherPadding.PKCS7;
        String ivHex = null;

       return decipher.decrypt(encryptedData, keyHex, mode, padding, ivHex);

    }

}
