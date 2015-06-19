package com.psc.users.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.psc.exceptions.CustomException;
import com.psc.users.domain.User;
import com.psc.users.jdbc.utils.UserMapper;

public class UserDao extends ConnectionDao {
	static final Logger logger = Logger.getLogger(UserDao.class); 
	public User getUser(User user){		
		 String sql2="Select * from users where username=:username or mobile=:mobile or email=:email";		;  
		 SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("username", user.getUsername()).addValue("mobile", user.getMobile()).addValue("email", user.getEmail());
		 try{	  
				System.out.println("namedParameterJdbcTemplate::" + namedParameterJdbcTemplate);
		User userd=(User) namedParameterJdbcTemplate.queryForObject(sql2, namedParameters, new UserMapper());  
		  System.out.println("user dao get user "+userd);
		  return userd; 
	}catch(EmptyResultDataAccessException e){		
		return null;
	}		
	}
	public User  insertUser(User user) throws CustomException {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		
		String sql="INSERT INTO users (username, password, email,mobile) VALUES (:username, :password, :email,:mobile)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
	 try{
		namedParameterJdbcTemplate.update(sql, parameterSource);
	 }catch(DuplicateKeyException d){
		 
		throw new CustomException("This is custom message");		 
	 } 
	 String sql2="Select * from users where username=:username";
	  SqlParameterSource namedParameters = new MapSqlParameterSource("username", user.getUsername());	  
	  @SuppressWarnings("unchecked")
	User usero=(User) namedParameterJdbcTemplate.queryForObject(sql2, namedParameters, new UserMapper());  
	  System.out.println("user dao "+usero);
	  return usero;
	}
	
	 public User loginUser(User user) {
		    String query1 = "Select * from users where username=:username or mobile=:mobile or email=:email";
		    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("username", user.getUsername()).addValue("mobile", user.getMobile()).addValue("email", user.getEmail());
		    try{	  
				System.out.println("namedParameterJdbcTemplate::" + namedParameterJdbcTemplate);
		User user1=(User) namedParameterJdbcTemplate.queryForObject(query1, namedParameters, new UserMapper());  
		  System.out.println("login user "+user1);
		  return user1; 
	}catch(EmptyResultDataAccessException e){		
		return null;
	}		
		   }
		 private  class UserRowMapper implements RowMapper {
		    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		     User acnt = new User();
		     acnt.setUsername(rs.getString("username"));
		     acnt.setPassword(rs.getString("password"));
		     System.out.println(" logindao row mapper  " +acnt);
		  return acnt;    

		 
		   }

		
		 

		
		 }
		 
	
	
	}
