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

import com.patientsProfile.model.User;

@Service
@Transactional
public class UserService {

	private JdbcTemplate jdbcTemplate;
	
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<User> getAll(){
		String sql = "Select * from user";
				
		return (List<User>) jdbcTemplate.query(sql, getMapper());
	}
	
	public User getByUsername(String userName){
		String sql = "Select * from user where userName = ?";
				
		User user = jdbcTemplate.queryForObject(sql, new Object[]{userName}, getMapper());
		
		return user;
	}
	
	private RowMapper<User> getMapper(){
		RowMapper<User> mapper = new RowMapper<User>(){
			public User mapRow(ResultSet rs, int numRow) throws SQLException{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setRole(rs.getString("role"));
				return user;
			}
		};
		return mapper;
	}
}
