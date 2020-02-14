package com.demo.model;

public class FruitJuice {


    private String name;

    public FruitJuice(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFruitJuice() {
        System.out.println(name);
        return name;
    }

    @Override
    public String toString() {
        return "FruitJuice{" +
                "name='" + name + '\'' +
                '}';
    }
}
