package com.patientsProfile.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationNoGeneratorService {
private JdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Object getRegNo(Integer date, Integer month, Integer year){
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getRegNo");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dt", date);
		param.put("mnth", month);
		param.put("yr", year);
		
		SqlParameterSource in = new MapSqlParameterSource(param);
		
		Map<String, Object> output = call.execute(in);
		return output.get("output");		
	}
	
	public void createRegNo(Integer day, Integer month, Integer year){
		String sql = "Insert INTO reg_no_generator (day, month, year, regNo) values (?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[]{day, month, year, 1});
	}
	
	public void updateRegNo(Integer day, Integer month, Integer year){
		String sql = "Update reg_no_generator set regNo = regNo+1 Where day=? And month=? And year=?";
		
		jdbcTemplate.update(sql, new Object[]{day, month, year});
	}
}
