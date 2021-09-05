package com.zsp.redis.api;

import com.zsp.redis.util.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangshaopeng on 2021/9/3.
 */
@RestController
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    private Counter counter;

    /**
     * 递增
     *
     * @param key
     * @return
     */
    @PostMapping("increase")
    public Long increase(@RequestParam String key) {
        return counter.increase(key);
    }

    /**
     * 递减
     *
     * @param key
     * @return
     */
    @PostMapping("decrease")
    public Long decrease(@RequestParam String key) {
        return counter.decrease(key);
    }
}
