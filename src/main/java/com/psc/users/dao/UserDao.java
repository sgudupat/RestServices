package com.psc.users.dao;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;


public class UserDao extends ConnectionDao {

	static final Logger logger = Logger.getLogger(UserDao.class); 
	
	UserInfo userInfo=new UserInfo();

	public void  insertUser(User user) {
	/*	String sql = "INSERT INTO users "  
				+ "(username,password, email, mobile) VALUES (?, ?, ?,?)";  
		
		
		jdbcTemplate.update(  
				sql,  
				new Object[] { user.getUsername(),user.getPassword(),user.getEmail(),user.getMobile() });
		
		String sql2 = "SELECT uid FROM users WHERE username = ?";
		 
		Integer id = getJdbcTemplate().queryForObject(
				sql2, new Object[] { user.getUsername() }, 	Integer.class);
		
		System.out.println("USERID "+ id);
		
		userInfo.setId(id);*/
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		
		String sql="INSERT INTO users (username, password, email,mobile) VALUES (:username, :password, :email,:mobile)";
		 Map namedParameters = new HashMap();     
	      namedParameters.put("username", user.getUsername());     
	      namedParameters.put("password", encryptedPassword);  
	      namedParameters.put("email", user.getEmail());  
	      namedParameters.put("mobile", user.getMobile());  
	 
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
		
		

		

	}

}
