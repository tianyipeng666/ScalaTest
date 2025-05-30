package conf;

import java.io.File;
import java.util.*;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigException.Missing;
import utils.UdfUtils;

public class UdfConf {

    private static final Config conf = init();

    private static Config init() {
        String configFileName = "udf.conf";
        File configFile = new File(configFileName);
        Config udfConfig = ConfigFactory.parseFile(configFile);
        return ConfigFactory.load(udfConfig);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getConf(String name, T defaultValue) {
        try {
            Object value = conf.getValue(name).unwrapped();
            return (T) value;
        } catch (Missing e) {
            return defaultValue;
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getConf(String name) {
        Object value = conf.getValue(name).unwrapped();
        return (T) value;
    }

    public static final int udfRedisDbIndex = getConf("udf_redis.dbIndex");
    public static final String udfRedisHost = getConf("udf_redis.host");
    public static final String udfRedisPassword = getConf("udf_redis.password", "");
    public static final int udfRedisPort = getConf("udf_redis.port");
    public static final boolean udfRedisSentinelEnabled =
            getConf("udf_redis.sentinel.enabled", true);
    public static final String udfRedisSentinelMasterId =
            udfRedisSentinelEnabled ? getConf("udf_redis.sentinel.masterId") : null;

    public static final String udfMysqlUrl = getConf("udf_mysql.url");
    public static final String udfMysqlUser = getConf("udf_mysql.user");
    public static final String udfMysqlPassword = getConf("udf_mysql.password");
    public static final String udfMysqlDb = getConf("udf_mysql.db");
    public static final String udfMysqlTBZone = getConf("udf_mysql.zone", "");
    public static final String udfMysqlZoneId = getConf("udf_mysql.zone_id");
    public static final String udfMysqlZoneJson = getConf("udf_mysql.zone_json");
    public static final String udfMysqlTypeId = getConf("udf_mysql.type_id");
    public static final String udfMysqlTBPoint = getConf("udf_mysql.point");
    public static final String udfMysqlPointId = getConf("udf_mysql.point_id");
    public static final String udfMysqlPointJson = getConf("udf_mysql.point_json");
    public static final boolean udfMysqlEnabled = getConf("udf_mysql.enabled", false);

    public static final int udfMaxPartitions = getConf("udf.maxPartitions", 30);

    public static final List<Map.Entry<String, Integer>> udfRedisSentinelHostPort =
            buildSentinelHostPort();

    private static List<Map.Entry<String, Integer>> buildSentinelHostPort() {
        if (!udfRedisSentinelEnabled) {
            return null;
        }
        // raw cluster list from config
        List<String> clusterList = getConf("udf_redis.sentinel.cluster", new ArrayList<String>());
        List<Map.Entry<String, Integer>> hostAndPorts = new ArrayList<>();
        for (String entry : clusterList) {
            String[] parts = entry.split(":");
            hostAndPorts.add(new AbstractMap.SimpleEntry<>(parts[0], Integer.parseInt(parts[1])));
        }
        if (hostAndPorts.isEmpty()) {
            throw new IllegalArgumentException("udf_redis cluster list cannot be empty");
        }
        return hostAndPorts;
    }

    public static final long udfDictDataExpired;

    static {
        try {
            udfDictDataExpired = UdfUtils.parseTime(getConf("udf.dict.data_expired", "1d"));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("the value of the configuration udf.dict.data_expired is wrong format.", e);
        }
    }

    public static final String locationService = getConf("udf.location.service", "localhost:12345");
    public static final String locationAccountKey = getConf("udf.location.accountKey", "12345");

    public static final String udfApiProxy = getConf("udf.http.apiProxy", "http://bdp-core:22802/");
    public static final int udfApiConnectTimeout = getConf("udf.http.connectTimeout", 5);
    public static final int udfApiReadTimeout = getConf("udf.http.readTimeout", 60);

    // 地址经纬度转换UDF配置(需根据不同地区自行配置)
    public static final String mapHost = getConf("udf_map.host", "localhost");
    public static final int mapPort = getConf("udf_map.port", 10000);
    public static final String mapAk = getConf("udf_map.ak", "1");

    public static final String appTokenHost = getConf("udf_map.appHost", "localhost");
    public static final int appTokenPort = getConf("udf_map.appPort", 10000);
    public static final String appClientId = getConf("udf_map.clientId", "root");
    public static final String appClientSecret = getConf("udf_map.clientSecret", "12345");

    public static final String mapId = getConf("udf_map.id", "");
    public static final String mapName = getConf("udf_map.name", "");
    public static final String mapUserType = getConf("udf_map.userType", "");
    public static final String mapIdCard = getConf("udf_map.idCard", "");
    public static final String mapOrgId = getConf("udf_map.orgId", "");
    public static final String mapOrgName = getConf("udf_map.orgName", "");
    public static final String mapPoliceNumber = getConf("udf_map.policeNumber", "");

    public static final boolean udfRedisSwitch = getConf("udf_map.redis_switch", true);
    public static final int udfRedisExpire = getConf("udf_map.redis_expire", 3 * 24 * 60 * 60);
    public static final int udfRedisUserToken = getConf("udf_map.redis_expire", 50 * 60);
}

