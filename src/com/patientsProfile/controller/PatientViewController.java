package com.patientsProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientViewController {

	@RequestMapping(value="/viewpatient", method=RequestMethod.GET)
	public String viewPatient(@ModelAttribute("visitId") String visitId){
		System.out.println(visitId);
		return "home";
	}
}
