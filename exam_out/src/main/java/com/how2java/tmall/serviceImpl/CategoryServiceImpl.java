package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.CategoryExample;
import com.how2java.tmall.pojo.Subject;
import com.how2java.tmall.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categorymapper;
	
	@Override
	public List<Category> lists(short subid) {
		CategoryExample example=new CategoryExample();
		example.createCriteria().andSubidEqualTo(subid);
		return categorymapper.selectByExample(example);
	}

	@Override
	public Category findById(int cateId) {
		return categorymapper.selectByPrimaryKey(cateId);
	}

}
