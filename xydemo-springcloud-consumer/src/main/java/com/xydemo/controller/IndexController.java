package com.xydemo.controller;


import com.xydemo.model.OrderParams;
import com.xydemo.model.OrderResp;
import com.xydemo.service.OrderService;
import com.xydemo.utils.base.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class IndexController {


    @Autowired
    private OrderService orderService;


    @GetMapping("myorder/gen/{count}")
    public BaseResp orderGen(@PathVariable Integer count){
        OrderParams orderParams = new OrderParams();
        orderParams.setCount(count);
        orderParams.setCustomerUserId("2345678klafgrfad");
        orderParams.setGoodsId("3242678sarete");
        orderParams.setGoodsName("苹果");
        orderParams.setPrice(new BigDecimal(5.0f));

        BaseResp<OrderResp> resp = orderService.generateGoodsOrder(orderParams);
        if(!resp.isSuccess()){
            return BaseResp.success(resp.getMessage());
        }
        OrderResp orderResp = resp.getData();

        log.warn("orderResp:{}",orderResp);
        return BaseResp.success(orderResp.getOrderId());
    }




}
