package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.SubjectMapper;
import com.how2java.tmall.pojo.Subject;
import com.how2java.tmall.pojo.SubjectExample;
import com.how2java.tmall.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> list() {
		SubjectExample subjectExample=new SubjectExample();
		subjectExample.setOrderByClause("id ASC");
		return subjectMapper.selectByExample(subjectExample);
	}
}
