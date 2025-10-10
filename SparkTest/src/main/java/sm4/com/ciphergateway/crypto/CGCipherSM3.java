//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

public class CGCipherSM3 extends CGCipher {
    public native byte[] SM3_digest(byte[] var1);

    public native byte[] SM3_hmac(byte[] var1, byte[] var2);

    public native byte[] SM3_hkdf(byte[] var1, String var2, int var3);

    public native byte[] SM3_random(int var1);

    public CGCipherSM3() {
    }

    public byte[] sm3_digest(byte[] input) {
        if (input != null && input.length != 0) {
            return this.SM3_digest(input);
        } else {
            throw ErrorCode.invalid_parameter("sm3 message input error");
        }
    }

    public byte[] sm3_hmac(byte[] key, byte[] input) {
        if (key != null && key.length == 16) {
            if (input != null && input.length != 0) {
                return this.SM3_hmac(key, input);
            } else {
                throw ErrorCode.invalid_parameter("sm3 message input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm3 key input error");
        }
    }

    public byte[] sm3_hkdf(byte[] mmkey, String mtdata, int klen) {
        if (mmkey != null && mmkey.length == 16) {
            if (mtdata != null && mtdata.length() != 0) {
                if (klen <= 0) {
                    throw ErrorCode.invalid_parameter("sm3 key length input error");
                } else {
                    return this.SM3_hkdf(mmkey, mtdata, klen);
                }
            } else {
                throw ErrorCode.invalid_parameter("sm3 matedata input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm3 key input error");
        }
    }

    public byte[] sm3_random(int nbytes) {
        if (nbytes <= 0) {
            throw ErrorCode.invalid_parameter("sm3 random length input error");
        } else {
            return this.SM3_random(nbytes);
        }
    }

    public String sm3_num_random(int length) {
        if (length <= 0) {
            throw ErrorCode.invalid_parameter("sm3 random length input error");
        } else {
            byte[] random = this.sm3_random(length);
            return Util.byteToNumString(random);
        }
    }
}
