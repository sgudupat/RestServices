package com.psc.users.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psc.users.domain.UserInfo;

public class UserInfoDao {
	
	
	 @Autowired  
	 DataSource dataSource;  
	 
	 
	 static final Logger logger = Logger.getLogger(UserInfoDao.class); 

	public void  insertUserinfo(UserInfo userinfo) {
		
		 Connection conn=null;
			
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		  
		  String sql = "INSERT INTO user_info "  
		    + "(uid,firstname, lastname, age,gender) VALUES (?, ?, ?,?)";  
		  
		  
		  
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		  
		  jdbcTemplate.update(  
		    sql,  
		    new Object[] { userinfo.getId(),userinfo.getFirstname(),userinfo.getLastname(),userinfo.getAge(),userinfo.getGender() });
		  try {
			conn.commit();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

}

}

