package com.how2java.tmall.pojo;

import java.util.List;

public class Exam {

	private int id;
	private String name;
	private int userid;
	private int catid;
	
	@Override
	public String toString() {
		return "Exam [id=" + this.id + ", name=" + this.name + ", userid=" + this.userid + ", catid=" + this.catid
				+ "]";
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return this.userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCatid() {
		return this.catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
}
