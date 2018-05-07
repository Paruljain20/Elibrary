package com.app.elib.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.User;
import com.app.elib.service.UserService;
import com.app.elib.service.UserServiceImpl;


@Controller
/*@SessionAttributes("user")*/
public class UserController {

	@Autowired
	private UserService userService;
	
	/*@ModelAttribute("user")
	public User getUser() {
		return new User();
	}*/

	// This method is used to open index page
	@RequestMapping("/")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("index");
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
		ModelAndView model = new ModelAndView();
		try {
		   result = userService.loginUser(user);
		   if(result != null){
		   //model.addObject("user", result);
		   model.setViewName("userProfile");
		   session.setAttribute("user", result);
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
	
	@RequestMapping(value="/validateEmail", method=RequestMethod.GET)
	public ModelAndView validateEmail(String email){
		boolean result = userService.validateEmail(email);
		Map<String, Boolean> data = new HashMap<>();
		data.put("result", result);
		return new ModelAndView("register" , "data", data);
	}
}
