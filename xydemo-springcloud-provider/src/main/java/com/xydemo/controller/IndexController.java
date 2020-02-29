package com.xydemo.controller;


import com.xydemo.model.OrderParams;
import com.xydemo.model.OrderResp;
import com.xydemo.utils.base.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class IndexController {

    @Value("${server.port}")
    private int port;

    @PostMapping(value = "order/gen")
    public BaseResp<OrderResp> generateGoodsOrder(@Validated @RequestBody OrderParams orderParams) {
        log.warn("request orderParams:{}", orderParams.toString());
        String orderId = UUID.randomUUID().toString().replace("-", "");
        OrderResp orderResp = new OrderResp();
        orderResp.setOrderId(orderId);
        orderResp.setRemark("port:" + port);
        return BaseResp.success(orderResp);
    }


}
