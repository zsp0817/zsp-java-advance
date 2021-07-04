package com.zsp;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

/**
 * Created by zhangshaopeng on 2021/7/3.
 * 参考：http://hc.apache.org/httpcomponents-client-5.1.x/quickstart.html
 */
public class HttpClient {

    private static final String SERVER_URL = "http://localhost:8801";

    public static void main(String[] args) throws IOException, ParseException {

//        // 使用HttpClient fluent API，简化代码
//        Content content = Request.get("http://localhost:8801")
//                .execute().returnContent();
//        System.out.println(content.asString());

        // 使用HttpClient API
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(SERVER_URL);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity, "UTF-8");
                System.out.println(body);
            }
        }

    }
}
