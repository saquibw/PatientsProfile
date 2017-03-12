package com.patientsProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.patientsProfile.model.ExamFindings;
import com.patientsProfile.model.Investigation;
import com.patientsProfile.model.Patient;
import com.patientsProfile.model.PatientVisit;
import com.patientsProfile.service.ExamFindingsService;
import com.patientsProfile.service.InvestigationService;
import com.patientsProfile.service.PatientService;
import com.patientsProfile.service.PatientVisitService;

@Controller
public class PatientViewController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientVisitService patientVisitService;
	
	@Autowired
	private ExamFindingsService examFindingsService;
	
	@Autowired
	private InvestigationService investigationService;
	
	@RequestMapping(value="/viewpt", method=RequestMethod.GET)
	public String view(@ModelAttribute("visitId") String visitId, RedirectAttributes redirectAttrs){
		redirectAttrs.addFlashAttribute("visitId", visitId);
		
		return "redirect:/viewpatient";
	}

	@RequestMapping(value="/viewpatient", method=RequestMethod.GET)
	public String viewPatient(ModelMap model, @ModelAttribute("visitId") String visitId){
		
		PatientVisit visit = patientVisitService.getById(Integer.parseInt(visitId));		
		Patient patient = patientService.getByRegNo(visit.getRegNo());
		ExamFindings findings = examFindingsService.getByVisitId(Integer.parseInt(visitId));
		Investigation investigation = investigationService.getByVisitId(Integer.parseInt(visitId));
		System.out.println(investigation.getVisitId());
		
		model.addAttribute("patientVisit", visit);
		model.addAttribute("patient", patient);
		model.addAttribute("examFindings", findings);
		model.addAttribute("investigation", investigation);
		
		model.addAttribute("pageName", "View Patient");
				
		return "patientView";
	}
	
	@RequestMapping(value="/updatepatientvisit", produces="application/json", method=RequestMethod.POST)
	public String updatePatientVisit(PatientVisit patientVisit, 
			RedirectAttributes redirectAttrs){
		
		patientVisitService.updateById(patientVisit);
		
		Integer visitId = patientVisit.getId();
		redirectAttrs.addFlashAttribute("visitId", visitId);
		
		return "redirect:/viewpatient";
	}
	
	@RequestMapping(value="/updateexamfindings", produces="application/json", method=RequestMethod.POST)
	public String updateExamFindings(ExamFindings findings,
			RedirectAttributes redirectAttrs){
		
		examFindingsService.update(findings);
		
		Integer visitId = findings.getVisitId();
		redirectAttrs.addFlashAttribute("visitId", visitId);
		return "redirect:/viewpatient";
	}
	
	@RequestMapping(value="/updateinvestigation", produces="application/json", method=RequestMethod.POST)
	public String updateInvestigation(Investigation investigation,
			RedirectAttributes redirectAttrs){
		
		Integer visitId = investigation.getVisitId();
		redirectAttrs.addFlashAttribute("visitId", visitId);
		return "redirect:/viewpatient";
	}
}
