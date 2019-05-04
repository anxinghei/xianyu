package com.how2java.tmall.pojo;

public class User {
    private Integer id;

    private String name;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getSubid() {
        return subid;
    }

    public void setSubid(Short subid) {
        this.subid = subid;
    }

	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", subid=" + this.subid
				+ "]";
	}
}