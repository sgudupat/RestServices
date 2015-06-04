package com.psc.authentication.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psc.authentication.domain.Accounts;




public class AccountsDao  {

	static final Logger logger = Logger.getLogger(AccountsDao.class); 
	@Autowired  
	DataSource dataSource;  
	

	public void  getAccounts(Accounts accounts) {
		String sql = "SELECT * FROM Accounts "  
				+ "(username,password, config) VALUES (?, ?, ?)";  
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		jdbcTemplate.update(  
				sql,  
				new Object[] { accounts.getUser_id(),accounts.getUsername(),accounts.getPassword(),accounts.getConfig()});

		

	}

}
