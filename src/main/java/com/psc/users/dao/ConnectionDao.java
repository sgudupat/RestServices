package com.psc.users.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionDao {

	@Autowired  
	DataSource dataSource;  

	protected JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  

}
