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
	public Book getBookById(int bid) throws Exception {
		try{
			@SuppressWarnings("unchecked")
			Book result = (Book) sessionFactory.getCurrentSession().createQuery("FROM Book WHERE ebid = :bid").setLong("bid", bid).uniqueResult();
			if(result != null)
				return result;
		}catch(Exception e){
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<BookWishList> getBookListByUserId(int uid) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<BookWishList> result = (List<BookWishList>) sessionFactory.getCurrentSession().createQuery("FROM BookWishList WHERE userId = :userId").setInteger("userId", uid).list();
		    if(result != null)
		    	return result;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean removeToWishList(int bookId, int userId ) throws Exception {
		try{
			sessionFactory.getCurrentSession().createQuery("DELETE FROM BookWishList WHERE bookId = :bookId AND userId = :userId")
			.setInteger("bookId", bookId)
			.setInteger("userId", userId)
			.executeUpdate();
		    return true;
		}catch(Exception ex){
			ex.getMessage();
		}
		return false;
	}

}
