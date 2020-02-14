package com.demo.test.traditional;

import com.demo.model.*;
import org.junit.Test;

public class MakeJuiceTest {


    @Test
    public void testMakeJuice(){
        //准备水果
        Fruit fruit = new Fruit();
        fruit.setColor(ColorEnums.ORANGE);
        fruit.setName("橙子");
        fruit.setSize(200);
        //准备水
        Source source = new Source();
        source.setName("水");
        source.setSize(500);
        //准备机器
        Machine machine = new Machine();
        machine.setName("果汁机");
        //放水果，放水
        machine.setFruitAndSource(fruit,source);

        //制作果汁
        FruitJuice fruitJuice = machine.makeJuice("橙汁");

        //获取橙汁
        fruitJuice.getFruitJuice();
    }



}
