package com.app.elib.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.Book;
import com.app.elib.service.BookService;

@Controller
public class BookController {
	
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
	
	@RequestMapping(value="/addBookToWishList", method=RequestMethod.POST)
	public ModelAndView addBookToWishList(@RequestParam(value="param1", required=true) String param1, ModelAndView model){
		return model;
	}
	

}
