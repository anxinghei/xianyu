package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Question;

public interface QuestionService {

	public List<Question> list(short catid);
	
	public Question findById(int id);
	
	public void addQuestion(short catid,String question);
}
