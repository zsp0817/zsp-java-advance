package com.zsp.gateway.inbound;

import com.zsp.gateway.filter.HeaderHttpRequestFilter;
import com.zsp.gateway.filter.HeaderHttpResponseFilter;
import com.zsp.gateway.filter.HttpRequestFilter;
import com.zsp.gateway.filter.HttpResponseFilter;
import com.zsp.gateway.outbound.HttpOutboundHandler;
import com.zsp.gateway.outbound.OutboundHandler;
import com.zsp.gateway.router.HttpEndpointRouter;
import com.zsp.gateway.router.RandomHttpEndpointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by zhangshaopeng on 2021/7/9.
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private List<String> proxyServers;
    private OutboundHandler handler;
    private HttpRequestFilter requestFilter = new HeaderHttpRequestFilter();
    private HttpResponseFilter responseFilter = new HeaderHttpResponseFilter();
    private HttpEndpointRouter router = new RandomHttpEndpointRouter();

    public HttpInboundHandler(List<String> proxyServers) {
        this.proxyServers = proxyServers;
        this.handler = new HttpOutboundHandler();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest) msg;
        requestFilter.filter(request, ctx); // 添加请求的过滤器

        String uri = request.getUri();
        if (uri.contains("/proxy")) {
            String body = handler.handle(router.route(proxyServers));
            handlerTest(request, ctx, body);
        } else {
            handlerTest(request, ctx, "Hello, others");
        }
    }

    private void handlerTest(FullHttpRequest request, ChannelHandlerContext ctx, String body) {
        FullHttpResponse response = null;

        try {
            String value = body;
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());
            responseFilter.filter(response);    // 添加响应的过滤器
        } catch (Exception e) {
            System.out.println("处理出错:" + e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (response != null) {
                if (!HttpUtil.isKeepAlive(response)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
                ctx.flush();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
