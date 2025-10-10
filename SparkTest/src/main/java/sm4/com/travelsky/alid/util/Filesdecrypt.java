//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.travelsky.alid.util;

import sm4.com.ciphergateway.crypto.CGCipher;
import ftp.FtpUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.*;
import java.util.Arrays;

public class Filesdecrypt {

    private static final String MODE = "CBC";
    private static final int PADDING_PKCS7 = 1;

    public Filesdecrypt() {
    }

    public void LS_File_decrypt(FileInputStream fis, FileOutputStream fos, byte[] keys, byte[] iv, String mode, int padding) throws IOException {
        Fileaudit fa = new Fileaudit();
        if (!fa.modeAudit(mode)) {
            throw new IllegalArgumentException("ERROR! Mode: CBC/ECB/CTR/OFB");
        } else if (fa.filesAudit(fis, fos)) {
            throw new IllegalArgumentException("ERROR! file path can't be read");
        } else {
            CGCipher sm4 = CGCipher.getInstance("SM4", mode);
            byte[] tbuffer = new byte[4112];
            int readNum;
            while((readNum = fis.read(tbuffer)) != -1) {
                byte[] buffer = Arrays.copyOf(tbuffer, readNum);
                byte[] temp = sm4.sm4_decrypt(1, buffer, keys, iv);
                fos.write(temp, 0, temp.length);
            }

            fos.flush();
        }
    }

    public static void decryptFtpToHdfsByFrames(String remoteFile,
                                                String hdfsPath,
                                                byte[] key16,
                                                byte[] iv16) throws Exception {
        if (key16 == null || key16.length != 16) throw new IllegalArgumentException("SM4 key must be 16 bytes");
        if (!"ECB".equalsIgnoreCase(MODE) && (iv16 == null || iv16.length != 16))
            throw new IllegalArgumentException("SM4 IV must be 16 bytes for CBC");

        FTPClient ftp = FtpUtils.getConnect("123.126.105.70", 21, "share", "haizhi1234");
        try {
            try (InputStream in = ftp.retrieveFileStream(remoteFile)) {
                if (in == null) throw new FileNotFoundException(remoteFile);

                Configuration conf = new Configuration();
                FileSystem fs = FileSystem.get(conf);
                try (FSDataOutputStream out = fs.create(new Path(hdfsPath), true)) {
                    CGCipher sm4 = CGCipher.getInstance("SM4", MODE);

                    byte[] frame = new byte[4112];
                    int filled = 0;
                    byte[] iv = iv16.clone();

                    byte[] buf = new byte[64 * 1024];
                    int n;
                    while ((n = in.read(buf)) != -1) {
                        int off = 0;
                        while (n > 0) {
                            int copy = Math.min(n, 4112 - filled);
                            System.arraycopy(buf, off, frame, filled, copy);
                            filled += copy; off += copy; n -= copy;

                            if (filled == 4112) {
                                // 解一帧（PKCS7），写明文，然后重置 IV
                                byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, frame, key16, iv);
                                out.write(plain);
                                iv = iv16.clone();   // 下一帧重置 IV
                                filled = 0;
                            }
                        }
                    }
                    if (filled != 0) {
                        throw new IOException("Trailing bytes not a full frame: " + filled);
                    }
                    out.hflush();
                }
            }
            if (!ftp.completePendingCommand())
                throw new IOException("FTP completePendingCommand failed: " + ftp.getReplyString());
        } finally {
            try {ftp.logout(); } catch (Exception ignore) {}
            try {ftp.disconnect(); } catch (Exception ignore) {}
        }
    }
}
