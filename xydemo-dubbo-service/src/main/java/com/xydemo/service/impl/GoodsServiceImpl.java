package com.xydemo.service.impl;

import com.xydemo.model.GoodsResp;
import com.xydemo.service.api.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Slf4j
@Path("goods")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON})
@Service(version = "1.0.0",protocol = {"dubbo","rest"})
public class GoodsServiceImpl implements GoodsService {


    @GET
    @Path("query/{id}")
    @Override
    public GoodsResp queryGoods(@PathParam("id") String id) {
        GoodsResp goodsResp = new GoodsResp();
        goodsResp.setGoodsId(id);
        goodsResp.setName("鞋子");
        goodsResp.setRemark("restful测试");
        return goodsResp;
    }


}
