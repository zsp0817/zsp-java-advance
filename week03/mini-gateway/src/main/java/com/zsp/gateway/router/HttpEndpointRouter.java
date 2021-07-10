package com.zsp.gateway.router;

import java.util.List;

/**
 * Created by zhangshaopeng on 2021/7/10.
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);
}
