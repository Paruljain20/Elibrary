package com.app.elib.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.elib.bean.User;
import com.app.elib.dao.UserDao;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User save(User user) throws Exception {
		userDao.saveUser(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		List<User> list = userDao.getAllUsers();
		return list;
	}

	@Override
	public User loginUser(User user) throws Exception {
		User result = userDao.loginUser(user);
		return result;
	}
	
}
