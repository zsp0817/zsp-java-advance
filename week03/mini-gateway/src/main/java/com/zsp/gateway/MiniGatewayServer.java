package com.zsp.gateway;

import com.zsp.gateway.inbound.HttpInboundServer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangshaopeng on 2021/7/9.
 */
public class MiniGatewayServer {

    /**
     * 启动参数：18888 http://localhost:8801,http://localhost:8802
     * 即监听18888端口
     * 作为本地8801和8802两个服务的网关
     * @param args
     */
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        List<String> proxyServers = Arrays.asList(args[1].split(","));

        HttpInboundServer server = new HttpInboundServer(port, proxyServers);
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
