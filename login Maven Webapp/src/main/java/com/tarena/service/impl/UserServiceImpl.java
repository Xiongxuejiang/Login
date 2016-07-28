package com.tarena.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.bean.User;
import com.tarena.dao.UserDao;
import com.tarena.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	public User login(User user){
		user=userDao.selectUser(user);
		return user;
	}
	
	public void insert(User user){
		userDao.insert(user);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
