package com.patientsProfile.model;

public class PatientVisit {
	private Integer id;
	private Integer regNo;
	private String chiefComplains;
	private String presentHistory;
	private String creationDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegNo() {
		return regNo;
	}
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	public String getChiefComplains() {
		return chiefComplains;
	}
	public void setChiefComplains(String chiefComplains) {
		this.chiefComplains = chiefComplains;
	}
	public String getPresentHistory() {
		return presentHistory;
	}
	public void setPresentHistory(String presentHistory) {
		this.presentHistory = presentHistory;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
