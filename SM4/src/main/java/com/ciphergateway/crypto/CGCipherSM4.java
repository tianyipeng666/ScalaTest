//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ciphergateway.crypto;

public class CGCipherSM4 extends CGCipher {
    private String Model;

    public native byte[] SM4_encrypt(int var1, String var2, byte[] var3, byte[] var4, byte[] var5);

    public native byte[] SM4_decrypt(int var1, String var2, byte[] var3, byte[] var4, byte[] var5);

    public native byte[] SM4_GCMCCM_Encrypt(String var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5);

    public native byte[] SM4_GCMCCM_Decrypt(String var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5);

    public CGCipherSM4(String model) {
        if (!model.equalsIgnoreCase("ecb") && !model.equalsIgnoreCase("cbc") && !model.equalsIgnoreCase("ctr") && !model.equalsIgnoreCase("gcm") && !model.equalsIgnoreCase("ofb")) {
            throw ErrorCode.invalid_algorithm("sm4 algType input error, please input ecb||cbc||ctr||gcm||ofb");
        } else {
            this.Model = model;
        }
    }

    public byte[] sm4_encrypt(int padding, byte[] input, byte[] keys, byte[] iv) {
        if (padding != 0 && padding != 1) {
            throw ErrorCode.invalid_algorithm("sm4 padding input error, please input CGCipher.NO_PADDING or CGCipher.PKCS_PADDING");
        } else if (input != null && input.length != 0) {
            if (keys != null && keys.length == 16) {
                if (iv != null && iv.length != 0) {
                    if (!this.Model.equalsIgnoreCase("ecb") && !this.Model.equalsIgnoreCase("cbc") && !this.Model.equalsIgnoreCase("ctr") && !this.Model.equalsIgnoreCase("ofb")) {
                        throw ErrorCode.invalid_algorithm("sm4 algType input error, please input ecb||cbc||ctr||ofb");
                    } else if (padding == 0 && (this.Model.equalsIgnoreCase("ecb") || this.Model.equalsIgnoreCase("cbc")) && input.length % 16 != 0) {
                        throw ErrorCode.invalid_algorithm("sm4 plain input error, padding please choose CGCipher.PKCS_PADDING");
                    } else {
                        return this.SM4_encrypt(padding, this.Model, input, keys, iv);
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm4 iv input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm4 key input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm4 plain input error");
        }
    }

    public byte[] sm4_decrypt(int padding, byte[] input, byte[] keys, byte[] iv) {
        if (padding != 0 && padding != 1) {
            throw ErrorCode.invalid_algorithm("sm4 padding input error, please input CGCipher.NO_PADDING or CGCipher.PKCS_PADDING");
        } else if (input != null && input.length != 0) {
            if (keys != null && keys.length == 16) {
                if (iv != null && iv.length != 0) {
                    if (!this.Model.equalsIgnoreCase("ecb") && !this.Model.equalsIgnoreCase("cbc") && !this.Model.equalsIgnoreCase("ctr") && !this.Model.equalsIgnoreCase("ofb")) {
                        throw ErrorCode.invalid_algorithm("sm4 algType input error, please input ecb||cbc||ctr||ofb");
                    } else if (padding == 0 && (this.Model.equalsIgnoreCase("ecb") || this.Model.equalsIgnoreCase("cbc")) && input.length % 16 != 0) {
                        throw ErrorCode.invalid_algorithm("sm4 cipher input error, padding please choose CGCipher.PKCS_PADDING");
                    } else {
                        return this.SM4_decrypt(padding, this.Model, input, keys, iv);
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm4 iv input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm4 key input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm4 cipher input error");
        }
    }

    public byte[] sm4_gcm_encrypt(byte[] input, byte[] keys, byte[] iv, byte[] aad) {
        if (input != null && input.length != 0) {
            if (keys != null && keys.length == 16) {
                if (iv != null && iv.length != 0) {
                    if (!this.Model.equalsIgnoreCase("gcm")) {
                        throw ErrorCode.invalid_algorithm("sm4 algType input error, please input gcm");
                    } else {
                        return this.SM4_GCMCCM_Encrypt(this.Model, input, keys, iv, aad);
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm4 iv input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm4 key input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm4 plain input error");
        }
    }

    public byte[] sm4_gcm_decrypt(byte[] input, byte[] keys, byte[] iv, byte[] aad) {
        if (input != null && input.length != 0) {
            if (keys != null && keys.length == 16) {
                if (iv != null && iv.length != 0) {
                    if (!this.Model.equalsIgnoreCase("gcm")) {
                        throw ErrorCode.invalid_algorithm("sm4 algType input error, please input gcm");
                    } else {
                        return this.SM4_GCMCCM_Decrypt(this.Model, input, keys, iv, aad);
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm4 iv input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm4 key input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm4 plain input error");
        }
    }
}
