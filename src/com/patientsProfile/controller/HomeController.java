package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.patientsProfile.model.Patient;
import com.patientsProfile.service.PatientService;

@Controller
public class HomeController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String viewHomePage(){
		return "home";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String viewRegistrationPage(ModelMap model){
		model.addAttribute("pageName", "Patient Registration");
		model.addAttribute("patient", new Patient());
				
		return "registration";
	}
	
	@RequestMapping(value="/viewpatient", method=RequestMethod.GET)
	public String viewPatientViewPage(ModelMap model, @RequestParam(value="regNo", required=false) String regNo){
		Patient patient = null;

		if(regNo != null){
			patient = patientService.getByRegNo(regNo);
		}else{
			patient = new Patient();
		}
		model.addAttribute("pageName", "Patient View");
		model.addAttribute("patient", patient);
		
		return "patientView";
	}
	
	@RequestMapping(value="/deletepatient", method=RequestMethod.GET)
	public String deletePatient(@RequestParam(value="regNo", required=false) String regNo){
		if(regNo != null){
			patientService.deleteBy(regNo);
		}
		
		return "redirect:/viewpatient";
	}
}
