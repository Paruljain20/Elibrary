package com.app.elib.dao;

import java.util.List;

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

}
