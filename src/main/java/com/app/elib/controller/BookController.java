package com.app.elib.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.bean.Category;
import com.app.elib.bean.User;
import com.app.elib.service.BookService;
import com.app.elib.service.BookServiceImpl;

@Controller
public class BookController {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Autowired
	BookService bookService;

	BookServiceImpl bookServiceImpl = new BookServiceImpl();

	@RequestMapping(value = "/allBook", method = RequestMethod.GET)
	public ModelAndView allBooks(@ModelAttribute("book") Book book, ModelAndView model) {
		model.setViewName("allBook");
		return model;
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public ModelAndView addBookForm(@ModelAttribute("book") Book book, ModelAndView model) throws Exception {
		List bookCat = bookService.getBookCategory();
		model.addObject("catList", bookCat);
		model.setViewName("addbook");
		return model;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book, @RequestParam("file") MultipartFile file,
			ModelAndView model, HttpSession session) {
		Book result = null;
		try {
			result = bookService.save(book, file);
			model.addObject("bookObj", result);
			model.addObject("session", session.getAttribute("user"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null)
			return new ModelAndView("redirect:/loadBooks");
		else
			model.setViewName("addbook");
		return model;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loadBooks")
	public ModelAndView loadBookList(ModelAndView model, HttpSession session) throws Exception {
		List<Book> listOfBook = null;
		List<Category> listOfBookCat = null;
		try {
			listOfBook = bookService.getAllBookList();
			listOfBookCat = bookService.getBookCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("list", listOfBook);
		model.addObject("bookCatList", listOfBookCat);
		model.addObject("session", session.getAttribute("user"));
		model.setViewName("allBook");
		return model;
	}
	
	@RequestMapping(value = "/myBooks")
	public ModelAndView loadMyBooks(ModelAndView model, HttpSession session) throws Exception {
		List<Book> listOfBook = null;
		List<Category> listOfBookCat = null;
		try {
			User user = (User) session.getAttribute("user");
			int userId =  user.getId();
			listOfBook = bookService.getBookListByUserId(userId);
			listOfBookCat = bookService.getBookCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("list", listOfBook);
		model.addObject("bookCatList", listOfBookCat);
		model.setViewName("myBook");
		return model;
	}
	

	@RequestMapping(value = "/addBookToWishList", method = RequestMethod.GET)
	public ResponseEntity<String> addBookToWishList(@RequestParam(value = "ebid") int id, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			Date currentDate = new Date();
			if (user != null) {
				int userId = user.getId();
				boolean result;
				BookWishList bookWishList = new BookWishList();
				bookWishList.setBookId(id);
				bookWishList.setUserId(userId);
				bookWishList.setDate(currentDate);
				boolean isAddedToList = bookService.isAddedInWishList(userId, id);
				String responseMsg = null;
				if (isAddedToList) {
					responseMsg = "This Book Already added in wish list";
				} else {
					result = bookService.addToWishList(bookWishList);
				}
				return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
			} else {
				String errorMsg = "Please Log In First";
				return new ResponseEntity<String>(errorMsg, HttpStatus.OK);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// This method is used to load cart
	@SuppressWarnings("null")
	@RequestMapping("/gotoCart")
	public ModelAndView openCart(HttpSession session, ModelAndView model) throws Exception {
		User user = (User) session.getAttribute("user");
		Integer uid = user.getId();
		List<Book> cartList = new ArrayList<>();
		List<BookWishList> bookList = bookService.getBookListByUserId(uid);
		for (int j = 0; j < bookList.size(); j++) {
			BookWishList book = bookList.get(j);
			Book cartBook = bookService.getBookById((int) book.getBookId());
			cartList.add(cartBook);

		}
		model.addObject("bookList", cartList);
		model.addObject("session", session.getAttribute("user"));
		model.setViewName("cart");
		return model;
	}

	@RequestMapping(value = "/removeToWishList", method = RequestMethod.GET)
	public ResponseEntity<String> removeToWishList(@RequestParam(value = "ebid") int id, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				int userId = user.getId();
				Boolean result = bookService.removeToWishList(id, userId);
				if (result) {
					String responseMsg = "This Book has been removed from wish llist";
					return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		// should not reach at this point
		return null;

	}

}
