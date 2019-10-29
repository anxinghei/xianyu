package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;

public interface CategoryService {

	public List<Category> lists(short subid);
	
	public Category findById(int cateId);
}
