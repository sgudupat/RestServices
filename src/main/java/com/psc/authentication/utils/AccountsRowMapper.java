package com.psc.authentication.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.psc.authentication.domain.Accounts;

@SuppressWarnings("rawtypes")
public class AccountsRowMapper implements RowMapper {
	static final Logger logger = Logger.getLogger(AccountsRowMapper.class);

	public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
		Accounts acnt = new Accounts();
		acnt.setUsername(rs.getString("username"));
		acnt.setPassword(rs.getString("password"));
		acnt.setConfig(rs.getString("config"));
		System.out.println("ACCOUNT ROWMAPPER" + acnt);
		return acnt;
	}
}