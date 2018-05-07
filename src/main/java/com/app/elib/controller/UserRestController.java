package com.app.elib.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.elib.bean.Response;
import com.app.elib.bean.User;
import com.app.elib.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	@ResponseBody
	public Response validateEmail(@RequestBody User user) {
		String status = null;
		String errorMessage = null;
		boolean result = false;
		if (user.getEmail() != null) {
			result = userService.validateEmail(user.getEmail());
			if (result == true) {
				status = "404";
				errorMessage = "Email Already Exist!";
			} else {
				status = "200";
				errorMessage = "";
			}
		}
		return new Response(errorMessage, status);
	}

}
