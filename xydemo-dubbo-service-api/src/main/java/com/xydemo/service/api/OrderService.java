package com.xydemo.service.api;


import com.xydemo.model.OrderParams;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description 订单服务
 * @date 2020/2/26 15:16
 * @blame 仓储开发组
 **/
public interface OrderService {

    /**
     * 生成订单
     * @param orderParams
     * @return
     */
    String generateGoodsOrder(OrderParams orderParams);




}
