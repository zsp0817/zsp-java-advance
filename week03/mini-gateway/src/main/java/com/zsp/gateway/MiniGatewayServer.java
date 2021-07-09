package com.zsp.gateway;

import com.zsp.gateway.inbound.HttpInboundServer;

/**
 * Created by zhangshaopeng on 2021/7/9.
 */
public class MiniGatewayServer {

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        HttpInboundServer server = new HttpInboundServer(port);
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
