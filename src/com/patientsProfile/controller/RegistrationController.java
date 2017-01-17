package com.patientsProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patientsProfile.model.Patient;

@Controller
public class RegistrationController {

	@RequestMapping(value="/savepatient", produces="application/json", method=RequestMethod.POST)
	public String savePatient(Patient patient){
		System.out.println(patient.getArea());
		return "redirect:/registration";
	}
}
