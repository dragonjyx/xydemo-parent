package com.xydemo.fallback;

import com.xydemo.model.OrderParams;
import com.xydemo.model.OrderResp;
import com.xydemo.service.OrderService;
import com.xydemo.utils.base.BaseResp;
import org.springframework.stereotype.Component;

/**
 * 熔断
 */
@Component
public class OrderServiceFallback implements OrderService {


    @Override
    public BaseResp<OrderResp> generateGoodsOrder(OrderParams orderParams) {
        return BaseResp.error("生成订单失败");
    }
}
