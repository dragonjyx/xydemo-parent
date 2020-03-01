package com.xydemo.service.api;

import com.xydemo.model.GoodsResp;

public interface GoodsService {

    /**
     * 查询订单
     * @param id
     * @return
     */
    GoodsResp queryGoods(String id);

}
