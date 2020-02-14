package com.demo.factory;

import com.demo.model.*;

/**
 * 果汁工厂
 */
public class JuiceFactory implements FruitShopFactory{

    //材料
    private Source source;

    //水果
    private Fruit fruit;

    //机器
    private Machine machine;

    //果汁名称
    private String juiceName;

    public static JuiceFactory juiceFactory(){
        return new JuiceFactory();
    }

    @Override
    public JuiceFactory prepareSource(String fruitName, Integer fruitSize, ColorEnums fruitColor,
                              Integer sourceSize, String sourceName,
                              String machineName,
                              String juiceName) {
        //准备水果
        fruit = new Fruit();
        fruit.setColor(fruitColor);
        fruit.setName(fruitName);
        fruit.setSize(fruitSize);
        //准备水
        source = new Source();
        source.setName(sourceName);
        source.setSize(sourceSize);
        //准备机器
        machine = new Machine();
        machine.setName(machineName);
        //放水果，放水
        machine.setFruitAndSource(fruit,source);

        this.juiceName = juiceName;

        return this;
    }

    @Override
    public FruitJuice makeJuice() {
        FruitJuice fruitJuice = machine.makeJuice(this.juiceName);
        return fruitJuice;
    }
}
