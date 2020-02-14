package com.demo.factory;

import com.demo.model.*;

/**
 * 水果店工厂
 */
public interface FruitShopFactory {

    /**
     * 准备原材料
     */
    JuiceFactory prepareSource(String fruitName,Integer fruitSize,ColorEnums fruitColor,
                       Integer sourceSize,String sourceName, String machineName,String name);

    /**
     * 做果汁
     * @return
     */
    FruitJuice makeJuice();


}
