package com.zsp.springbean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangshaopeng on 2021/7/25.
 */
@Data
@Component("order")
public class Order {

    @Value("SO202107252119320001")
    private String id;

    @Value("260.00")
    private BigDecimal amount;

    @Autowired
    private List<OrderItem> itemList;
}
