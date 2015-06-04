package com.psc.authentication.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.psc.authentication.domain.Accounts;

public class AccountsRowMapper implements RowMapper {    
	 public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {    
	  Accounts acnt = new Accounts();    
	     acnt.setUsername(rs.getString("username"));
	     acnt.setPassword(rs.getString("password"));
	     acnt.setConfig(rs.getString("config"));	
	     System.out.println("ACCOUNT ROWMAPPER"+acnt);
return acnt;    
	 }    
	}    