package com.app.elib.dao;

import java.util.List;

import com.app.elib.bean.User;

public interface UserDao {

	public void saveUser(User user) throws Exception;
	
	public List<User> getAllUsers() throws Exception;
	
	public User loginUser(User user) throws Exception; 
}
