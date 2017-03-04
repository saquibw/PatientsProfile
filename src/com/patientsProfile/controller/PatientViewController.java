package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patientsProfile.model.Patient;
import com.patientsProfile.model.PatientVisit;
import com.patientsProfile.service.PatientService;
import com.patientsProfile.service.PatientVisitService;

@Controller
public class PatientViewController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientVisitService patientVisitService;

	@RequestMapping(value="/viewpatient", method=RequestMethod.GET)
	public String viewPatient(@ModelAttribute("visitId") String visitId,
			ModelMap model){
		
		PatientVisit visit = patientVisitService.getById(Integer.parseInt(visitId));
		
		Patient patient = patientService.getByRegNo(visit.getRegNo());
		model.addAttribute("patientVisit", visit);
		model.addAttribute("patient", patient);
				
		return "patientView";
	}
	
	@RequestMapping(value="/updatepatientvisit", produces="application/json", method=RequestMethod.POST)
	public String updatePatientVisit(PatientVisit patientVisit, 
			//@ModelAttribute("visitId") String visitId,
			RedirectAttributes redirectAttrs){
		
		patientVisitService.updateById(patientVisit);
		
		Integer visitId = patientVisit.getId();
		redirectAttrs.addFlashAttribute("visitId", visitId);
		
		return "redirect:/viewpatient";
	}
	
	@RequestMapping(value="/updateexamfindings", method=RequestMethod.POST)
	public String updateExamFindings(){
		return "";
	}
	
	@RequestMapping(value="/updateinvestigation", method=RequestMethod.POST)
	public String updateInvestigation(){
		return "";
	}
}
