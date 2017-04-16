package com.patientsProfile.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientsProfile.model.PatientVisit;
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
		String sql = "Insert Into patient_visit (regNo, chiefComplains, presentHistory, visitDate)"
				+ "values (?,?,?,?)";

		int result = 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{patientVisit.getRegNo() , patientVisit.getChiefComplains(), 
					patientVisit.getPresentHistory(), patientVisit.getVisitDate()});
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
	
	public PatientVisit getById(Integer visitId){
		String sql = "Select * From patient_visit where id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{visitId}, getMapper());
	}
	
	public void updateById(PatientVisit patientVisit){
		String sql = "Update patient_visit Set chiefComplains = ?, presentHistory = ? Where id = ?";
		
		jdbcTemplate.update(sql, new Object[]{patientVisit.getChiefComplains(), patientVisit.getPresentHistory(), patientVisit.getId()});
	}
	
	public Integer getVisitCountByRegNo(String regNo){
		String sql = "Select COUNT(*) From patient_visit Where regNo = ?";		
		Integer count = jdbcTemplate.queryForObject(sql, new Object[]{regNo}, Integer.class);
		
		return count;
	}
	
	private RowMapper<PatientVisit> getMapper(){
		RowMapper<PatientVisit> mapper = new RowMapper<PatientVisit>(){
			public PatientVisit mapRow(ResultSet rs, int numRow) throws SQLException{
				PatientVisit PatientVisit = new PatientVisit();
				PatientVisit.setId(rs.getInt("id"));
				PatientVisit.setRegNo(rs.getString("regNo"));
				PatientVisit.setVisitDate(rs.getString("visitDate"));
				PatientVisit.setChiefComplains(rs.getString("chiefComplains"));
				PatientVisit.setPresentHistory(rs.getString("presenthistory"));
				return PatientVisit;
			}
		};
		return mapper;
	}
}
