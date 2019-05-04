package com.how2java.tmall.mapper;

import java.util.List;

import com.how2java.tmall.pojo.Examitems;

public interface ExamitemsMapper {

	public void add(Examitems examitems);
	
	public List<Examitems> list(int examid);
}
