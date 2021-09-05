package com.zsp.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 * Created by zhangshaopeng on 2021/9/3.
 */
@Configuration
public class Locker {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean lock(String key, String value, long expireTime) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 解锁
     *
     * @param key
     * @return
     */
    public boolean unlock(String key) {
        return redisTemplate.delete(key);
    }
}
