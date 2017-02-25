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
	
	public List<PatientSearch> getLast50(){
		String sql = "Select pv.id, pv.regNo, str_to_date(pv.creationDate, '%d/%m/%Y') as visitDate, pv.chiefComplains, "
				+ "(Select p.name from patients_profile.patient as p where p.regNo = pv.regNo) as name, "
				+ "(Select i.finalDiagnosis from patients_profile.investigation as i where i.visitId = pv.id) as finalDiagnosis "
				+ "from patients_profile.patient_visit as pv order by visitDate desc LIMIT 50";
		
		return (List<PatientSearch>) jdbcTemplate.query(sql, getMapper());
	}
	
	private RowMapper<PatientSearch> getMapper(){
		RowMapper<PatientSearch> mapper = new RowMapper<PatientSearch>(){
			public PatientSearch mapRow(ResultSet rs, int numRow) throws SQLException{
				PatientSearch patientSearch = new PatientSearch();
				patientSearch.setVisitId(rs.getInt("id"));
				patientSearch.setPatientName(rs.getString("name"));
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
