package com.zsp.redis.api;

import com.zsp.redis.util.Locker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangshaopeng on 2021/9/3.
 */
@RestController
@RequestMapping("/locker")
public class LockerController {

    @Autowired
    private Locker locker;

    /**
     * 加锁
     *
     * @param key
     * @param value
     * @return
     */
    @PutMapping("/lock")
    public String lock(@RequestParam String key,
                       @RequestParam String value) {
        return locker.lock(key, value, 1800L) ? "SUCCESS" : "FAIL";
    }

    /**
     * 解锁
     *
     * @param key
     * @return
     */
    @DeleteMapping("/unlock")
    public String unlock(@RequestParam String key) {
        return locker.unlock(key) ? "SUCCESS" : "FAIL";
    }
}
