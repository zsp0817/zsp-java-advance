package com.zsp.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * Created by zhangshaopeng on 2021/7/10.
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {

    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
