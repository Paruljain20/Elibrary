package com.app.elib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;

@Repository
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBook(Book book) throws Exception {
		  sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	@Override
	public List getListOfBook() throws Exception {
		try{
		List<Book> list= sessionFactory.getCurrentSession().createQuery("FROM Book ORDER BY ebid desc").list();
		return list;
		}
		catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	@Override
	public boolean addToWishList(BookWishList wishList) throws Exception {
		 sessionFactory.getCurrentSession().saveOrUpdate(wishList);
		return true;
	}

	@Override
	public boolean isAddedInWishList(int userId, int bookId) {
		Object result =  sessionFactory.getCurrentSession()
				.createQuery("SELECT 1 FROM BookWishList WHERE userId = :userId AND bookId = :bookId")
				.setInteger("userId", userId).setInteger("bookId", bookId).uniqueResult();
				if(result != null){
					return true;
				}
		return false;
	}

	@Override
	public List getBookCategory() {
		try{
		List result = sessionFactory.getCurrentSession().createQuery("FROM Category ORDER BY id").list();
		if(result != null){
			return result;
		}
		}catch(NullPointerException e){
			e.getMessage();
		}
		return null;
	}

	@Override
	public List getBookById(int bid) throws Exception {
		try{
			List result = (List) sessionFactory.getCurrentSession().byId("Book");
			if(result != null)
				return result;
		}catch(Exception e){
			e.getMessage();
		}
		return null;
	}

	@Override
	public List getBookListByUserId(int uid) throws Exception {
		try {
			List result = (List) sessionFactory.getCurrentSession().createQuery("SELECT * FROM BookWishList WHERE userId: uid").setInteger("uid", uid);
		    if(result != null)
		    	return result;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

}
