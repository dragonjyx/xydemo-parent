package com.xydemo.service;


import com.xydemo.fallback.OrderServiceFallback;
import com.xydemo.model.OrderParams;
import com.xydemo.model.OrderResp;
import com.xydemo.utils.base.BaseResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * feign client
 */
@FeignClient(value = "xydemo-springcloud-provider" , fallback = OrderServiceFallback.class)
public interface OrderService {


    @PostMapping(value = "order/gen")
    BaseResp<OrderResp> generateGoodsOrder(OrderParams orderParams);


}
