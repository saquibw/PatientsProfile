package com.patientsProfile.model;

public class PatientSearch {
	private Integer visitId;
	private String visitDate;
	private String regNo;
	private String patientName;
	private String chiefComplains;
	private String finalDiagnosis;
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getChiefComplains() {
		return chiefComplains;
	}
	public void setChiefComplains(String chiefComplains) {
		this.chiefComplains = chiefComplains;
	}
	public String getFinalDiagnosis() {
		return finalDiagnosis;
	}
	public void setFinalDiagnosis(String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}
	
	
}
