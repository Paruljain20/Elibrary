package com.app.elib.service;

import java.util.List;

import com.app.elib.bean.User;

public interface UserService {
	public User save(User user) throws Exception;
	
	public List<User> getAllUsers() throws Exception;
	
	public User loginUser(User user) throws Exception;

	public boolean validateEmail(String email);
	
	public String getUserEmail(String email);
	
	public Integer editUserPassword(String email, String password) throws Exception;

}
