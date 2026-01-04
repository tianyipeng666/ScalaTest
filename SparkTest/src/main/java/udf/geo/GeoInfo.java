package udf.geo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GeoInfo {
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String DISTRICT = "district";
    public static final Set<String>  CITIES_GOV_BY_CENTRAL
            = new HashSet<>(Arrays.asList(new String[]{"110000", "310000", "120000", "500000"}));

    private String code;
    private String name;
    private String alias;


    public GeoInfo(String code, String name, String alias) {
        this.code = code;
        this.name = name;
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getCityCode(){
        if(isGovByProvince()){
            return code;
        }
        if(isGovByCentral(code))
        {
            //直辖市
            return aggregateGovByCentralToCity();
        }
        if(isProvince()){
            return null;
        }
        return aggregateToCity();
    }

    private boolean isGovByProvince(){
        return aggregateToCity().endsWith("9000");
    }

    public boolean isProvince(){
        return code.endsWith("0000");
    }

    public boolean isCity(){
        return code.endsWith("00");
    }

    public boolean isDistrict()
    {
        return !code.endsWith("00");
    }

    public String getProvinceCode(){
        return aggregateToProvince();
    }

    public String getDistrictCode(){
        if(isProvince() || isCity())
            return null;
        return aggregateToDistrict();
    }

    public boolean isGovByCentral(String code){
        return CITIES_GOV_BY_CENTRAL.contains(code) || CITIES_GOV_BY_CENTRAL.contains(aggregateToProvince());
    }

    private String aggregateToDistrict(){
        return code.substring(0, 6);
    }

    private String aggregateToCity(){
        return code.substring(0, 4) + "00";
    }

    private String aggregateToProvince(){
        return code.substring(0, 2) + "0000";
    }

    private String aggregateGovByCentralToCity()
    {
        return code.substring(0, 2) + "0100";
    }
}
