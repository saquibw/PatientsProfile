package com.patientsProfile.service;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientsProfile.model.ExamFindings;

@Service
@Transactional
public class ExamFindingsService {
private JdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("finally")
	public Integer create(ExamFindings examFindings){
		String sql = "Insert Into exam_findings (visitId, anaemiaValue, neckVainsValue, jaundiceValue, clubingValue, cyanosisValue, koilonychiaValue, "
				+ "oedemaValue, gynaecomastiaValue, ascitisValue, palmarErythemaValue, temperatureValue, flappingTremorValue, pulseValue, bpValue, liverValue, "
				+ "spleenValue, kidneyValue, abdomenValue, lowerAbdomenValue, mcTendernessValue, lungsValue, heartValue, nervousSystemValue, provisionalDiagnosis )"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int result= 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{
					examFindings.getVisitId(), examFindings.getAnaemiaValue(), examFindings.getNeckVainsValue(), examFindings.getJaundiceValue(), 
					examFindings.getClubingValue(), examFindings.getCyanosisValue(), examFindings.getKoilonychiaValue(), examFindings.getOedemaValue(), examFindings.getGynaecomastiaValue(), 
					examFindings.getAscitisValue(), examFindings.getPalmarErythemaValue(), examFindings.getTemperatureValue(), examFindings.getFlappingTremorValue(), 
					examFindings.getPulseValue(), examFindings.getBpValue(), examFindings.getLiverValue(), examFindings.getSpleenValue(), 
					examFindings.getKidneyValue(), examFindings.getAbdomenValue(), examFindings.getLowerAbdomenValue(), examFindings.getMcTendernessValue(), examFindings.getLungsValue(), 
					examFindings.getHeartValue(), examFindings.getNervousSystemValue(), examFindings.getProvisionalDiagnosis()});
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}		
	}
}
