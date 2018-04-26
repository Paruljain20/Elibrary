package com.app.elib.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	//This method is used to open index page
		@RequestMapping("/")
		public ModelAndView index(ModelAndView model){
			model.setViewName("index");
			return model;
		}
		
		//This method is used to open registration form
		@RequestMapping("/registerUser")
		public ModelAndView showUserForm(ModelAndView model){
			model.setViewName("register");
			return model;
		}
		
		//This method is used to save user details
		@RequestMapping(value="/saveUser", method=RequestMethod.POST)
		public ModelAndView saveUser(@ModelAttribute User user){
			try {
				userService.save(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/");
		}
}
