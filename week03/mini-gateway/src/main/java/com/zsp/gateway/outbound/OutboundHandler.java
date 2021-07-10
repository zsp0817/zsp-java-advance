package com.zsp.gateway.outbound;

/**
 * Created by zhangshaopeng on 2021/7/9.
 */
public interface OutboundHandler {

    String handle(String url);
}
