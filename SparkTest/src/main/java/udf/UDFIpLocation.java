package udf;

import udf.utils.IpUtil;

/**
 * create java function IP_LOCATION returns string jarname 'gbase-java-udf.jar' as 'UDFIpLocation.ipLocation';
 */
public class UDFIpLocation {
    

    private static final String FILE_DATA = "/mydata4vipweek1.dat";

    public static void main(String[] args) {
        System.out.println(ipLocation("119.97.111.8", 0));
        System.out.println(ipLocation("119.97.111.8", 1));
        System.out.println(ipLocation("119.97.111.8", 2));
        System.out.println(ipLocation("119.97.111.8", 3));
        System.out.println(ipLocation("119.97.111.8", 4));
    }

    public static String ipLocation(String ip, long type){
        if (ip == null) {
            return "";
        }
        if (type < 0) {
            return "";
        }
        new IpUtil().load(FILE_DATA);
        return IpUtil.findByParam(ip, (int)type);
    }

    public static String ipLocation(String ip){
        if (ip == null) {
            return "";
        }
        new IpUtil().load(FILE_DATA);
        return IpUtil.findAll(ip);
    }
}
