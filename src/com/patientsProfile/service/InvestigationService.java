package com.patientsProfile.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientsProfile.model.Investigation;

@Service
@Transactional
public class InvestigationService {
	
private JdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Investigation investigation){
		String sql = "Insert Into investigation (visitId, cxrValue, xrayValue, hbValue, esrValue, wbcValue, plateletsValue, bsRbsValue, bsFastingValue, habfValue, hba1cValue, "
				+ "creatininValue, bUreaValue, uricAcidValue, dcValue, bilirubinValue, sgptValue, sgotValue, alkPhosValue, cholesterolValue, hdlValue, ldlValue, tgValue, eNaValue, "
				+ "eKValue, eClValue, eCo2Value, prothrombinValue, btValue, ctValue, raValue, albuminValue, uAlbValue, uSugarValue, uPcValue, uEcValue, uRbcValue, spuAfb1Value, "
				+ "spuAfb2Value, spuAfb3Value, spuEosinophilsValue, pfCytologyValue, pfCellsCmmValue, pfLymphocytesValue, pfPolymorphValue, pfMalignantCellsValue, pfAdaValue, pfProteinValue, "
				+ "pfSugarValue, pfAfbValue, usgValue, ecgValue, cardioValue, ctScanValue, htctChestValue, mriBrainValue, mriSpineValue, fnacValue, endoscopyValue, coloscopyValue, bronchoscopyValue, "
				+ "finalDiagnosis, treatment) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int result = 0;
		
		try {
			result = jdbcTemplate.update(sql, new Object[]{investigation.getVisitId(), investigation.getCxrValue(), investigation.getXrayValue(), investigation.getHbValue(), investigation.getEsrValue(), 
					investigation.getWbcValue(), investigation.getPlateletsValue(), investigation.getBsRbsValue(), investigation.getBsFastingValue(), investigation.getHabfValue(), investigation.getHba1cValue(), 
					investigation.getCreatininValue(), investigation.getbUreaValue(), investigation.getUricAcidValue(), investigation.getDcValue(), investigation.getBilirubinValue(), investigation.getSgptValue(), 
					investigation.getSgotValue(), investigation.getAlkPhosValue(), investigation.getCholesterolValue(), investigation.getHdlValue(), investigation.getLdlValue(), investigation.getTgValue(), 
					investigation.geteNaValue(), investigation.geteKValue(), investigation.geteClValue(), investigation.geteCo2Value(), investigation.getProthrombinValue(), investigation.getBtValue(), 
					investigation.getCtValue(), investigation.getRaValue(), investigation.getAlbuminValue(), investigation.getuAlbValue(), investigation.getuSugarValue(), investigation.getuPcValue(), 
					investigation.getuEcValue(), investigation.getuRbcValue(), investigation.getSpuAfb1Value(), investigation.getSpuAfb2Value(), investigation.getSpuAfb3Value(), investigation.getSpuEosinophilsValue(), 
					investigation.getPfCytologyValue(), investigation.getPfCellsCmmValue(), investigation.getPfLymphocytesValue(), investigation.getPfPolymorphValue(), investigation.getPfMalignantCellsValue(), 
					investigation.getPfAdaValue(), investigation.getPfProteinValue(), investigation.getPfSugarValue(), investigation.getPfAfbValue(), investigation.getUsgValue(), investigation.getEcgValue(), 
					investigation.getCardioValue(), investigation.getCtScanValue(), investigation.getHtctChestValue(), investigation.getMriBrainValue(), investigation.getMriSpineValue(), investigation.getFnacValue(), 
					investigation.getEndoscopyValue(), investigation.getColoscopyValue(), investigation.getBronchoscopyValue(), investigation.getFinalDiagnosis(), investigation.getTreatment()});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Investigation investigation){
		String sql = "Update investigation set cxrValue = ?, xrayValue = ?, hbValue = ?, esrValue = ?, wbcValue = ?, plateletsValue = ?, bsRbsValue = ?, bsFastingValue = ?, habfValue = ?, hba1cValue = ?, "
				+ "creatininValue = ?, bUreaValue = ?, uricAcidValue = ?, dcValue = ?, bilirubinValue = ?, sgptValue = ?, sgotValue = ?, alkPhosValue = ?, cholesterolValue = ?, hdlValue = ?, "
				+ "ldlValue = ?, tgValue = ?, eNaValue = ?, eKValue = ?, eClValue = ?, eCo2Value = ?, prothrombinValue = ?, btValue = ?, ctValue = ?, raValue = ?, albuminValue = ?, uAlbValue = ?, "
				+ "uSugarValue = ?, uPcValue = ?, uEcValue = ?, uRbcValue = ?, spuAfb1Value = ?, spuAfb2Value = ?, spuAfb3Value = ?, spuEosinophilsValue = ?, pfCytologyValue = ?, pfCellsCmmValue = ?, "
				+ "pfLymphocytesValue = ?, pfPolymorphValue = ?, pfMalignantCellsValue = ?, pfAdaValue = ?, pfProteinValue = ?, pfSugarValue = ?, pfAfbValue = ?, usgValue = ?, ecgValue = ?, cardioValue = ?, "
				+ "ctScanValue = ?, htctChestValue = ?, mriBrainValue = ?, mriSpineValue = ?, fnacValue = ?, endoscopyValue = ?, coloscopyValue = ?, bronchoscopyValue = ?, finalDiagnosis = ?, treatment = ? "
				+ "Where visitId = ?";
		
		try {
			jdbcTemplate.update(sql, new Object[]{investigation.getCxrValue(), investigation.getXrayValue(), investigation.getHbValue(), investigation.getEsrValue(), 
					investigation.getWbcValue(), investigation.getPlateletsValue(), investigation.getBsRbsValue(), investigation.getBsFastingValue(), investigation.getHabfValue(), investigation.getHba1cValue(), 
					investigation.getCreatininValue(), investigation.getbUreaValue(), investigation.getUricAcidValue(), investigation.getDcValue(), investigation.getBilirubinValue(), investigation.getSgptValue(), 
					investigation.getSgotValue(), investigation.getAlkPhosValue(), investigation.getCholesterolValue(), investigation.getHdlValue(), investigation.getLdlValue(), investigation.getTgValue(), 
					investigation.geteNaValue(), investigation.geteKValue(), investigation.geteClValue(), investigation.geteCo2Value(), investigation.getProthrombinValue(), investigation.getBtValue(), 
					investigation.getCtValue(), investigation.getRaValue(), investigation.getAlbuminValue(), investigation.getuAlbValue(), investigation.getuSugarValue(), investigation.getuPcValue(), 
					investigation.getuEcValue(), investigation.getuRbcValue(), investigation.getSpuAfb1Value(), investigation.getSpuAfb2Value(), investigation.getSpuAfb3Value(), investigation.getSpuEosinophilsValue(), 
					investigation.getPfCytologyValue(), investigation.getPfCellsCmmValue(), investigation.getPfLymphocytesValue(), investigation.getPfPolymorphValue(), investigation.getPfMalignantCellsValue(), 
					investigation.getPfAdaValue(), investigation.getPfProteinValue(), investigation.getPfSugarValue(), investigation.getPfAfbValue(), investigation.getUsgValue(), investigation.getEcgValue(), 
					investigation.getCardioValue(), investigation.getCtScanValue(), investigation.getHtctChestValue(), investigation.getMriBrainValue(), investigation.getMriSpineValue(), investigation.getFnacValue(), 
					investigation.getEndoscopyValue(), investigation.getColoscopyValue(), investigation.getBronchoscopyValue(), investigation.getFinalDiagnosis(), investigation.getTreatment(), investigation.getVisitId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Investigation getByVisitId(Integer visitId){
		Investigation inv = new Investigation();
		String sql = "Select * from investigation where visitId = ?";
		try {
			inv = jdbcTemplate.queryForObject(sql, new Object[]{visitId}, getMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return inv;
	}
	
	private RowMapper<Investigation> getMapper(){
		RowMapper<Investigation> mapper = new RowMapper<Investigation>() {
			
			@Override
			public Investigation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Investigation investigation = new Investigation();
				investigation.setVisitId(rs.getInt("visitId"));
				investigation.setCxrValue(rs.getString("cxrValue")); 
				investigation.setXrayValue(rs.getString("xrayValue")); 
				investigation.setHbValue(rs.getString("hbValue")); 
				investigation.setEsrValue(rs.getString("esrValue")); 
				investigation.setWbcValue(rs.getString("wbcValue")); 
				investigation.setPlateletsValue(rs.getString("plateletsValue")); 
				investigation.setBsRbsValue(rs.getString("bsRbsValue")); 
				investigation.setBsFastingValue(rs.getString("bsFastingValue")); 
				investigation.setHabfValue(rs.getString("habfValue")); 
				investigation.setHba1cValue(rs.getString("hba1cValue")); 
				investigation.setCreatininValue(rs.getString("creatininValue")); 
				investigation.setbUreaValue(rs.getString("bUreaValue")); 
				investigation.setUricAcidValue(rs.getString("uricAcidValue")); 
				investigation.setDcValue(rs.getString("dcValue")); 
				investigation.setBilirubinValue(rs.getString("bilirubinValue")); 
				investigation.setSgptValue(rs.getString("sgptValue")); 
				investigation.setSgotValue(rs.getString("sgotValue")); 
				investigation.setAlkPhosValue(rs.getString("alkPhosValue")); 
				investigation.setCholesterolValue(rs.getString("cholesterolValue")); 
				investigation.setHdlValue(rs.getString("hdlValue")); 
				investigation.setLdlValue(rs.getString("ldlValue")); 
				investigation.setTgValue(rs.getString("tgValue")); 
				investigation.seteNaValue(rs.getString("eNaValue")); 
				investigation.seteKValue(rs.getString("eKValue")); 
				investigation.seteClValue(rs.getString("eClValue")); 
				investigation.seteCo2Value(rs.getString("eCo2Value")); 
				investigation.setProthrombinValue(rs.getString("prothrombinValue")); 
				investigation.setBtValue(rs.getString("btValue")); 
				investigation.setCtValue(rs.getString("ctValue")); 
				investigation.setRaValue(rs.getString("raValue")); 
				investigation.setAlbuminValue(rs.getString("albuminValue")); 
				investigation.setuAlbValue(rs.getString("uAlbValue")); 
				investigation.setuSugarValue(rs.getString("uSugarValue")); 
				investigation.setuPcValue(rs.getString("uPcValue")); 
				investigation.setuEcValue(rs.getString("uEcValue")); 
				investigation.setuRbcValue(rs.getString("uRbcValue")); 
				investigation.setSpuAfb1Value(rs.getString("spuAfb1Value")); 
				investigation.setSpuAfb2Value(rs.getString("spuAfb2Value")); 
				investigation.setSpuAfb3Value(rs.getString("spuAfb3Value")); 
				investigation.setSpuEosinophilsValue(rs.getString("spuEosinophilsValue")); 
				investigation.setPfCytologyValue(rs.getString("pfCytologyValue")); 
				investigation.setPfCellsCmmValue(rs.getString("pfCellsCmmValue")); 
				investigation.setPfLymphocytesValue(rs.getString("pfLymphocytesValue")); 
				investigation.setPfPolymorphValue(rs.getString("pfPolymorphValue")); 
				investigation.setPfMalignantCellsValue(rs.getString("pfMalignantCellsValue")); 
				investigation.setPfAdaValue(rs.getString("pfAdaValue")); 
				investigation.setPfProteinValue(rs.getString("pfProteinValue")); 
				investigation.setPfSugarValue(rs.getString("pfSugarValue")); 
				investigation.setPfAfbValue(rs.getString("pfAfbValue")); 
				investigation.setUsgValue(rs.getString("usgValue")); 
				investigation.setEcgValue(rs.getString("ecgValue")); 
				investigation.setCardioValue(rs.getString("cardioValue")); 
				investigation.setCtScanValue(rs.getString("ctScanValue")); 
				investigation.setHtctChestValue(rs.getString("htctChestValue")); 
				investigation.setMriBrainValue(rs.getString("mriBrainValue")); 
				investigation.setMriSpineValue(rs.getString("mriSpineValue")); 
				investigation.setFnacValue(rs.getString("fnacValue")); 
				investigation.setEndoscopyValue(rs.getString("endoscopyValue")); 
				investigation.setColoscopyValue(rs.getString("coloscopyValue")); 
				investigation.setBronchoscopyValue(rs.getString("bronchoscopyValue")); 
				investigation.setFinalDiagnosis(rs.getString("finalDiagnosis")); 
				investigation.setTreatment(rs.getString("treatment"));
				return investigation;
			}
		};
		return mapper;
	}
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 