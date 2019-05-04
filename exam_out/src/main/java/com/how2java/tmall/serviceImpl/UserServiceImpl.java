package com.how2java.tmall.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper usermapper;
	
	@Override
	public User findById(int id) {
		return usermapper.selectByPrimaryKey(id); 
	}
	@Override
	public List<User> findByName(String name) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andNameEqualTo(name);
		List<User> users= usermapper.selectByExample(userExample);
		return users;
	}
	@Override
	public void addUser(User user) {
		usermapper.insert(user);
	}
}
