package com.patientsProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		System.out.println("Entered this method");
		model.addAttribute("name", name);
		return "login";
	}

}
