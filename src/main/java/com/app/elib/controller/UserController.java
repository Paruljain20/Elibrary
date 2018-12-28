package com.app.elib.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.Book;
import com.app.elib.bean.BookWishList;
import com.app.elib.bean.User;
import com.app.elib.service.BookService;
import com.app.elib.service.EmailService;
import com.app.elib.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private BookService bookService;
	
	// This method is used to open index page
	@RequestMapping("/")
	public ModelAndView index(ModelAndView model, HttpSession session) {
		List <Book> bookwishList = null;
		User user = (User) session.getAttribute("user");
		if(user != null){
		Integer uid = user.getId();
		if(uid != null){
		try {
			bookwishList = bookService.getBookListByUserId(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		}
		model.setViewName("index");
		model.addObject("bookList", bookwishList);
		model.addObject("session", session.getAttribute("user"));
		return model;
	}

	// This method is used to open registration form
	@RequestMapping("/registerUser")
	public ModelAndView showUserForm(ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	// This method is used to save user details
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping("/showUserDetails")
	public ModelAndView showUserDeails(ModelAndView model){
		try{
			List<User> listOfUsers = userService.getAllUsers();
			model.addObject("listOfUser", listOfUsers);
			model.setViewName("/userProfile");
		}catch(Exception e){
			e.getMessage();
		}
		return model;
	}
	
	//This method is used to load login form
	@RequestMapping("/loginForm")
	public ModelAndView showLoginForm(@ModelAttribute("user") User user ,ModelAndView model){
		model.setViewName("login");
		return model;
	}
	
	//This method is used to login process
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("user") User user, HttpSession session){
		User result = null;
		List<BookWishList> bookwishList = null;
		ModelAndView model = new ModelAndView();
		try {
		   result = userService.loginUser(user);
		   if(result != null){
		   model.setViewName("userProfile");
		   session.setAttribute("user", result);
		   bookwishList = bookService.getBookListByUserId(result.getId());
		   model.addObject("bookList", bookwishList);
		   model.addObject("session", session.getAttribute("user"));
		   }
		   else{
			   model.setViewName("login");
			   model.addObject("message", "Username or Password is wrong!!");
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result != null)
			return model;
		else
			return model;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logoutUser(@ModelAttribute("logout") User user, HttpSession session){
		session.invalidate(); 
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/forgetPassword", method=RequestMethod.GET)
	public ModelAndView forgetPassword(@ModelAttribute("user") User user, ModelAndView model){
		model.setViewName("forgetPassword");
		return model;
	}
	
	@RequestMapping(value="/userProfile", method=RequestMethod.GET)
	public ModelAndView loadUserProfile(@ModelAttribute("user") User user, ModelAndView model, HttpSession session){
		model.setViewName("userProfile");
		User userId = (User) session.getAttribute("user");
		List <BookWishList> bookwishList = null;
		try {
			if(userId != null){
				 bookwishList = bookService.getBookListByUserId(userId.getId());
				 model.addObject("bookList", bookwishList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("session", session.getAttribute("user"));
		return model;
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("user") User user,  ModelAndView model){
		String userEmail = userService.getUserEmail(user.getEmail());
		if(userEmail != null){
			String to = "paruljainsvn49@gmail.com";
			String subject = "Password Reset";
			String link = "http://localhost:8080/Elibrary/formResetPassword?email="+userEmail;
			String mailBody = "Hello, This email is to let you know that someone, probably you, recently asked us to reset the password on the elibrary account belonging to " +userEmail +" " + link;
			emailservice.sendMail(userEmail, to, subject, mailBody);
			String message = "We have sent an email to your email-id, check your email to reset your password.";
			model.addObject("message", message);
			model.addObject("email", userEmail);
			model.setViewName("resetMessage");
		}else{
			String message = "Please check your email id";
			model.addObject("message", message);
			model.setViewName("forgetPassword");
		}
		
		return model;
	}
	
	@RequestMapping(value="/formResetPassword", method=RequestMethod.GET)
	public ModelAndView resetUserPassword(@RequestParam(value="email") String email, @ModelAttribute("user") User user, ModelAndView model){
		model.addObject("email", email);
		model.setViewName("resetPassword");
		return model;
	}
	
	@RequestMapping(value="/doResetPassword", method=RequestMethod.POST)
	public ModelAndView editUserPassword(@ModelAttribute("user") User user, ModelAndView model){
		Integer result;
		try {
			result = userService.editUserPassword(user.getEmail(), user.getPassword());
			if(result > 0){
				model.addObject("successMsg", "Your Password Reset Successfully !!");
				model.setViewName("resetMessage");
			}
			else{
				model.addObject("errorMsg", "Please try again");
				model.setViewName("resetPassword");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
}
