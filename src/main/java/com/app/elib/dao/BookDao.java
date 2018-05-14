package com.app.elib.dao;

import java.util.List;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.bean.User;

public interface BookDao {

	public void saveBook(Book book) throws Exception;
	
	public List getListOfBook() throws Exception;
	
	public boolean addToWishList(BookWishList wishList) throws Exception;
 
}
