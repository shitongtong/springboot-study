package cn.stt.service;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

/**
 * @ClassName RedissonService
 * @Description TODO
 * @Author shitt7
 * @Date 2019/10/23 15:53
 * @Version 1.0
 */
public class RedissonService {

    private RedissonClient redissonClient;

    public RedissonService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public String test() {
        return "test";
    }

    public String get(String key) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    public void set(String key, String value) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }
}
