package com.demo.model;

public class Source {

    private Integer size;
    private String name;

    public Source() {
        super();
    }

    public Source(Integer size, String name) {
        this.size = size;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Source{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
