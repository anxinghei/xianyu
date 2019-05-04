package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.ExamitemsMapper;
import com.how2java.tmall.pojo.Examitems;
import com.how2java.tmall.service.ExamitemsService;

@Service
public class ExamitemsServiceimpl implements ExamitemsService{

	@Autowired
	ExamitemsMapper examitemsMapper;

	@Override
	public void add(Examitems examitems) {
		examitemsMapper.add(examitems);
	}
	
	@Override
	public List<Examitems> list(int examid) {
		return examitemsMapper.list(examid);
	}
}
