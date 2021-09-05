package com.zsp.redis.api;

import com.zsp.redis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangshaopeng on 2021/9/3.
 */
@RestController
@RequestMapping("/object")
public class RedisObjectController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 新增缓存
     *
     * @param username
     * @param nickname
     */
    @PutMapping("/put")
    public void put(@RequestParam String username,
                    @RequestParam String nickname) {
        User user = new User(username, nickname);
        redisTemplate.opsForValue().set(username, user);
    }

    /**
     * 获取缓存
     *
     * @param username
     * @return
     */
    @GetMapping("/get/{username}")
    public Object get(@PathVariable String username) {
        return redisTemplate.opsForValue().get(username);
    }
}
