package com.zsp.httpstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zhangshaopeng on 2021/7/25.
 */
@Data
@ConfigurationProperties(prefix = "zsp.http")
public class HttpProperties {

    //    private Properties props = new Properties();
    private String url = "http://www.baidu.com/";
}
