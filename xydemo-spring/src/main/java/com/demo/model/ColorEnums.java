package com.demo.model;

public enum ColorEnums {

    RED(0,"红色"),
    WHITE(1,"白色"),
    ORANGE(2,"橙色"),
    GREEN(3,"绿色");

    private int color;
    private String desc;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ColorEnums(int color, String desc) {
        this.color = color;
        this.desc = desc;
    }
}
