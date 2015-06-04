package com.psc.users.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;

public class UserInfoDao extends ConnectionDao {
	
	
	
	 
	 
	 static final Logger logger = Logger.getLogger(UserInfoDao.class); 

	public void  insertUserinfo(UserInfo userinfo) {
		User user=new User();
		
		
	
			//System.out.println("user info id"+userinfo.getId());
			//System.out.println("user  id"+user.getUsername());
			
			String sql2 = "SELECT max(uid) FROM users";
			 
			int id = getJdbcTemplate().queryForInt(sql2);
			System.out.println("user  id"+id);  
		  
		 /* String sql = "INSERT INTO user_info "  
		    + "(uid,firstname, lastname, age,gender) VALUES (?, ?, ?,?,?)";  
		  
		  
		  
		  
		  jdbcTemplate.update(  
		    sql,  
		    new Object[] { id,userinfo.getFirstname(),userinfo.getLastname(),userinfo.getAge(),userinfo.getGender() });*/
		
		
		String sql = "INSERT INTO user_info  (uid,firstname, lastname, age,gender) VALUES (:id, :firstname, :lastname,:age,:gender)";
		 Map namedParameters = new HashMap();     
		   namedParameters.put("id", id);     
		      namedParameters.put("firstname", userinfo.getFirstname());  
		      namedParameters.put("lastname", userinfo.getLastname());  
		      namedParameters.put("age", userinfo.getAge());  
		      namedParameters.put("gender", userinfo.getGender());  
		 
		namedParameterJdbcTemplate.update(sql, namedParameters);

}

}

