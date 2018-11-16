package com.app.elib.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;

public interface BookService {
	
	public Book save(Book book, MultipartFile file) throws Exception;
	
	public String fileUpload(MultipartFile file) throws Exception;
	
	public List getAllBookList() throws Exception;
	 
	public boolean addToWishList(BookWishList wishList) throws Exception;
	
	public boolean isAddedInWishList(int userId, int bookId);
	
	public List getBookCategory() throws Exception;
	
	public Book getBookById(int bid) throws Exception;
	
	public List getBookListByUserId(int uid) throws Exception;
	
	public boolean removeToWishList(int bookId, int userId) throws Exception;
	
}
