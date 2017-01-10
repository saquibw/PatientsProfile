package com.patientsProfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientsProfile.model.User;
import com.patientsProfile.service.UserService;

@Controller
@RequestMapping("/")
public class AccessController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		List<User> userList = userService.getAll();
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
		return "login";
	}

}
