//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

import java.util.Arrays;

public class CGCipherFPE extends CGCipher {
    public CGCipherFPE() {
    }

    public native byte[] sm_phnum_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_phnum_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_phnum4_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_phnum4_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_num_encrypt(byte[] var1, int var2, int var3, byte[] var4);

    public native byte[] sm_num_decrypt(byte[] var1, int var2, int var3, byte[] var4);

    public native byte[] sm_idcard_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_idcard_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_email_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_email_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_pport_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_pport_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_aidcard_encrypt(byte[] var1, byte[] var2);

    public native byte[] sm_aidcard_decrypt(byte[] var1, byte[] var2);

    public native byte[] sm_SM4_ctr_encrypt(byte[] var1, byte[] var2, byte[] var3, byte[] var4);

    public native byte[] sm_SM4_ctr_decrypt(byte[] var1, byte[] var2, byte[] var3, byte[] var4);

    public byte[] phonenumber_encrypt(byte[] key, byte[] plain) {
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0) {
                return this.sm_phnum_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe phonenumber input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] phonenumber_decrypt(byte[] key, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0) {
                return this.sm_phnum_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe phonenumber cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] phonenumber4_encrypt(byte[] key, byte[] plain) {
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0) {
                return this.sm_phnum4_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe phonenumber4 input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] phonenumber4_decrypt(byte[] key, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0) {
                return this.sm_phnum4_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe phonenumber4 cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] number_encrypt(byte[] key, int totalnum, int num, byte[] plain) {
        if (key != null && key.length == 16) {
            if (totalnum <= 0) {
                throw ErrorCode.invalid_parameter("fpe number encrypt totalnum input error");
            } else if (num < 0) {
                throw ErrorCode.invalid_parameter("fpe number encrypt num input error");
            } else if (plain != null && plain.length != 0 && NativeUtilsTemp.isNumber(new String(plain))) {
                return this.sm_num_encrypt(key, totalnum, num, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe number input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] number_decrypt(byte[] key, int totalnum, int num, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (totalnum <= 0) {
                throw ErrorCode.invalid_parameter("fpe number decrypt totalnum input error");
            } else if (num < 0) {
                throw ErrorCode.invalid_parameter("fpe number decrypt num input error");
            } else if (cipher != null && cipher.length != 0 && NativeUtilsTemp.isNumber(new String(cipher))) {
                return this.sm_num_decrypt(key, totalnum, num, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe number cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] idcard_encrypt(byte[] key, byte[] plain) {
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0) {
                return this.sm_idcard_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe idcard input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] idcard_decrypt(byte[] key, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0) {
                return this.sm_idcard_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe idcard cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] email_encrypt(byte[] key, byte[] plain) {
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0) {
                return this.sm_email_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe email input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] email_decrypt(byte[] key, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0) {
                return this.sm_email_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe email cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] pport_encrypt(byte[] key, byte[] plain) {
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0) {
                return this.sm_pport_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe passport input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] pport_decrypt(byte[] key, byte[] cipher) {
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0) {
                return this.sm_pport_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe passport cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] aidcard_encrypt(byte[] key, byte[] plain) {
        byte[] prefix = new byte[]{-27, -83, -105, -25, -84, -84};
        byte[] suffix = new byte[]{-27, -113, -73};
        if (key != null && key.length == 16) {
            if (plain != null && plain.length != 0 && Arrays.equals(Arrays.copyOfRange(plain, 3, 9), prefix) && Arrays.equals(Arrays.copyOfRange(plain, plain.length - 3, plain.length), suffix)) {
                return this.sm_aidcard_encrypt(key, plain);
            } else {
                throw ErrorCode.invalid_parameter("fpe aidcard input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] aidcard_decrypt(byte[] key, byte[] cipher) {
        byte[] prefix = new byte[]{-27, -83, -105, -25, -84, -84};
        byte[] suffix = new byte[]{-27, -113, -73};
        if (key != null && key.length == 16) {
            if (cipher != null && cipher.length != 0 && Arrays.equals(Arrays.copyOfRange(cipher, 3, 9), prefix) && Arrays.equals(Arrays.copyOfRange(cipher, cipher.length - 3, cipher.length), suffix)) {
                return this.sm_aidcard_decrypt(key, cipher);
            } else {
                throw ErrorCode.invalid_parameter("fpe aidcard cipher input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] ctr_hmac_encrypt(byte[] key, byte[] iv, byte[] hmackey, byte[] input) {
        if (key != null && key.length == 16) {
            return this.sm_SM4_ctr_encrypt(key, iv, hmackey, input);
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }

    public byte[] ctr_hmac_decrypt(byte[] key, byte[] iv, byte[] hmackey, byte[] input) {
        if (key != null && key.length == 16) {
            return this.sm_SM4_ctr_decrypt(key, iv, hmackey, input);
        } else {
            throw ErrorCode.invalid_parameter("fpe key input error");
        }
    }
}
