package com.xydemo.model;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "商品名称不能为空")
    private String goodsName;

    //商品id
    @NotNull(message = "商品ID不能为空")
    private String goodsId;

    //单价
    @DecimalMin(value = "0", message = "价格必须大于0")
    private BigDecimal price;

    //购买数量
    @Min(value = 0, message = "购买数量必须大于0")
    @Max(value = 40, message = "购买数量不能超过40")
    private Integer count;

    //客户id
    @NotNull(message = "客户ID不能为空")
    private String customerUserId;
}
