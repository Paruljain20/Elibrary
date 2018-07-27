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
	
	//@Autowired
	ServletContext context;

	@Override
	public Book save(Book book, MultipartFile file) throws Exception {
		book.setEbook(context.getRealPath("/WEB-INF/books/")+file.getOriginalFilename());
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
			                     new File(context.getRealPath("/WEB-INF/books"), file.getOriginalFilename())));
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
	public String saveToWishList(int userId, int bookId) {
	   
		return null;
	}

}
