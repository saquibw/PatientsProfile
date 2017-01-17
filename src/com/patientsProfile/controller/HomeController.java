package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientsProfile.model.Patient;
import com.patientsProfile.service.PatientService;

@Controller
public class HomeController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String viewHomePage(ModelMap model){
		return "home";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String viewRegistrationPage(ModelMap model){
		Integer lastId = patientService.getLastRegNo();
		model.addAttribute("pageName", "Patient Registration");
		model.addAttribute("regNo", lastId+1);
		model.addAttribute("patient", new Patient());
				
		return "registration";
	}
	
	@RequestMapping(value="/findings", method=RequestMethod.GET)
	public String viewExamFindingsPage(ModelMap model){
		model.addAttribute("pageName", "Examination Findings");
		
		return "examFindings";
	}

}
