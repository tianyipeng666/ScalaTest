package redis;

// import io.lettuce.core.RedisURI;
// import io.lettuce.core.cluster.RedisClusterClient;
// import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
// import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class RedisConnection {
//    private static RedisClusterClient redisClient;
//
//    public static GenericObjectPool getRedisConnection(String redisHost, int redisPort, String password) {
//        if (!password.isEmpty()) {
//            RedisURI redisURI = RedisURI.create(redisHost, redisPort);
//            redisURI.setPassword(password);
//            redisClient = RedisClusterClient.create(redisURI);
//        } else {
//            redisClient = RedisClusterClient.create(RedisURI.create(redisHost, redisPort));
//        }
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMaxTotal(10);
//        GenericObjectPool<StatefulRedisClusterConnection<String, String>> pool = ConnectionPoolSupport.createGenericObjectPool(
//                () -> redisClient.connect(), poolConfig, false
//        );
//        return pool;
//    }
}
