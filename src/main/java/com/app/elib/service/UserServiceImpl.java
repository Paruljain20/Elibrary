package com.app.elib.service;

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
}
