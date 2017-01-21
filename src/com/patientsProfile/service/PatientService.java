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
	
	@SuppressWarnings("finally")
	public Integer create(Patient patient){
		String sql = "Insert Into patient (regNo, creationDate, name, age, sex, profession, contactNo, area, thana, zilla, pastHistory, familyHistory, smokingHistory, drugHistory)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		
		int result= 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{patient.getRegNo(), patient.getCreationDate(), patient.getName(), patient.getAge(), 
					patient.getSex(), patient.getProfession(), patient.getContactNo(), patient.getArea(), patient.getThana(), patient.getZilla(), 
					patient.getPastHistory(), patient.getFamilyHistory(), patient.getSmokingHistory(), patient.getDrugHistory()});
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}		
	}
	
	@SuppressWarnings("finally")
	public Integer getLastRegNo(){
		String sql = "SELECT regNo FROM patient ORDER BY regNo DESC LIMIT 1";
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
