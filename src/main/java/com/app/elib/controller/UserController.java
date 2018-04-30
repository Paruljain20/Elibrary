package com.app.elib.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.elib.bean.User;
import com.app.elib.service.UserService;
import com.app.elib.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

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
	
	@RequestMapping("/loginForm")
	public ModelAndView showLoginForm(ModelAndView model){
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute User user){
		User result = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		Map<String, String> userData = new HashMap<>();
		try {
		   result = userService.loginUser(user);
		   userData.put("name",result.getName());
		   userData.put("email",result.getEmail());
		   httpHeaders.setContentType(MediaType.TEXT_PLAIN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result != null)
			return new ModelAndView("userProfile", "userData", userData);
					
		else
			return new ModelAndView("index");
	}
	
}
