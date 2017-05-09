package com.patientsProfile.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
				+ "spleenValue, kidneyValue, abdomenEpiValue, abdomenDuoValue, lowerAbdomenValue, mcTendernessValue, lymphNodeValue, lungsValue, heartValue, nervousSystemValue, provisionalDiagnosis )"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int result= 0;
		try {
			result = jdbcTemplate.update(sql, new Object[]{
					examFindings.getVisitId(), examFindings.getAnaemiaValue(), examFindings.getNeckVainsValue(), examFindings.getJaundiceValue(), 
					examFindings.getClubingValue(), examFindings.getCyanosisValue(), examFindings.getKoilonychiaValue(), examFindings.getOedemaValue(), examFindings.getGynaecomastiaValue(), 
					examFindings.getAscitisValue(), examFindings.getPalmarErythemaValue(), examFindings.getTemperatureValue(), examFindings.getFlappingTremorValue(), 
					examFindings.getPulseValue(), examFindings.getBpValue(), examFindings.getLiverValue(), examFindings.getSpleenValue(), 
					examFindings.getKidneyValue(), examFindings.getAbdomenEpiValue(), examFindings.getAbdomenDuoValue(), examFindings.getLowerAbdomenValue(), examFindings.getMcTendernessValue(), examFindings.getLymphNodeValue(),
					examFindings.getLungsValue(), examFindings.getHeartValue(), examFindings.getNervousSystemValue(), examFindings.getProvisionalDiagnosis()});
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}		
	}
	
	public void update(ExamFindings examFindings){
		String sql = "Update exam_findings set anaemiaValue = ?, neckVainsValue = ?, jaundiceValue = ?, clubingValue = ?, cyanosisValue = ?, koilonychiaValue = ?, "
				+ "oedemaValue = ?, gynaecomastiaValue = ?, ascitisValue = ?, palmarErythemaValue = ?, temperatureValue = ?, flappingTremorValue = ?, pulseValue = ?, bpValue = ?, liverValue = ?, "
				+ "spleenValue = ?, kidneyValue = ?, abdomenEpiValue = ?, abdomenDuoValue = ?, lowerAbdomenValue = ?, mcTendernessValue = ?, lymphNodeValue = ?, lungsValue = ?, heartValue = ?, "
				+ "nervousSystemValue = ?, provisionalDiagnosis = ? where visitId = ?";
		
		jdbcTemplate.update(sql, new Object[]{
				examFindings.getAnaemiaValue(), examFindings.getNeckVainsValue(), examFindings.getJaundiceValue(), 
				examFindings.getClubingValue(), examFindings.getCyanosisValue(), examFindings.getKoilonychiaValue(), examFindings.getOedemaValue(), examFindings.getGynaecomastiaValue(), 
				examFindings.getAscitisValue(), examFindings.getPalmarErythemaValue(), examFindings.getTemperatureValue(), examFindings.getFlappingTremorValue(), 
				examFindings.getPulseValue(), examFindings.getBpValue(), examFindings.getLiverValue(), examFindings.getSpleenValue(), 
				examFindings.getKidneyValue(), examFindings.getAbdomenEpiValue(), examFindings.getAbdomenDuoValue(), examFindings.getLowerAbdomenValue(), examFindings.getMcTendernessValue(), examFindings.getLymphNodeValue(),
				examFindings.getLungsValue(), examFindings.getHeartValue(), examFindings.getNervousSystemValue(), examFindings.getProvisionalDiagnosis(), examFindings.getVisitId()});
	}
	
	public ExamFindings getByVisitId(Integer visitId){
		ExamFindings findings = new ExamFindings();
		String sql = "Select * from exam_findings where visitId = ?";
		try {
			findings = jdbcTemplate.queryForObject(sql,new Object[]{visitId}, getMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findings;
	}
	
	public Boolean ifExists(Integer visitId){
		String sql = "Select Count(*) From exam_findings where visitId = ?";
		Integer count = null;
		Boolean result = false;
		try {
			count = jdbcTemplate.queryForObject(sql, new Object[]{visitId}, Integer.class);
			result = count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private RowMapper<ExamFindings> getMapper(){
		RowMapper<ExamFindings> mapper = new RowMapper<ExamFindings>() {
			
			@Override
			public ExamFindings mapRow(ResultSet rs, int numRow) throws SQLException {
				ExamFindings findings = new ExamFindings();
				findings.setVisitId(rs.getInt("visitId"));
				findings.setAnaemiaValue(rs.getString("anaemiaValue"));
				findings.setNeckVainsValue(rs.getString("neckVainsValue"));
				findings.setJaundiceValue(rs.getString("jaundiceValue"));
				findings.setClubingValue(rs.getString("clubingValue"));
				findings.setCyanosisValue(rs.getString("cyanosisValue"));
				findings.setKoilonychiaValue(rs.getString("koilonychiaValue"));
				findings.setOedemaValue(rs.getString("oedemaValue"));
				findings.setGynaecomastiaValue(rs.getString("gynaecomastiaValue"));
				findings.setAscitisValue(rs.getString("ascitisValue"));
				findings.setPalmarErythemaValue(rs.getString("palmarErythemaValue"));
				findings.setTemperatureValue(rs.getString("temperatureValue"));
				findings.setFlappingTremorValue(rs.getString("flappingTremorValue"));
				findings.setPulseValue(rs.getString("pulseValue"));
				findings.setBpValue(rs.getString("bpValue"));
				findings.setLiverValue(rs.getString("liverValue"));
				findings.setSpleenValue(rs.getString("spleenValue"));
				findings.setKidneyValue(rs.getString("kidneyValue"));
				findings.setAbdomenEpiValue(rs.getString("abdomenEpiValue"));
				findings.setAbdomenDuoValue(rs.getString("abdomenDuoValue"));
				findings.setLowerAbdomenValue(rs.getString("lowerAbdomenValue"));
				findings.setMcTendernessValue(rs.getString("mcTendernessValue"));
				findings.setLymphNodeValue(rs.getString("lymphNodeValue"));
				findings.setLungsValue(rs.getString("lungsValue"));
				findings.setHeartValue(rs.getString("heartValue"));
				findings.setNervousSystemValue(rs.getString("nervousSystemValue"));
				findings.setProvisionalDiagnosis(rs.getString("provisionalDiagnosis"));
				return findings;
			}
		};
		return mapper;
		
	}
}
