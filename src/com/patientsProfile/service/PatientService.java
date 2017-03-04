package com.patientsProfile.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.patientsProfile.model.Patient;
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
	
	public Patient getByRegNo(String regNo){
		String sql = "Select * From patient where regNo = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{regNo}, getMapper());
	}
	
	private RowMapper<Patient> getMapper(){
		RowMapper<Patient> mapper = new RowMapper<Patient>(){
			public Patient mapRow(ResultSet rs, int numRow) throws SQLException{
				Patient patient = new Patient();
				patient.setRegNo(rs.getString("regNo"));
				patient.setName(rs.getString("name"));
				patient.setAge(rs.getInt("age"));
				patient.setSex(rs.getString("sex"));
				patient.setProfession(rs.getString("profession"));
				patient.setContactNo(rs.getString("contactNo"));
				patient.setArea(rs.getString("area"));
				patient.setThana(rs.getString("thana"));
				patient.setZilla(rs.getString("zilla"));
				patient.setPastHistory(rs.getString("pastHistory"));
				patient.setFamilyHistory(rs.getString("familyHistory"));
				patient.setSmokingHistory(rs.getString("smokingHistory"));
				patient.setDrugHistory(rs.getString("drugHistory"));
				patient.setCreationDate(rs.getString("creationDate"));
				
				return patient;
			}
		};
		return mapper;
	}
}
