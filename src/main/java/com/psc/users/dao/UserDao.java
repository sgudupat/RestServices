package com.psc.users.dao;
import org.apache.log4j.Logger;

import com.psc.users.domain.User;


public class UserDao extends ConnectionDao {

	static final Logger logger = Logger.getLogger(UserDao.class); 

	public void  insertUser(User user) {
		String sql = "INSERT INTO users "  
				+ "(username,password, email, mobile) VALUES (?, ?, ?,?)";  
		jdbcTemplate.update(  
				sql,  
				new Object[] { user.getUsername(),user.getPassword(),user.getEmail(),user.getMobile() });

		

	}

}
