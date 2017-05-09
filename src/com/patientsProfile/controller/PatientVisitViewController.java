package com.patientsProfile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class PatientVisitViewController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientVisitService patientVisitService;
	
	@Autowired
	private ExamFindingsService examFindingsService;
	
	@Autowired
	private InvestigationService investigationService;
	
	@RequestMapping(value="/viewvt", method=RequestMethod.GET)
	public String view(@ModelAttribute("visitId") String visitId, RedirectAttributes redirectAttrs){
		redirectAttrs.addFlashAttribute("visitId", visitId);
				
		return "redirect:/viewpatientvisit";
	}

	@RequestMapping(value="/viewpatientvisit", method=RequestMethod.GET)
	public String viewPatient(ModelMap model, @ModelAttribute("visitId") String visitId, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(!visitId.equals("") && visitId != null){
			session.setAttribute("viewerVisitId", visitId);
		}else{
			visitId = (String) session.getAttribute("viewerVisitId");
		}
		
		PatientVisit visit = patientVisitService.getById(Integer.parseInt(visitId));		
		Patient patient = patientService.getByRegNo(visit.getRegNo());
		
		ExamFindings findings = new ExamFindings();
		if(examFindingsService.ifExists(Integer.parseInt(visitId))){
			findings = examFindingsService.getByVisitId(Integer.parseInt(visitId));
		}
		
		Investigation investigation = new Investigation();
		if(investigationService.ifExists(Integer.parseInt(visitId))){
			investigation = investigationService.getByVisitId(Integer.parseInt(visitId));
		}
				
		model.addAttribute("patientVisit", visit);
		model.addAttribute("patient", patient);
		model.addAttribute("examFindings", findings);
		model.addAttribute("investigation", investigation);
		
		model.addAttribute("pageName", "View Patient Visit");
				
		return "patientVisitView";
	}
	
	@RequestMapping(value="/deletepatientvisit", method=RequestMethod.GET)
	public String deleteVisit(@ModelAttribute("visitId") String visitId, RedirectAttributes redirectAttrs){
		if(visitId != null){
			patientVisitService.deleteById(Integer.parseInt(visitId));
		}		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/updatepatientvisit", produces="application/json", method=RequestMethod.POST)
	public String updatePatientVisit(PatientVisit patientVisit, 
			RedirectAttributes redirectAttrs){
		
		patientVisitService.updateById(patientVisit);
		
		Integer visitId = patientVisit.getId();
		redirectAttrs.addFlashAttribute("visitId", visitId);
		
		return "redirect:/viewpatientvisit";
	}
	
	@RequestMapping(value="/updateexamfindings", produces="application/json", method=RequestMethod.POST)
	public String updateExamFindings(ExamFindings findings,
			RedirectAttributes redirectAttrs, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Integer visitId = findings.getVisitId();
		if (visitId == null) {
			visitId = Integer.parseInt((String) session.getAttribute("viewerVisitId"));
		}

		if(examFindingsService.ifExists(visitId)){
			examFindingsService.update(findings);
		}else{
			findings.setVisitId(visitId);
			examFindingsService.create(findings);
		}
						
		redirectAttrs.addFlashAttribute("visitId", visitId);
		return "redirect:/viewpatientvisit";
	}
	
	@RequestMapping(value="/updateinvestigation", produces="application/json", method=RequestMethod.POST)
	public String updateInvestigation(Investigation investigation,
			RedirectAttributes redirectAttrs, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Integer visitId = investigation.getVisitId();
		if (visitId == null) {
			visitId = Integer.parseInt((String) session.getAttribute("viewerVisitId"));
		}

		if(investigationService.ifExists(visitId)){
			investigationService.update(investigation);
		}else{
			investigation.setVisitId(visitId);
			investigationService.create(investigation);
		}
		
		redirectAttrs.addFlashAttribute("visitId", visitId);
		return "redirect:/viewpatientvisit";
	}
}
