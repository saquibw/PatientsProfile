package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patientsProfile.model.ExamFindings;
import com.patientsProfile.model.Patient;
import com.patientsProfile.model.PatientVisit;
import com.patientsProfile.service.ExamFindingsService;
import com.patientsProfile.service.PatientService;
import com.patientsProfile.service.PatientVisitService;
import com.patientsProfile.service.UserService;
import com.patientsProfile.utill.Utils;

@Controller
public class RegistrationController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientVisitService patientVisitService;
	
	@Autowired
	private ExamFindingsService examFindingsService;

	//Save patient
	@RequestMapping(value="/registerpatient", produces="application/json", method=RequestMethod.POST)
	public String savePatient(Patient patient, RedirectAttributes redirectAttrs){
		int result = patientService.create(patient);
		
		String regNo = "";
		if(result == 1){
			regNo = Integer.toString(patient.getRegNo());
		}
		redirectAttrs.addFlashAttribute("regNo", regNo);
		redirectAttrs.addFlashAttribute("patientName", patient.getName());
		redirectAttrs.addFlashAttribute("patientAge", patient.getAge());
		redirectAttrs.addFlashAttribute("patientSex", patient.getSex());
		
		return "redirect:/patientvisit";
	}
	
	//View patient visit page
	@RequestMapping(value="/patientvisit", method=RequestMethod.GET)
	public String viewPatientVisitPage(@ModelAttribute("regNo") String regNo,
			@ModelAttribute("patientName") String patientName,
			@ModelAttribute("patientAge") String patientAge, 
			@ModelAttribute("patientSex") String patientSex, 
			ModelMap model){
		
		model.addAttribute("pageName", "Patient Visit");
		model.addAttribute("patientVisit", new PatientVisit());
		model.addAttribute("regNo", regNo);
		model.addAttribute("patientName", patientName);
		model.addAttribute("patientAge", patientAge);
		model.addAttribute("patientSex", patientSex);
		
		return "patientVisit";
	}
	
	//Save patient visit
	@RequestMapping(value="/savepatientvisit", produces="application/json", method=RequestMethod.POST)
	public String savePatientVisit(PatientVisit patientVisit, RedirectAttributes redirectAttrs){
		int result = patientVisitService.create(patientVisit);
		Integer visitId = patientVisitService.getLastId();
		
		redirectAttrs.addFlashAttribute("visitId", visitId);
				
		return "redirect:/examfindings";
	}
	
	//View exam findings page
	@RequestMapping(value="/examfindings", method=RequestMethod.GET)
	public String viewExamFindingsPage(@ModelAttribute("visitId") String visitId, ModelMap model){
		model.addAttribute("pageName", "Examination Findings");
		model.addAttribute("examFindings", new ExamFindings());
		model.addAttribute("visitId", visitId);
		
		return "examFindings";
	}
	
	//Save exam findings
	@RequestMapping(value="/saveexamfindings", produces="application/json", method=RequestMethod.POST)
	public String saveExamFindings(ExamFindings examFindings){
		int result = examFindingsService.create(examFindings);
		return "redirect:/examfindings";
	}
}
