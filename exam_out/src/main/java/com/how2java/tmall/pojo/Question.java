package com.how2java.tmall.pojo;

public class Question {
    private Integer id;

    private Short catid;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCatid() {
        return catid;
    }

    public void setCatid(Short catid) {
        this.catid = catid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Question [id=" + this.id + ", catid=" + this.catid + ", content=" + this.content + "]";
	}
}