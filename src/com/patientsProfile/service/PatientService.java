package com.patientsProfile.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		String sql = "Insert Into patient (regNo, creationDate, name, age, sex, profession, contactNo, nid, area, thana, zilla, pastHistory, familyHistory, smokingHistory, drugHistory)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int result= 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{patient.getRegNo(), patient.getCreationDate(), patient.getName(), patient.getAge(), 
					patient.getSex(), patient.getProfession(), patient.getContactNo(), patient.getNid(), patient.getArea(), patient.getThana(), patient.getZilla(), 
					patient.getPastHistory(), patient.getFamilyHistory(), patient.getSmokingHistory(), patient.getDrugHistory()});
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}		
	}
	
	public Integer update(Patient patient){
		String sql = "Update patient Set name=?, age=?, sex=?, profession=?, contactNo=?, nid=?, area=?, thana=?, zilla=?, pastHistory=?, familyHistory=?, smokingHistory=?, drugHistory=? Where regNo=?";
		
		return jdbcTemplate.update(sql, new Object[]{patient.getName(), patient.getAge(), patient.getSex(), patient.getProfession(), patient.getContactNo(), patient.getNid(), 
				patient.getArea(), patient.getThana(), patient.getZilla(), patient.getPastHistory(), patient.getFamilyHistory(), patient.getSmokingHistory(), patient.getDrugHistory(), patient.getRegNo()});
	}
	
	public Patient getByRegNo(String regNo){
		String sql = "Select * From patient where regNo = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{regNo}, getMapper());
	}
	
	public List<Patient> getAll(){
		String sql = "Select * From patient order by str_to_date(creationDate, '%d/%m/%Y') desc";
		
		return jdbcTemplate.query(sql, getMapper());
	}
	
	public List<Patient> getBySearchParam(String param){
		String sql = "Select * From patient Where regNo like '%"+ param + "%' "
				+ "OR name like '%"+ param + "%' "
				+ "OR age like '%"+ param + "%' "
				+ "OR sex like '%"+ param + "%' "
				+ "OR profession like '%"+ param + "%' "
				+ "OR contactNo like '%"+ param + "%' "
				+ "OR nid like '%"+ param + "%' "
				+ "OR area like '%"+ param + "%' "
				+ "OR thana like '%"+ param + "%' "
				+ "OR zilla like '%"+ param + "%' "
				+ "order by str_to_date(creationDate, '%d/%m/%Y') desc";
		
		return jdbcTemplate.query(sql, getMapper());
	}
	
	public Integer deleteBy(String regNo){
		String sql = "Delete From patient Where regNo = ?";
		
		return jdbcTemplate.update(sql, new Object[]{regNo});
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
				patient.setNid(rs.getString("nid"));
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
