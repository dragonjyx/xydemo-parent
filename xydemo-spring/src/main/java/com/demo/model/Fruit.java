package com.demo.model;

/**
 * 水果
 */
public class Fruit {

    /**
     * 名称
     */
    private String name;

    /**
     * 颜色
     */
    private int size;

    /**
     * 大小
     */
    private ColorEnums color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ColorEnums getColor() {
        return color;
    }

    public void setColor(ColorEnums color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", color=" + color +
                '}';
    }
}
