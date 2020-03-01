package com.xydemo.controller;

import com.xydemo.model.OrderParams;
import com.xydemo.service.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description 测试dubbo client
 * @date 2020/2/26 15:42
 * @blame 仓储开发组
 **/
@Slf4j
@RestController
public class TestController {

    @Reference(version = "1.0.0",filter = "sentinel.dubbo.consumer.filter")
    private OrderService orderService;

    @GetMapping("order/gen")
    public String doOrder(HttpServletRequest request){
        OrderParams orderParams = new OrderParams();
        orderParams.setCount(100);
        orderParams.setCustomerUserId("2345678klafgrfad");
        orderParams.setGoodsId("3242678sarete");
        orderParams.setGoodsName("苹果");
        orderParams.setPrice(new BigDecimal(5.0f));
        String orderId = orderService.generateGoodsOrder(orderParams);
        return orderId;
    }

}
