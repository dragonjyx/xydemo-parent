package com.xydemo.service.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/2/26 15:18
 * @blame 仓储开发组
 **/
@Data
public class OrderParams implements Serializable {
    //商品名称
    private String goodsName;
    //商品id
    private String goodsId;
    //单价
    private BigDecimal price;
    //购买数量
    private Integer count;
    //客户id
    private String customerUserId;
}
