package com.how2java.tmall.mapper;

import java.util.List;

import com.how2java.tmall.pojo.Exam;

public interface ExamMapper {

	public void add(Exam exam);
	
	public Exam findByName(String name);
	
	public List<Exam> list(int userid);
	
	public Exam findById(int id);
}
