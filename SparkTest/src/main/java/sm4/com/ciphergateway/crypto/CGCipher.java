//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

public abstract class CGCipher {
    public static final int NID_sm9encrypt = 1171;
    public static final int NID_sm9sign = 1169;
    public static final int NID_sm9keyagreement = 1170;
    public static final int NID_sm9hash1 = 1172;
    public static final int NID_sm9hash2 = 1209;
    public static final int NID_sm9kdf = 1173;
    public static final int NID_sm9kdf_with_sm3 = 1183;
    public static final int NID_sm9kdf_with_sha256 = 1184;
    public static final int NO_PADDING = 0;
    public static final int PKCS_PADDING = 1;

    static {
        NativeUtils.loadLibraryFromJar();
//        try {
//            if (NativeUtils.isWindows()) {
//                NativeUtils.loadLibraryFromJar("/com/ciphergateway/crypto/resources/windows/libCGCipherJNI.dll");
//            } else {
//                NativeUtils.loadLibraryFromJar("/com/ciphergateway/crypto/resources/linux/libCGCipherJNI.so");
//            }
//        } catch (IOException var1) {
//            var1.printStackTrace();
//        }

    }

    public CGCipher() {
    }

    public static native String GetVersion();

    public static CGCipher getInstance(String algorithm, String model) {
        if (algorithm.equalsIgnoreCase("sm2")) {
            return new CGCipherSM2();
        } else if (algorithm.equalsIgnoreCase("sm3")) {
            return new CGCipherSM3();
        } else if (algorithm.equalsIgnoreCase("sm4")) {
            return new CGCipherSM4(model);
        } else if (algorithm.equalsIgnoreCase("sm9")) {
            return new CGCipherSM9();
        } else if (algorithm.equalsIgnoreCase("fpe")) {
            return new CGCipherFPE();
        } else {
            throw ErrorCode.invalid_algorithm("please input sm2||sm3||sm4||sm9||fpe");
        }
    }

    public byte[] generateKeyPair() {
        return null;
    }

    public byte[] sm2_encrypt(int isDer, byte[] input, byte[] publickey) {
        return null;
    }

    public byte[] sm2_decrypt(int isDer, byte[] input, byte[] privatekey) {
        return null;
    }

    public byte[] sm2_sign(int isDer, byte[] input, byte[] publickey, byte[] privatekey) {
        return null;
    }

    public int sm2_verify(int isDer, byte[] input, byte[] sign, byte[] publickey) {
        return 0;
    }

    public long set_ec_key(byte[] pubkey, byte[] prikey) {
        return 0L;
    }

    public byte[] sm2_struct_encrypt(int isDer, long ec_key, byte[] input) {
        return null;
    }

    public byte[] sm2_struct_decrypt(int isDer, long ec_key, byte[] input) {
        return null;
    }

    public byte[] sm2_struct_sign(int isDer, long ec_key, byte[] input) {
        return null;
    }

    public int sm2_struct_verify(int isDer, long ec_key, byte[] input, byte[] sign) {
        return 0;
    }

    public byte[] sm3_digest(byte[] input) {
        return null;
    }

    public byte[] sm3_hmac(byte[] key, byte[] input) {
        return null;
    }

    public byte[] sm3_hkdf(byte[] mmkey, String mtdata, int klen) {
        return null;
    }

    public byte[] sm3_random(int nbytes) {
        return null;
    }

    public String sm3_num_random(int length) {
        return null;
    }

    public byte[] sm4_encrypt(int padding, byte[] input, byte[] keys, byte[] iv) {
        return null;
    }

    public byte[] sm4_decrypt(int padding, byte[] input, byte[] keys, byte[] iv) {
        return null;
    }

    public byte[] sm4_gcm_encrypt(byte[] input, byte[] keys, byte[] iv, byte[] aad) {
        return null;
    }

    public byte[] sm4_gcm_decrypt(byte[] input, byte[] keys, byte[] iv, byte[] aad) {
        return null;
    }

    public byte[] phonenumber_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] phonenumber_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] phonenumber4_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] phonenumber4_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] number_encrypt(byte[] key, int totalnum, int num, byte[] plain) {
        return null;
    }

    public byte[] number_decrypt(byte[] key, int totalnum, int num, byte[] cipher) {
        return null;
    }

    public byte[] idcard_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] idcard_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] email_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] email_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] pport_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] pport_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] aidcard_encrypt(byte[] key, byte[] plain) {
        return null;
    }

    public byte[] aidcard_decrypt(byte[] key, byte[] cipher) {
        return null;
    }

    public byte[] ctr_hmac_encrypt(byte[] key, byte[] iv, byte[] hmackey, byte[] input) {
        return null;
    }

    public byte[] ctr_hmac_decrypt(byte[] key, byte[] iv, byte[] hmackey, byte[] input) {
        return null;
    }

    public byte[] sm9_genkeypair(int type) {
        return null;
    }

    public byte[] sm9_genprikey(int type, byte[] mprikey, String id) {
        return null;
    }

    public byte[] sm9_wrapkey(int keylen, byte[] mpubkey, String id) {
        return null;
    }

    public byte[] sm9_unwraykey(int keylen, byte[] keyCipher, byte[] prikey) {
        return null;
    }

    public byte[] sm9_encrypt(byte[] input, byte[] mpubkey, String id) {
        return null;
    }

    public byte[] sm9_decrypt(byte[] input, byte[] prikey) {
        return null;
    }

    public byte[] sm9_sign(byte[] input, byte[] prikey) {
        return null;
    }

    public int sm9_verify(byte[] input, byte[] sign, byte[] mpubkey, String id) {
        return 0;
    }

    public byte[] sm9_key_exchange_init(byte[] prikey, String id) {
        return null;
    }

    public byte[] sm9_compute_share_key_B(int type, int keylen, byte[] rB, byte[] RB, byte[] RA, byte[] grB, String Aid, byte[] Bprikey) {
        return null;
    }

    public byte[] sm9_compute_share_key_A(int type, int keylen, byte[] SB, byte[] rA, byte[] RA, byte[] RB, byte[] grA, String Bid, byte[] Aprikey) {
        return null;
    }
}
