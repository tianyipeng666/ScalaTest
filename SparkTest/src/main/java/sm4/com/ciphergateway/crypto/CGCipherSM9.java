//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

public class CGCipherSM9 extends CGCipher {
    public CGCipherSM9() {
    }

    public native byte[] SM9_genkeypair(int var1);

    public native byte[] SM9_genprikey(int var1, byte[] var2, String var3);

    public native byte[] SM9_encrypt(byte[] var1, byte[] var2, String var3);

    public native byte[] SM9_decrypt(byte[] var1, byte[] var2);

    public native byte[] SM9_wrapkey(int var1, byte[] var2, String var3);

    public native byte[] SM9_unwraykey(int var1, byte[] var2, byte[] var3);

    public native byte[] SM9_sign(byte[] var1, byte[] var2);

    public native int SM9_verify(byte[] var1, byte[] var2, byte[] var3, String var4);

    public native byte[] SM9_key_exchange_init(byte[] var1, String var2);

    public native byte[] SM9_compute_share_key_A(int var1, int var2, byte[] var3, byte[] var4, byte[] var5, byte[] var6, byte[] var7, String var8, byte[] var9);

    public native byte[] SM9_compute_share_key_B(int var1, int var2, byte[] var3, byte[] var4, byte[] var5, byte[] var6, String var7, byte[] var8);

    public byte[] sm9_genkeypair(int type) {
        if (type != 1169 && type != 1171 && type != 1170) {
            throw ErrorCode.invalid_algorithm("please input type NID_sm9encrypt||NID_sm9sign||NID_sm9keyagreement");
        } else {
            return this.SM9_genkeypair(type);
        }
    }

