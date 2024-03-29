package com.app.elib.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.dao.BookDao;
@Service
@Transactional
public class BookServiceImpl implements BookService {
	public static String  fileName = "ebook";
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	ServletContext context;

	@Override
	public Book save(Book book, MultipartFile file) throws Exception {
		book.setEbook("C:\\my-projects\\Elibrary\\src\\main\\webapp\\WEB-INF\\books"+file.getOriginalFilename());
		bookDao.saveBook(book);
		String result = this.fileUpload(file);
		if(result  == "Success")
			return book;
		else
			return null;
	}

	@Override
	public String fileUpload(MultipartFile file) throws Exception {
		String message = null;
		if (!file.isEmpty()) {
			try {
				 BufferedOutputStream outputStream = new BufferedOutputStream(
			               new FileOutputStream(
			                     new File("C:\\my-projects\\Elibrary\\src\\main\\webapp\\WEB-INF\\books", file.getOriginalFilename())));
			         outputStream.write(file.getBytes());
			         outputStream.flush();
			         outputStream.close();
				     message = "Success";

				return message;
			} catch (Exception e) {
				return "You failed to upload " + fileName + " => " + e.getMessage();
			}
		}else{
			message = "Failed";
		}
		return message;
	}

	@Override
	public List getAllBookList() throws Exception {
		try{
		List<Book> list = bookDao.getListOfBook();
		return list;
		}catch(Exception e){
			e.getMessage();
			return null;
		}
	}

	@Override
	public boolean addToWishList(BookWishList wishList) throws Exception {
		bookDao.addToWishList(wishList);
		return true;
	}

	@Override
	public boolean isAddedInWishList(int userId, int bookId){
		boolean result = bookDao.isAddedInWishList(userId, bookId);
		if (result){
			return true;
		}
		return false;
	}
	
	@Override
	public List getBookCategory(){
	try{
	  List result = bookDao.getBookCategory();
	  if(result != null){
		  return result;
	  }
		}catch(Exception e){
			e.getMessage();
		}
	  return null;
	}

	@Override
	public Book getBookById(int bid) throws Exception {
	   try {
		Book result = bookDao.getBookById(bid);
		return result;
	} catch (Exception e) {
		e.getMessage();
	}
		return null;
	}

	@Override
	public List<BookWishList> getBookListByUserId(int uid) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<BookWishList> result = bookDao.getBookListByUserId(uid);
			return result;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean removeToWishList(int bookId, int userId) throws Exception {
		bookDao.removeToWishList(bookId, userId);
		return true;
	}

	@Override
	public List getBookListWithPage(int pageId, int total) {
		List list = bookDao.getBookListWithPage(pageId, total);
		return list;
	}

}
