package com.patientsProfile.service;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientsProfile.model.Patient;

@Service
@Transactional
public class PatientService {
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Integer create(Patient patient){
		String sql = "Insert Into patient (creationDate, name, age, profession, contactNo, area, thana, zilla, chiefComplains, presentHistory, pastHistory, familyHistory, smokingHistory, drugHistory)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		
		int result = jdbcTemplate.update(sql, new Object[]{patient.getCreationDate(), patient.getName(), patient.getAge(), patient.getProfession(), patient.getContactNo(), patient.getArea(), patient.getThana(), patient.getZilla(), 
				patient.getChiefComplains(), patient.getPresentHistory(), patient.getPastHistory(), patient.getFamilyHistory(), patient.getSmokingHistory(), patient.getDrugHistory()});
		
		return result;
		
	}
	
	@SuppressWarnings("finally")
	public Integer getLastRegNo(){
		String sql = "SELECT id FROM patient ORDER BY ID DESC LIMIT 1";
		Integer lastId = 0;
		try {
			lastId = jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lastId;
		}		
	}
}
