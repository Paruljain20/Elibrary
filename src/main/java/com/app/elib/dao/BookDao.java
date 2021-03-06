package com.app.elib.dao;

import java.util.List;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.bean.User;

public interface BookDao {

	public void saveBook(Book book) throws Exception;
	
	public List getListOfBook() throws Exception;
	
	public boolean addToWishList(BookWishList wishList) throws Exception;
	
	public boolean isAddedInWishList(int userId, int bookId);
	
	public List getBookCategory();
	
	public Book getBookById(int bid) throws Exception;
	
	public List getBookListByUserId(int uid) throws Exception;
	
	public boolean removeToWishList(int bookId, int userId) throws Exception;
	
	public List getBookListWithPage(int pageId, int total);
	
}
