package redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class SpringRedis {

    private static final Logger logger = LoggerFactory.getLogger(SpringRedis.class);

    public static void main(String[] args) {
        System.out.println(String.format("Result ==> %s", keys("ALCHEMY*")));
    }


    public static RedisTemplate<String, Object> createRedisTemplate() {
        // 配置 Redis 连接
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("bdp-redis");
        connectionFactory.setPort(6679);
        connectionFactory.setPassword("h1iz6i2dp4redis");
        connectionFactory.afterPropertiesSet();

        // 构建 RedisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);

        // 设置序列化
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        GenericToStringSerializer valueStringRedisSerializer = new GenericToStringSerializer(Object.class);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(valueStringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(valueStringRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    public static Set<String> keys(String pattern) {
        return doWithConnection((redisTemplate, k) -> scanKeys(redisTemplate, pattern), null);
    }

    public static <T> T doWithConnection(BiFunction<RedisTemplate, String, T> f, String key) {
        return doWithConnection(f, key, false, true);
    }

    public static <T> T doWithConnection(BiFunction<RedisTemplate, String, T> f, String key, Boolean forceLock, Boolean needLock) {
        try {
            return f.apply(createRedisTemplate(), key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Set<String> scanKeys(RedisTemplate redisTemplate, String pattern) {
        logger.info("pattern is {}", pattern);
        List<String> keys = new ArrayList<>();
        redisTemplate.execute((RedisCallback<Void>) connection -> {
            ScanOptions options = ScanOptions.scanOptions().match(pattern).count(256).build();
            try (Cursor<byte[]> cursor = connection.scan(options)) {
                while (cursor.hasNext()) {
                    keys.add(new String(cursor.next()));
                }
            }
            return null;
        });
        return new HashSet<>(keys);
    }

}
