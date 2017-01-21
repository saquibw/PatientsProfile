package com.patientsProfile.service;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientsProfile.model.PatientVisit;

@Service
@Transactional
public class PatientVisitService {

	private JdbcTemplate jdbcTemplate;

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("finally")
	public Integer create(PatientVisit patientVisit){
		String sql = "Insert Into patient_visit (regNo, chiefComplains, presentHistory, creationDate)"
				+ "values (?,?,?,?)";

		int result = 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{patientVisit.getRegNo() , patientVisit.getChiefComplains(), 
					patientVisit.getPresentHistory(), patientVisit.getCreationDate()});
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;	
		}
	}

	@SuppressWarnings("finally")
	public Integer getLastId(){
		String sql = "SELECT id FROM patient_visit ORDER BY id DESC LIMIT 1";
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
