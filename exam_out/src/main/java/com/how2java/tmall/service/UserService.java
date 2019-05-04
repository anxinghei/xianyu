package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.User;

public interface UserService {

	public User findById(int id);
	
	public List<User> findByName(String name);
	
	public void addUser(User user );
}
