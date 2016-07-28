package com.tarena.service;

import com.tarena.bean.User;

public interface UserService {
	public User getUserById(int userId);
	
	public User login(User user);
	
	public void insert(User user);
}
