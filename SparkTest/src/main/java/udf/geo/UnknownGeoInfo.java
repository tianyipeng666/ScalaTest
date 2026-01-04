package udf.geo;

public class UnknownGeoInfo extends GeoInfo {
    public UnknownGeoInfo(String name){
        super(name, name, name);
    }

    @Override
    public String getCityCode() {
        return getName();
    }

    @Override
    public String getProvinceCode() {
        return getName();
    }

    @Override
    public String getDistrictCode() {
        return getName();
    }
}
