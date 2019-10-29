package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.QuestionMapper;
import com.how2java.tmall.pojo.Question;
import com.how2java.tmall.pojo.QuestionExample;
import com.how2java.tmall.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionMapper questionmapper;
	
	@Override
	public List<Question> list(short catid) {
		QuestionExample example=new QuestionExample();
		example.createCriteria().andCatidEqualTo(catid);
		return questionmapper.selectByExampleWithBLOBs(example);
	}
	
	@Override
	public Question findById(int id) {
		return questionmapper.selectByPrimaryKey(id);
	}

	@Override
	public void addQuestion(short catid,String question) {
		Question record=new Question();
		record.setCatid(catid);
		record.setContent(question);
		questionmapper.insert(record);
	}
}
