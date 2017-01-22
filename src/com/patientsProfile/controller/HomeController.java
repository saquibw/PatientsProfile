package com.patientsProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientsProfile.model.Patient;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String viewHomePage(ModelMap model){
		return "home";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String viewRegistrationPage(ModelMap model){
		model.addAttribute("pageName", "Patient Registration");
		model.addAttribute("patient", new Patient());
				
		return "registration";
	}
}
