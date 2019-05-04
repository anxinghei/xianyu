package com.how2java.tmall.pojo;

public class Examitems {

	private int id;
	private String content;
	private int examid;
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return this.content;
	}
	@Override
	public String toString() {
		return "Examitems [id=" + this.id + ", content=" + this.content + ", examid=" + this.examid + "]";
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getExamid() {
		return this.examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
}
