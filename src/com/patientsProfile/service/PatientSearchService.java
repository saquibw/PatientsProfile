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

import com.patientsProfile.model.PatientSearch;

@Service
@Transactional
public class PatientSearchService {

	private JdbcTemplate jdbcTemplate;

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<PatientSearch> get(){
		String sql = "Select pv.id, pv.regNo, DATE_FORMAT(str_to_date(pv.visitDate, '%d/%m/%Y'),'%d-%M-%Y') as visitDate, pv.chiefComplains, p.name, p.contactNo, p.zilla, i.finalDiagnosis "
				   + "from patients_profile.patient_visit pv "
				   + "LEFT OUTER JOIN patients_profile.patient p ON p.regNo = pv.regNo "
				   + "LEFT OUTER JOIN patients_profile.investigation i ON i.visitId = pv.id "
				   + "order by visitDate desc, pv.creationDate desc";
		
		return (List<PatientSearch>) jdbcTemplate.query(sql, getMapper());
	}
	
	public List<PatientSearch> getBySearchParam(String param){
		String sql = "Select pv.id, pv.regNo, DATE_FORMAT(str_to_date(pv.visitDate, '%d/%m/%Y'),'%d-%M-%Y') as visitDate, pv.chiefComplains, p.name, p.contactNo, p.zilla, i.finalDiagnosis "
				   + "from patients_profile.patient_visit pv "
				   + "LEFT OUTER JOIN patients_profile.patient p ON p.regNo = pv.regNo "
				   + "LEFT OUTER JOIN patients_profile.investigation i ON i.visitId = pv.id "
				   + "Where p.name like '%"+ param + "%' "
				   + "OR p.contactNo like '%"+ param + "%' "
				   + "OR p.zilla like '%"+ param + "%' "
				   + "OR i.finalDiagnosis like '%"+ param + "%' "
				   + "order by visitDate desc";
		
		return (List<PatientSearch>) jdbcTemplate.query(sql, getMapper());
	}
	
	private RowMapper<PatientSearch> getMapper(){
		RowMapper<PatientSearch> mapper = new RowMapper<PatientSearch>(){
			public PatientSearch mapRow(ResultSet rs, int numRow) throws SQLException{
				PatientSearch patientSearch = new PatientSearch();
				patientSearch.setVisitId(rs.getInt("id"));
				patientSearch.setPatientName(rs.getString("name"));
				patientSearch.setContactNo(rs.getString("contactNo"));
				patientSearch.setZilla(rs.getString("zilla"));
				patientSearch.setRegNo(rs.getString("regNo"));
				patientSearch.setVisitDate(rs.getString("visitDate"));
				patientSearch.setChiefComplains(rs.getString("chiefComplains"));
				patientSearch.setFinalDiagnosis(rs.getString("finalDiagnosis"));
				return patientSearch;
			}
		};
		return mapper;
	}
}
