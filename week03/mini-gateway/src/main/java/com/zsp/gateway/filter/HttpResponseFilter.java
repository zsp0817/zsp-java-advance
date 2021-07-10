package com.zsp.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by zhangshaopeng on 2021/7/10.
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);
}
