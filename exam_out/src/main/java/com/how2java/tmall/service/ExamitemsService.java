package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Examitems;

public interface ExamitemsService {

	public void add(Examitems examitems);
	
	public List<Examitems> list(int examid);
}
