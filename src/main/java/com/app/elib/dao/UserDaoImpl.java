package com.app.elib.dao;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<User> getAllUsers() throws Exception {
		@SuppressWarnings("unchecked")
		List<User> result = sessionFactory.getCurrentSession().createQuery("from User").list();
		return result;
	}

	@Override
	public User loginUser(User user) throws Exception {
		 User result = (User) sessionFactory.getCurrentSession().createQuery(" from User where email = :email and password = :password")
		.setString("email", user.getEmail())
		.setString("password", user.getPassword()).uniqueResult();
		 return result;
	}

	@Override
	public boolean validateEmail(String email) {
		try{
		Object result = sessionFactory.getCurrentSession().createQuery("select 1 from User where email = :email")
				.setString("email", email).uniqueResult();
		if(result == null)
			return false;
		else
			return true;
		}
		catch(NullPointerException e){
			e.getMessage();
			return false;
		}
	}

	@Override
	public String getUseremail(String email) {
		try{
		String result = (String) sessionFactory.getCurrentSession().createQuery("select email from User where email = :email")
				.setString("email", email)
				.uniqueResult();
		return result;
		}catch(NullPointerException e){
			e.getMessage();
			return null;
		}
	}

	@Override
	public Integer editUserPassword(String email, String password) throws Exception {
		Integer result = sessionFactory.getCurrentSession().createQuery("update User set password = :password where email = :email")
				.setString("email", email)
				.setString("password", password)
				.executeUpdate();
		return result;
	}

	
}
