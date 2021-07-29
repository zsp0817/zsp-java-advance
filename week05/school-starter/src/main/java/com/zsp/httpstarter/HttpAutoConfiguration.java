package com.zsp.httpstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by zhangshaopeng on 2021/7/26.
 */
@Configuration
@EnableConfigurationProperties(HttpProperties.class)
//@ConditionalOnProperty(prefix = "zsp.school",value="enabled",matchIfMissing = true)
public class HttpAutoConfiguration {

    @Resource
    private HttpProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public HttpClient init() {
        HttpClient client = new HttpClient();

        String url = properties.getUrl();
        client.setUrl(url);
        return client;
    }
}
