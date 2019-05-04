package com.how2java.tmall.pojo;

public class Category {
    private Integer id;

    private String name;

    private Short subid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getSubid() {
        return subid;
    }

    public void setSubid(Short subid) {
        this.subid = subid;
    }
}