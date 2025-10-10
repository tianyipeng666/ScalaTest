//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

public class CGCipherSM2 extends CGCipher {
    public CGCipherSM2() {
    }

    public native byte[] SM2_genkey();

    public native byte[] SM2_encrypt(int var1, byte[] var2, byte[] var3);

    public native byte[] SM2_decrypt(int var1, byte[] var2, byte[] var3);

    public native byte[] SM2_sign(int var1, byte[] var2, byte[] var3, byte[] var4);

    public native int SM2_verify(int var1, byte[] var2, byte[] var3, byte[] var4);

    public native long Set_ec_key(byte[] var1, byte[] var2);

    public native byte[] SM2_struct_encrypt(int var1, long var2, byte[] var4);

    public native byte[] SM2_struct_decrypt(int var1, long var2, byte[] var4);

    public native byte[] SM2_struct_sign(int var1, long var2, byte[] var4);

    public native int SM2_struct_verify(int var1, long var2, byte[] var4, byte[] var5);

    public byte[] generateKeyPair() {
        return this.SM2_genkey();
    }

    public byte[] sm2_encrypt(int isDer, byte[] input, byte[] pubkey) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (pubkey != null && pubkey.length == 64) {
            if (input != null && input.length != 0) {
                return this.SM2_encrypt(isDer, input, pubkey);
            } else {
                throw ErrorCode.invalid_parameter("sm2 plain input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 pubkey input error");
        }
    }

    public byte[] sm2_decrypt(int isDer, byte[] input, byte[] prikey) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (prikey != null && prikey.length == 32) {
            if (input != null && input.length != 0) {
                return this.SM2_decrypt(isDer, input, prikey);
            } else {
                throw ErrorCode.invalid_parameter("sm2 cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 prikey input error");
        }
    }

    public byte[] sm2_sign(int isDer, byte[] input, byte[] pubkey, byte[] prikey) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (pubkey != null && pubkey.length == 64) {
            if (prikey != null && prikey.length == 32) {
                if (input != null && input.length != 0) {
                    return this.SM2_sign(isDer, input, pubkey, prikey);
                } else {
                    throw ErrorCode.invalid_parameter("sm2 plain input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm2 prikey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 pubkey input error");
        }
    }

    public int sm2_verify(int isDer, byte[] input, byte[] sign, byte[] pubkey) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (pubkey != null && pubkey.length == 64) {
            if (input != null && input.length != 0) {
                if (sign != null && sign.length != 0) {
                    return this.SM2_verify(isDer, input, sign, pubkey);
                } else {
                    throw ErrorCode.invalid_parameter("sm2 signValue input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm2 plain input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 pubkey input error");
        }
    }

    public long set_ec_key(byte[] pubkey, byte[] prikey) {
        if (pubkey != null && pubkey.length == 64) {
            if (prikey != null && prikey.length == 32) {
                return this.Set_ec_key(pubkey, prikey);
            } else {
                throw ErrorCode.invalid_parameter("sm2 prikey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 pubkey input error");
        }
    }

    public byte[] sm2_struct_encrypt(int isDer, long ec_key, byte[] input) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (ec_key <= 0L) {
            throw ErrorCode.invalid_parameter("sm2 ec_key input error");
        } else if (input != null && input.length != 0) {
            return this.SM2_struct_encrypt(isDer, ec_key, input);
        } else {
            throw ErrorCode.invalid_parameter("sm2 plain input error");
        }
    }

    public byte[] sm2_struct_decrypt(int isDer, long ec_key, byte[] input) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (ec_key <= 0L) {
            throw ErrorCode.invalid_parameter("sm2 ec_key input error");
        } else if (input != null && input.length != 0) {
            return this.SM2_struct_decrypt(isDer, ec_key, input);
        } else {
            throw ErrorCode.invalid_parameter("sm2 cipher input error");
        }
    }

    public byte[] sm2_struct_sign(int isDer, long ec_key, byte[] input) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (ec_key <= 0L) {
            throw ErrorCode.invalid_parameter("sm2 ec_key input error");
        } else if (input != null && input.length != 0) {
            return this.SM2_struct_sign(isDer, ec_key, input);
        } else {
            throw ErrorCode.invalid_parameter("sm2 plain input error");
        }
    }

    public int sm2_struct_verify(int isDer, long ec_key, byte[] input, byte[] sign) {
        if (isDer != 1 && isDer != 0) {
            throw ErrorCode.invalid_parameter("sm2 derType input error, please input 0 or 1");
        } else if (ec_key <= 0L) {
            throw ErrorCode.invalid_parameter("sm2 ec_key input error");
        } else if (input != null && input.length != 0) {
            if (sign != null && sign.length != 0) {
                return this.SM2_struct_verify(isDer, ec_key, input, sign);
            } else {
                throw ErrorCode.invalid_parameter("sm2 signValue input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm2 plain input error");
        }
    }
}
