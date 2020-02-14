package com.demo.test.modern;

import com.demo.factory.FruitShopFactory;
import com.demo.factory.JuiceFactory;
import com.demo.model.*;
import org.junit.Test;

/**
 * 使用工厂模式去实现
 */
public class FactoryMakeJuiceTest {


    @Test
    public void testMakeJuice(){
        //实现工厂
        FruitShopFactory fruitShopFactory = JuiceFactory.juiceFactory()
                .prepareSource("橙子",200,ColorEnums.ORANGE,
                500,"水",
                "果汁机","橙汁");

        //制作果汁
        FruitJuice fruitJuice = fruitShopFactory.makeJuice();

        //获取橙汁
        fruitJuice.getFruitJuice();
    }





}
