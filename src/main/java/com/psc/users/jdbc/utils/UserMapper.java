package com.psc.users.jdbc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.psc.users.domain.User;

@SuppressWarnings("rawtypes")
public class UserMapper implements RowMapper{
	 public User mapRow(ResultSet rs, int rowNum) throws SQLException {    
		  User usero = new User();    
		 usero.setUsername(rs.getString("username"));
		 usero.setId(rs.getInt("user_id"));
		 usero.setMobile(rs.getString("mobile"));
		 usero.setEmail(rs.getString("email"));
		
		 System.out.println("usermapper user"+usero);
		  return usero;    
		 }    

}
