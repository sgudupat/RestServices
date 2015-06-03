package com.psc.users.dao;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psc.users.domain.User;


public class UserDao  {

	static final Logger logger = Logger.getLogger(UserDao.class); 
	@Autowired  
	DataSource dataSource;  
	

	public void  insertUser(User user) {
		String sql = "INSERT INTO users "  
				+ "(username,password, email, mobile) VALUES (?, ?, ?,?)";  
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		jdbcTemplate.update(  
				sql,  
				new Object[] { user.getUsername(),user.getPassword(),user.getEmail(),user.getMobile() });

		

	}

}
