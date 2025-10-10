//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.travelsky.alid.util;

import com.ciphergateway.crypto.CGCipher;
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

    public static void Ls_File_decrypt(InputStream fis, OutputStream fos, byte[] keys, byte[] iv, String mode, int padding) throws IOException {
        Fileaudit fa = new Fileaudit();
        if (!fa.modeAudit(mode)) {
            throw new IllegalArgumentException("ERROR! Mode: CBC/ECB/CTR/OFB");
        } else if (fis == null || fos == null) {
            throw new IllegalArgumentException("ERROR! file path can't be read");
        } else {
            CGCipher sm4 = CGCipher.getInstance("SM4", mode);
            byte[] tbuffer = new byte[4112];
            int readNum;
            while((readNum = fis.read(tbuffer)) != -1) {
                byte[] buffer = Arrays.copyOf(tbuffer, readNum);
                byte[] temp = sm4.sm4_decrypt(padding, buffer, keys, iv);
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

                Configuration conf = new Configuration(false);
                conf.addResource("core-site.xml");
                conf.addResource("hdfs-site.xml");
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
                    // 处理最后一段：只要求 16 的倍数，不必等于 FRAME
                    if (filled != 0) {
                        if ((filled & 0x0F) != 0) {
                            throw new IOException("Trailing bytes not block-aligned: " + filled);
                        }
                        byte[] last = java.util.Arrays.copyOf(frame, filled);
                        byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, last, key16, iv);
                        out.write(plain);
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

    public static void decryptHdfsToHdfsByFrames(String srcPath,
                                                 String dstPath,
                                                 byte[] key16,
                                                 byte[] iv16,
                                                 int frameSz) throws IOException {

        if (key16 == null || key16.length != 16)
            throw new IllegalArgumentException("SM4 key must be 16 bytes");
        if (!"ECB".equalsIgnoreCase(MODE) && (iv16 == null || iv16.length != 16))
            throw new IllegalArgumentException("SM4 IV must be 16 bytes for CBC");

        Configuration conf = new Configuration(false);
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        FileSystem fs = FileSystem.get(conf);
        Path src = new Path(srcPath);
        Path dst = new Path(dstPath);

        try (FSDataInputStream in = fs.open(src);
             FSDataOutputStream out = fs.create(dst, true)) {

            CGCipher sm4 = CGCipher.getInstance("SM4", MODE);

            byte[] frame  = new byte[frameSz];   // 帧缓冲（大多数段等于 frameSz）
            int    filled = 0;                   // 当前帧已填充的字节数
            byte[] iv     = (iv16 == null ? null : iv16.clone());

            byte[] buf = new byte[64 * 1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                int off = 0;
                while (n > 0) {
                    int copy = Math.min(n, frameSz - filled);
                    System.arraycopy(buf, off, frame, filled, copy);
                    filled += copy; off += copy; n -= copy;

                    if (filled == frameSz) {
                        // 处理一整帧（PKCS7），写出后重置 IV
                        byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, frame, key16, iv);
                        out.write(plain);
                        if (!"ECB".equalsIgnoreCase(MODE)) iv = iv16.clone();
                        filled = 0;
                    }
                }
            }

            // EOF：最后一段可能小于 frameSz——只要是 16 的倍数就按最后一段解密输出
            if (filled != 0) {
                if ((filled & 0x0F) != 0) {
                    throw new IOException("Trailing bytes not block-aligned: " + filled);
                }
                byte[] last = Arrays.copyOf(frame, filled);
                byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, last, key16, iv);
                out.write(plain);
            }
            out.hflush();
        }
    }

    public static void decryptStreamByFrames(InputStream in,
                                             OutputStream out,
                                             byte[] key16,
                                             byte[] iv16,
                                             int frameSz) throws IOException {
        if (key16 == null || key16.length != 16)
            throw new IllegalArgumentException("SM4 key must be 16 bytes");
        if (!"ECB".equalsIgnoreCase(MODE) && (iv16 == null || iv16.length != 16))
            throw new IllegalArgumentException("SM4 IV must be 16 bytes for CBC");

        try {
            CGCipher sm4 = CGCipher.getInstance("SM4", MODE);

            byte[] frame  = new byte[frameSz];
            int    filled = 0;
            byte[] iv     = ("ECB".equalsIgnoreCase(MODE) ? null : iv16.clone());

            byte[] buf = new byte[64 * 1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                int off = 0;
                while (n > 0) {
                    int copy = Math.min(n, frameSz - filled);
                    System.arraycopy(buf, off, frame, filled, copy);
                    filled += copy; off += copy; n -= copy;

                    if (filled == frameSz) {
                        byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, frame, key16, iv);
                        out.write(plain);
                        if (!"ECB".equalsIgnoreCase(MODE)) iv = iv16.clone(); // 下一帧从初始IV开始
                        filled = 0;
                    }
                }
            }

            // EOF：处理最后一段（允许 < frameSz，但必须是 16 的倍数）
            if (filled != 0) {
                if ((filled & 0x0F) != 0) {
                    throw new IOException("Trailing bytes not block-aligned: " + filled);
                }
                byte[] last = java.util.Arrays.copyOf(frame, filled);
                byte[] plain = sm4.sm4_decrypt(PADDING_PKCS7, last, key16, iv);
                out.write(plain);
            }
            out.flush();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            // 包装 JNI 的运行时异常为 IO 异常更统一
            throw new IOException("SM4 decrypt failed", e);
        }
    }

    public static InputStream openInputStream(String filePath) throws Exception{
        Configuration conf = new Configuration(false);
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(filePath);
        if (!fs.exists(path)) {
            return null;
        }
        return fs.open(path);
    }

    public static OutputStream openOutputStreamByUDF(String filePath, Boolean overwrite) throws Exception{
        Configuration conf = new Configuration(false);
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(filePath);
        return fs.create(path, overwrite);
    }
}
