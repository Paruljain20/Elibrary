package com.app.elib.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.bean.User;
import com.app.elib.service.BookService;

@Controller
public class BookController {
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Autowired
    BookService bookService;
	
	@RequestMapping(value="/allBook", method=RequestMethod.GET)
	public ModelAndView allBooks(@ModelAttribute("book") Book book, ModelAndView model){
		model.setViewName("allBook");
		return model;
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public ModelAndView addBookForm(@ModelAttribute("book") Book book, ModelAndView model){
		model.setViewName("addbook");
		return model;
	}
	
	@RequestMapping(value="/saveBook", method=RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book, @RequestParam("file") MultipartFile file, ModelAndView model){
		Book result = null;
		try {
			result = bookService.save(book, file);
			model.addObject("bookObj", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result != null)
		   return new ModelAndView("redirect:/loadBooks");
		else
			model.setViewName("addbook");
		return model;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/loadBooks")
	public ModelAndView loadBookList(ModelAndView model){
		List<Book> listOfBook = null;
		try {
			listOfBook = bookService.getAllBookList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("list", listOfBook);
		model.setViewName("allBook");
		return model;
	}
	
	@RequestMapping(value="/addBookToWishList", method=RequestMethod.GET)
	public String addBookToWishList(@RequestParam(value="ebid") int id, HttpSession session){
		User user = (User) session.getAttribute("user");
		Date currentDate = new Date();
		int userId = user.getId();
		boolean result;
		BookWishList bookWishList =  new BookWishList();
		bookWishList.setBookId(id);
		bookWishList.setUserId(userId);
		bookWishList.setDate(currentDate);
		try {
			result = bookService.addToWishList(bookWishList);
			return "true";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "false";
		}
		
	}
	
}
