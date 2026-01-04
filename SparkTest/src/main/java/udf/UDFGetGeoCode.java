package udf;

import udf.geo.GeoCN;
import udf.geo.GeoInfo;
import udf.geo.UnknownGeoInfo;


/**
 * create java function GET_GEO_CODE returns string jarname 'gbase-java-udf.jar' as 'UDFGetGeoCode.getGeoCode';
 */

public class UDFGetGeoCode {


    public static void main(String[] args) {
        System.out.println(getGeoCode("420111", "province"));
        System.out.println(getGeoCode("420111", "city"));
        System.out.println(getGeoCode("420100", "district"));
    }

    public static String getGeoCode(String key, String level) {
        if (key == null) {
            return null;
        }
        GeoCN geoCN = new GeoCN();
        geoCN.load("/geo_cn.csv");
        GeoInfo info = geoCN.getGeoInfo(key);
        String code;
        String[] arrStr = new String[]{"?", "0"};

        switch (level) {
            case GeoInfo.PROVINCE:
                code = info.getProvinceCode();
                break;
            case GeoInfo.CITY:
                code = info.getCityCode();
                break;
            case GeoInfo.DISTRICT:
                code = info.getDistrictCode();
                break;
            default:
                code = info.getCode();
        }

        if (info instanceof UnknownGeoInfo || code == null) {
            if (key == null || key.isEmpty())
                return null;
            arrStr[1] = key;
            return String.join("\001", arrStr);
        }
        return code == null ? key : code;
    }

    public static String getGeoCode(String key) {
        return getGeoCode(key, "");
    }

    // 省市级别,区县为空
    public static String getGeoCode(String province, String city, String district, String level, long exist_province, long dim_index) {
        GeoCN geoCN = new GeoCN();
        geoCN.load("/geo_cn.csv");
        String[] arrStr = new String[]{"?", "0"};
        switch (level) {
            case GeoInfo.PROVINCE: {
                GeoInfo info = geoCN.getGeoInfo(province, city, district, (int)exist_province, (int)dim_index);
                if (info != null)
                    return info.getProvinceCode();

                String mismatch = getMismatch(province, city, district, dim_index);
                if (mismatch == null || mismatch.isEmpty())
                    return null;
                arrStr[1] = mismatch;
                return String.join("\001", arrStr);
            }

            // 查询到市, 省可以为空
            case GeoInfo.CITY: {
                if (dim_index > 0) {
                    GeoInfo info = geoCN.getGeoInfo(province, city, district, (int)exist_province, (int)dim_index);
                    if (info != null)
                        return info.getCityCode();
                }
                String mismatch = getMismatch(province, city, district, dim_index);
                if (mismatch == null || mismatch.isEmpty())
                    return null;
                arrStr[1] = mismatch;
                return String.join("\001", arrStr);
            }

            // 查询到县,省可以为空
            case GeoInfo.DISTRICT: {
                if (dim_index > 1) {
                    GeoInfo info = geoCN.getGeoInfo(province, city, district, (int)exist_province, (int)dim_index);
                    if (info != null)
                        return info.getDistrictCode();
                }
                String mismatch = getMismatch(province, city, district, dim_index);
                if (mismatch == null || mismatch.isEmpty())
                    return null;
                arrStr[1] = mismatch;
                return String.join("\001", arrStr);
            }
        }

        return province != null ? city : province;
    }

    private static String getMismatch(String province, String city, String district, long dim_index) {
        switch ((int) dim_index) {
            case 0:
                return province;
            case 1:
                return city;
            case 2:
                return district;
        }
        return "";
    }
}
