package com.patientsProfile.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.patientsProfile.service.RegistrationNoGeneratorService;


@Controller
public class AjaxController {
	
	@Autowired
	private RegistrationNoGeneratorService regService;

	@ResponseBody
	@RequestMapping(value="/getRegNo", method=RequestMethod.GET, produces = "application/json")
	public JsonObject getRegNo(@RequestParam("day") Integer day, @RequestParam("month") Integer month, @RequestParam("year") Integer year, HttpServletResponse response) throws Exception{
		Integer regNo = (Integer)regService.getRegNo(day, month, year);
		JsonObject obj = new JsonObject();
		obj.addProperty("success", true);
		obj.addProperty("regNo", regNo);
		
		return obj;
	}
}
