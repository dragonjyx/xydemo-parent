package com.xydemo.service.impl;

import com.xydemo.service.api.OrderService;
import com.xydemo.service.model.OrderParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/2/26 15:24
 * @blame 仓储开发组
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String generateGoodsOrder(OrderParams orderParams) {
        log.warn("request orderParams:{}",orderParams.toString());
        String orderId = UUID.randomUUID().toString().replace("-","");
        return orderId;
    }

}
