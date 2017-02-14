package com.patientsProfile.service;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
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
					investigation.geteNaValue(), investigation.geteKValue(), investigation.geteClValue(), investigation.getECo2Value(), investigation.getProthrombinValue(), investigation.getBtValue(), 
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
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 