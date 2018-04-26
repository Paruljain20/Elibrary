package com.app.elib.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.elib.bean.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

}
