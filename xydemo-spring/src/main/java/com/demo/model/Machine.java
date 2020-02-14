package com.demo.model;

public class Machine {

    private String name;

    //材料
    private Source source;

    //水果
    private Fruit fruit;


    public void setName(String name) {
        this.name = name;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void setFruitAndSource(Fruit fruit, Source source) {
        this.fruit = fruit;
        this.source = source;
    }

    public FruitJuice makeJuice(String name){
        String res = name + "好了：使用了" + this.fruit.getColor().getDesc() + "、" + this.fruit.getSize() + "克的"
                + this.fruit.getName() + ",和"+this.source.getSize()+"克"+this.source.getName()
                + "制作";
        FruitJuice fruitJuice = new FruitJuice(res);
        return fruitJuice;
    }



}