    public byte[] sm9_genprikey(int type, byte[] mprikey, String id) {
        if (type != 1169 && type != 1171 && type != 1170) {
            throw ErrorCode.invalid_algorithm("please input type NID_sm9encrypt||NID_sm9sign||NID_sm9keyagreement");
        } else if (mprikey != null && mprikey.length != 0) {
            if (id != null && id.length() != 0) {
                return this.SM9_genprikey(type, mprikey, id);
            } else {
                throw ErrorCode.invalid_parameter("sm9 id input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 mprikey input error");
        }
    }

    public byte[] sm9_encrypt(byte[] input, byte[] mpubkey, String id) {
        if (input != null && input.length != 0) {
            if (mpubkey != null && mpubkey.length != 0) {
                if (id != null && id.length() != 0) {
                    return this.SM9_encrypt(input, mpubkey, id);
                } else {
                    throw ErrorCode.invalid_parameter("sm9 id input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm9 mpubkey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 plain input error");
        }
    }

    public byte[] sm9_decrypt(byte[] input, byte[] prikey) {
        if (input != null && input.length != 0) {
            if (prikey != null && prikey.length != 0) {
                return this.SM9_decrypt(input, prikey);
            } else {
                throw ErrorCode.invalid_parameter("sm9 user prikey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 cipher input error");
        }
    }

    public byte[] sm9_wrapkey(int keylen, byte[] mpubkey, String id) {
        if (keylen <= 0) {
            throw ErrorCode.invalid_parameter("sm9 key length input error");
        } else if (mpubkey != null && mpubkey.length != 0) {
            if (id != null && id.length() != 0) {
                return this.SM9_wrapkey(keylen, mpubkey, id);
            } else {
                throw ErrorCode.invalid_parameter("sm9 id input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 mpubkey input error");
        }
    }

    public byte[] sm9_unwraykey(int keylen, byte[] keyCipher, byte[] prikey) {
        if (keylen <= 0) {
            throw ErrorCode.invalid_parameter("sm9 key length input error");
        } else if (keyCipher != null && keyCipher.length != 0) {
            if (prikey != null && prikey.length != 0) {
                return this.SM9_unwraykey(keylen, keyCipher, prikey);
            } else {
                throw ErrorCode.invalid_parameter("sm9 user prikey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 key cipher input error");
        }
    }

    public byte[] sm9_sign(byte[] input, byte[] prikey) {
        if (input != null && input.length != 0) {
            if (prikey != null && prikey.length != 0) {
                return this.SM9_sign(input, prikey);
            } else {
                throw ErrorCode.invalid_parameter("sm9 user prikey input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 sign data input error");
        }
    }

    public int sm9_verify(byte[] input, byte[] sign, byte[] mpubkey, String id) {
        if (input != null && input.length != 0) {
            if (sign != null && sign.length != 0) {
                if (mpubkey != null && mpubkey.length != 0) {
                    if (id != null && id.length() != 0) {
                        return this.SM9_verify(input, sign, mpubkey, id);
                    } else {
                        throw ErrorCode.invalid_parameter("sm9 id input error");
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm9 mpubkey input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm9 sign value input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 sign data input error");
        }
    }

    public byte[] sm9_key_exchange_init(byte[] prikey, String id) {
        if (prikey != null && prikey.length != 0) {
            if (id != null && id.length() != 0) {
                return this.SM9_key_exchange_init(prikey, id);
            } else {
                throw ErrorCode.invalid_parameter("sm9 id input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 user prikey input error");
        }
    }

    public byte[] sm9_compute_share_key_B(int type, int keylen, byte[] rB, byte[] RB, byte[] RA, byte[] grB, String Aid, byte[] Bprikey) {
        if (type != 1183 && type != 1184) {
            throw ErrorCode.invalid_algorithm("please input type NID_sm9kdf_with_sm3||NID_sm9kdf_with_sha256");
        } else if (keylen <= 0) {
            throw ErrorCode.invalid_parameter("sm9 key length input error");
        } else if (rB != null && rB.length == 32) {
            if (RB != null && RB.length == 65) {
                if (RA != null && RA.length == 65) {
                    if (grB != null && grB.length == 384) {
                        if (Aid != null && Aid.length() != 0) {
                            if (Bprikey != null && Bprikey.length != 0) {
                                return this.SM9_compute_share_key_B(type, keylen, rB, RB, RA, grB, Aid, Bprikey);
                            } else {
                                throw ErrorCode.invalid_parameter("sm9 B user prikey input error");
                            }
                        } else {
                            throw ErrorCode.invalid_parameter("sm9 Aid input error");
                        }
                    } else {
                        throw ErrorCode.invalid_parameter("sm9 grB input error");
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm9 RA input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm9 RB input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 rB input error");
        }
    }

    public byte[] sm9_compute_share_key_A(int type, int keylen, byte[] SB, byte[] rA, byte[] RA, byte[] RB, byte[] grA, String Bid, byte[] Aprikey) {
        if (type != 1183 && type != 1184) {
            throw ErrorCode.invalid_algorithm("please input type NID_sm9kdf_with_sm3||NID_sm9kdf_with_sha256");
        } else if (keylen <= 0) {
            throw ErrorCode.invalid_parameter("sm9 key length input error");
        } else if (SB != null && SB.length == 32) {
            if (rA != null && rA.length == 32) {
                if (RA != null && RA.length == 65) {
                    if (RB != null && RB.length == 65) {
                        if (grA != null && grA.length == 384) {
                            if (Bid != null && Bid.length() != 0) {
                                if (Aprikey != null && Aprikey.length != 0) {
                                    return this.SM9_compute_share_key_A(type, keylen, SB, rA, RA, RB, grA, Bid, Aprikey);
                                } else {
                                    throw ErrorCode.invalid_parameter("sm9 A user prikey input error");
                                }
                            } else {
                                throw ErrorCode.invalid_parameter("sm9 Bid input error");
                            }
                        } else {
                            throw ErrorCode.invalid_parameter("sm9 grA input error");
                        }
                    } else {
                        throw ErrorCode.invalid_parameter("sm9 RB input error");
                    }
                } else {
                    throw ErrorCode.invalid_parameter("sm9 RA input error");
                }
            } else {
                throw ErrorCode.invalid_parameter("sm9 rA input error");
            }
        } else {
            throw ErrorCode.invalid_parameter("sm9 SB input error");
        }
    }
}
