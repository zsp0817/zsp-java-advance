package com.zsp.springbean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by zhangshaopeng on 2021/7/25.
 */
@Data
@Component("item")
public class OrderItem {

    @Value("A002HS1S")
    private String sku;

    @Value("100.00")
    private BigDecimal amount;

    @Value("1")
    private Integer num;
}
