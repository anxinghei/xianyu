package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.ExamMapper;
import com.how2java.tmall.pojo.Exam;
import com.how2java.tmall.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamMapper exammapper;
	
	@Override
	public void add(Exam exam) {
		exammapper.add(exam);
	}
	
	@Override
	public Exam findByName(String name) {
		return exammapper.findByName(name);
	}
	
	@Override
	public List<Exam> list(int userid) {
		return exammapper.list(userid);
	}

	@Override
	public Exam findById(int id) {
		return exammapper.findById(id);
	}
}
