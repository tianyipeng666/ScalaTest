package udf.geo;

import java.util.HashMap;
import java.util.Map;

public class GeoTree {
    GeoInfo info = null;
    private Map<String,GeoTree> m_geo_tree = new HashMap<>();
    // 0省 1市 2区县
    private int m_type;

    public GeoTree(int type, GeoInfo info)
    {
        m_type = type;
        this.info = info;
    }

    public GeoInfo getInfo()
    {
        return info;
    }

    public void addChild(String key,GeoTree tree)
    {
        m_geo_tree.put(key, tree);
    }

    public GeoTree getChild(String key)
    {
        return m_geo_tree.get(key);
    }
}
