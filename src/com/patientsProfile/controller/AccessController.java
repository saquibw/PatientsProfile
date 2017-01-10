package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientsProfile.model.User;
import com.patientsProfile.service.UserService;

@Controller
public class AccessController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(){
		User user = userService.getByUsername("shafiqur");
		System.out.println(user.getUserName());
		return "login";
	}

}
