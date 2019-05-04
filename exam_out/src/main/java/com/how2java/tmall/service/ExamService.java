package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Exam;

public interface ExamService {

	public void add(Exam exam);
	
	public Exam findByName(String name);
	
	public List<Exam> list(int userid);
}
