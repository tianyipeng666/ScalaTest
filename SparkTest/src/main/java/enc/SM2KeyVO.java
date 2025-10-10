package enc;

import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;

public class SM2KeyVO {
    BigInteger privateKey;
    ECPoint publicKey;

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    public ECPoint getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(ECPoint publicKey) {
        this.publicKey = publicKey;
    }

    public String getPriHexInSoft() {
        return ConvertUtils.byteToHex(privateKey.toByteArray());
    }
}
