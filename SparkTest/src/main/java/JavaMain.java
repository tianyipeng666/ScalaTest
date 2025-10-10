import bean.FieldInfo;
import bean.FieldInfo2;
import collect.JavaCollectUtils;
import enc.SM2EncryptDecryptUtils;
import enc.StatusCode;
import json.GsonUtils;
import sm4.com.travelsky.alid.Sm4DecryptApp;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JavaMain {
    public static void main(String[] args) {
        String ftpPath = "/typ/sm4/BKOBJ-202310301345.txt";
        String hdfsPath = "/typ/BKOBJ-202310301345DEN.txt";
        sm4Dispose(ftpPath, hdfsPath);
    }

    public static void sm4Dispose(String ftpPath, String hdfsPath) {
        try {
            Sm4DecryptApp.ftpSm4ToHdfs(ftpPath, hdfsPath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void sm2Dispose() {
        try {
            String str = "tianyipeng";
            String encrypt = SM2EncryptDecryptUtils.encrypt(str);
            System.out.println(encrypt);
            String decrypt = SM2EncryptDecryptUtils.decrypt(encrypt);
            System.out.println(decrypt);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void collectDispose() {

    }

    public static void jsonDispose() {
        ArrayList<FieldInfo> list = new ArrayList<FieldInfo>();
        list.add(new FieldInfo("AAA", "AAA", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("BBB", "BBB", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("CCC", "CCC", true, new HashMap<String, Object>()));
        list.add(new FieldInfo("DDD", "DDD", true, new HashMap<String, Object>()));
        List<FieldInfo2> fieldInfo2s = GsonUtils.parseList(list, FieldInfo2.class);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (FieldInfo2 fieldInfo2 : fieldInfo2s) {
            resultMap.put(fieldInfo2.getName(),"");
        }
        System.out.println(fieldInfo2s);
        System.out.println(resultMap);
    }
}
