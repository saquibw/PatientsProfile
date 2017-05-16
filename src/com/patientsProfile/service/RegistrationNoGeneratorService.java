package com.patientsProfile.service;

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
	
	public Object getRegNo(){
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("getRegNo");
		
		SqlParameterSource in = new MapSqlParameterSource();
		
		Map<String, Object> output = call.execute(in);
		return output.get("output");
	}
	
	public void createRegNo(){
		String sql = "Insert INTO reg_no_generator (regNo) values (?)";
		
		jdbcTemplate.update(sql, new Object[]{1});
	}
	
	public void updateRegNo(){
		String sql = "Update reg_no_generator set regNo = regNo+1";
		
		jdbcTemplate.update(sql);
	}
}
