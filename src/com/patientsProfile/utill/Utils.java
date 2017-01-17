package com.patientsProfile.utill;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Utils {
	
	private static HttpSession getSession(){
		 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		    return attr.getRequest().getSession(false);
	}
	
	public static void setValueInSession(String key, Object value){
		HttpSession session = getSession();
		session.setAttribute(key, value);
	}
	
	public static Object getValueFromSession(String key){
		HttpSession session = getSession();
		return session.getAttribute(key);
	}
	
}
