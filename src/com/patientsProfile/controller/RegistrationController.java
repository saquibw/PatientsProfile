package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patientsProfile.model.Patient;
import com.patientsProfile.service.PatientService;
import com.patientsProfile.service.UserService;
import com.patientsProfile.utill.Utils;

@Controller
public class RegistrationController {
	
	@Autowired
	private PatientService patientService;

	@RequestMapping(value="/savepatient", produces="application/json", method=RequestMethod.POST)
	public String savePatient(Patient patient){
		int result = patientService.create(patient);
		
		return "redirect:/findings";
	}
}
