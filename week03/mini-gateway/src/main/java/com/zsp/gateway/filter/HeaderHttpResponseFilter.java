package com.zsp.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * Created by zhangshaopeng on 2021/7/10.
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {

    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("by", "mini-gateway");
    }
}
