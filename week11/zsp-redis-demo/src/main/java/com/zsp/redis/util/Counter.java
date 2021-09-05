package com.zsp.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 分布式计数器
 * Created by zhangshaopeng on 2021/9/3.
 */
@Configuration
public class Counter {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 递增
     *
     * @param key
     * @return
     */
    public Long increase(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * 递减
     *
     * @param key
     * @return
     */
    public Long decrease(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }
}
