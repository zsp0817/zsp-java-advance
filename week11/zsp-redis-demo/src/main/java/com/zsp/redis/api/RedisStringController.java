package com.zsp.redis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangshaopeng on 2021/9/3.
 */
@RestController
@RequestMapping("/string")
public class RedisStringController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 新增缓存
     *
     * @param key
     * @param value
     */
    @PutMapping(value = "/put")
    public void put(@RequestParam String key,
                    @RequestParam String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    @GetMapping(value = "/get")
    public Object get(@RequestParam String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
