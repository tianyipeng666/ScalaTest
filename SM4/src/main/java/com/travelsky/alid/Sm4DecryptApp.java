package com.travelsky.alid;

import com.travelsky.alid.util.Filesdecrypt;
import com.travelsky.alid.util.SM4Util;
import com.travelsky.alid.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Properties;

public class Sm4DecryptApp {
    private static Logger log = LoggerFactory.getLogger(Sm4DecryptApp.class);

    public Sm4DecryptApp() {
    }

    public static void main(String[] args) {

        String inPath = args[0];
        String outPath = args[1];
        FileInputStream fin = null;
        FileOutputStream fos = null;

        try {
            String keyHex = "CCD92340883C3EF21745CFDD36F07C18";
            String ivHex = "5ADCC1D45C89041F96F903311AD886C3";
            String mode = "CBC";
            String enKeyHex = "167910C24AB228EB55818B5184AA805058E1B4FB0A086896C1F815B0D44D69FF";
            String enIvHex = "8E6F555FF8D1CC04CE0A0429E88BE021AC6AD66F9E7DBAC807F1E25ADBF076B4";
            byte[] keys = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enKeyHex, keyHex, ivHex, mode));
            byte[] iv = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enIvHex, keyHex, ivHex, mode));
            fin = new FileInputStream(new File(inPath));
            fos = new FileOutputStream(new File(outPath));
            Filesdecrypt decrypt = new Filesdecrypt();
            decrypt.LS_File_decrypt(fin, fos, keys, iv, mode, 1);
            log.info("Decrypt file Success");
        } catch (IOException var26) {
            log.error("Read File Error.", var26);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException var25) {
                    log.error("close FileInputStream error.", var25);
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException var24) {
                    log.error("close FileOutputStream error.", var24);
                }
            }

        }
    }

    public static void ftpSm4ToHdfs(String ftpPath, String hdfsPath) throws Exception {
        String keyHex = "CCD92340883C3EF21745CFDD36F07C18";
        String ivHex = "5ADCC1D45C89041F96F903311AD886C3";
        String mode = "CBC";
        String enKeyHex = "167910C24AB228EB55818B5184AA805058E1B4FB0A086896C1F815B0D44D69FF";
        String enIvHex = "8E6F555FF8D1CC04CE0A0429E88BE021AC6AD66F9E7DBAC807F1E25ADBF076B4";
        byte[] keys = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enKeyHex, keyHex, ivHex, mode));
        byte[] iv = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enIvHex, keyHex, ivHex, mode));
        Filesdecrypt decrypt = new Filesdecrypt();
        decrypt.decryptFtpToHdfsByFrames(ftpPath, hdfsPath, keys, iv);
    }

    public static void hdfsSm4ToHdfs(String ftpPath, String hdfsPath) throws Exception {
        String keyHex = "CCD92340883C3EF21745CFDD36F07C18";
        String ivHex = "5ADCC1D45C89041F96F903311AD886C3";
        String mode = "CBC";
        String enKeyHex = "167910C24AB228EB55818B5184AA805058E1B4FB0A086896C1F815B0D44D69FF";
        String enIvHex = "8E6F555FF8D1CC04CE0A0429E88BE021AC6AD66F9E7DBAC807F1E25ADBF076B4";
        byte[] keys = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enKeyHex, keyHex, ivHex, mode));
        byte[] iv = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enIvHex, keyHex, ivHex, mode));
        Filesdecrypt decrypt = new Filesdecrypt();
        decrypt.decryptHdfsToHdfsByFrames(ftpPath, hdfsPath, keys, iv, 4112);
    }

    public static void Sm4Decrypt(InputStream fis, OutputStream fos) throws IOException {
        String keyHex = "CCD92340883C3EF21745CFDD36F07C18";
        String ivHex = "5ADCC1D45C89041F96F903311AD886C3";
        String mode = "CBC";
        String enKeyHex = "167910C24AB228EB55818B5184AA805058E1B4FB0A086896C1F815B0D44D69FF";
        String enIvHex = "8E6F555FF8D1CC04CE0A0429E88BE021AC6AD66F9E7DBAC807F1E25ADBF076B4";
        byte[] keys = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enKeyHex, keyHex, ivHex, mode));
        byte[] iv = DatatypeConverter.parseHexBinary(SM4Util.decrypt(enIvHex, keyHex, ivHex, mode));
        Filesdecrypt decrypt = new Filesdecrypt();
        decrypt.decryptStreamByFrames(fis, fos, keys, iv, 4112);
    }

    public static void parseProperties() throws IOException{
        Properties props = new Properties();
        try (InputStream encIn = StringUtil.getProperties("app.properties");
             InputStream decIn = SM4Util.decryptProperties(encIn);
             InputStreamReader reader = new InputStreamReader(decIn, java.nio.charset.StandardCharsets.UTF_8)) {
            props.load(reader);
        }
        // props.load(SM4Util.decryptProperties(StringUtil.getProperties("app.properties")));
        String keyHex = props.getProperty("security.keys");
        System.out.println("[Sm4DecryptApp] keyHex = " + keyHex);
        String ivHex = props.getProperty("security.iv");
        System.out.println("[Sm4DecryptApp] ivHex = " + ivHex);
        String mode = props.getProperty("security.mode");
        System.out.println("[Sm4DecryptApp] mode = " + mode);
    }
}
