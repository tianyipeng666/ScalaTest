package udf.geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class GeoCN {
    private static boolean hasLoaded = false;
    private static Map<String, GeoInfo> map = new HashMap<>();
    private static Map<String, GeoTree> map_tree = new HashMap<>();
    private static ReentrantLock lock = new ReentrantLock();

    public void load(String filename){
        if(hasLoaded){
            return;
        }
        InputStream fin = getClass().getResourceAsStream(filename);
        lock.lock();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line = reader.readLine();
            while (line != null){
                String[] tokens = line.split(",");
                // tokens: [code, name, alias]
                if (tokens.length == 3){
                    GeoInfo info = new GeoInfo(tokens[0], tokens[1], tokens[2]);

                    map.put(tokens[0], info);
                    map.put(tokens[1], info);
                    map.put(tokens[2], info);
                    createGeoTree(tokens, info);
                }
                else if (tokens.length == 2){
                    GeoInfo info = new GeoInfo(tokens[0], tokens[1], "");
                    map.put(tokens[0], info);
                    map.put(tokens[1], info);
                    createGeoTree(tokens, info);
                }
                line = reader.readLine();
            }
            hasLoaded = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }

    public GeoInfo getGeoInfo(String province_code, String city, String district)
    {
        if(district == null || district.isEmpty())
            return new UnknownGeoInfo(district);

        String pre_code = city;
        // 优先城市,否则使用省
        if(city == null || city.isEmpty())
            pre_code = province_code;

        if(!map.containsKey(pre_code))
            return new UnknownGeoInfo(pre_code);

        // 市级的取号代码
        GeoInfo format_city = map.get(pre_code);

        String key = format_city.getCode() + district;
        if (map.containsKey(key)){
            return map.get(key);
        }
        return new UnknownGeoInfo(key);
    }

    public GeoInfo getGeoInfo(String key){
        if (map.containsKey(key)){
            return map.get(key);
        }
        return new UnknownGeoInfo(key);
    }

    public GeoInfo getGeoInfo(String province, String city, String district, int exist_province, int dim_index)
    {
        switch (dim_index)
        {
            case 0:
                return getProvince(province);
            case 1:
                return getCityORProvince(province,city,exist_province);
            case 2:
                return getDistrict(province, city, district, exist_province);
        }
        return null;
    }

    public GeoInfo getProvince(String province)
    {
        GeoInfo result = null;
        if (province != null && !province.isEmpty()){
            GeoTree province_tree = map_tree.get(province);
            if (province_tree != null)
                result= province_tree.getInfo();
        }
        return result;
    }

    public GeoInfo getCityORProvince(String province, String city, int exist_province) {
        GeoInfo result = null;

        //市必须存在
        if (city == null || city.isEmpty()) {
            return result;
        }
        GeoTree province_tree = null;
        GeoTree city_tree = null;

        // 如果设置了省
        if (exist_province == 1)
        {
            if (province == null || province.isEmpty())
                return result;
            province_tree=map_tree.get(province);
            //如果省错误
            if (province_tree == null)
                return result;
        }

        //如果省没设置,遍历省查找市
        if(province_tree == null)
        {
            for (Map.Entry<String, GeoTree> entry : map_tree.entrySet()) {
                city_tree = entry.getValue().getChild(city);
                if (city_tree != null)
                    break;
            }
        }else {
            city_tree = province_tree.getChild(city);
        }

        if(city_tree == null)
            return result;

        result = city_tree.getInfo();
        return result;
    }

    public GeoInfo getDistrict(String province, String city, String district, int exist_province) {
        GeoInfo result = null;

        //市和区县必须存在
        if (city == null || city.isEmpty())
            return result;

        if (district == null || district.isEmpty())
            return result;

        GeoTree province_tree = null;
        GeoTree city_tree = null;

        // 如果设置了省
        if (exist_province == 1)
        {
            if (province == null || province.isEmpty())
                return result;
            province_tree=map_tree.get(province);
            //如果省错误
            if (province_tree == null)
                return result;
        }

        //如果省没设置,遍历省查找市
        if(province_tree == null)
        {
            for (Map.Entry<String, GeoTree> entry : map_tree.entrySet()) {
                city_tree = entry.getValue().getChild(city);
                if (city_tree != null)
                    break;
            }
        }else {
            city_tree = province_tree.getChild(city);
        }

        if(city_tree == null)
            return result;

        GeoTree district_tree = city_tree.getChild(district);
        if (district_tree == null)
            return result;

        result = district_tree.getInfo();
        return result;
    }

    private void createGeoTree(String[] tokens, GeoInfo info)
    {
        if (info.isProvince())
        {
            GeoTree tree = map_tree.get(tokens[0]);
            if (tree == null)
            {
                tree = new GeoTree(0, info);
                map_tree.put(tokens[0], tree);
                map_tree.put(tokens[1], tree);
                if(tokens.length > 2)
                {
                    map_tree.put(tokens[2], tree);
                }
            }
            return;
        }

        int type = 1;
        String key = info.getProvinceCode();
        GeoTree parent_tree = map_tree.get(key);
        if (info.isDistrict())
        {
            key = info.getCityCode();
            parent_tree = parent_tree.getChild(key);
        }
        else if(info.isCity())
            type = 2;

        //首先查询到父节点
        if (parent_tree != null)
        {
            // 重庆特殊处理
            if(tokens[0].equals("500200"))
            {
                GeoTree tree = parent_tree.getChild("500100");
                parent_tree.addChild(tokens[0], tree);
                return;
            }

            GeoTree childtree = new GeoTree(type, info);

            parent_tree.addChild(tokens[0], childtree);
            parent_tree.addChild(tokens[1], childtree);
            if(tokens.length > 2)
            {
                parent_tree.addChild(tokens[2], childtree);
            }
        }
    }
}
