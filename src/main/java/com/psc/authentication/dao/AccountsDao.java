package com.psc.authentication.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.psc.authentication.domain.Accounts;
import com.psc.authentication.utils.AccountsRowMapper;
import com.psc.users.dao.ConnectionDao;




public class AccountsDao extends ConnectionDao  {

	static final Logger logger = Logger.getLogger(AccountsDao.class); 
	@Autowired  
	DataSource dataSource;  
	

	public Accounts  getAccounts(Accounts accounts) {
		 String SQL = "SELECT * FROM authentication_accounts where username = :username";  
		 SqlParameterSource namedParameters = new MapSqlParameterSource("username", accounts.getUsername());  
		 System.out.println("SQL"+SQL+"USERNAME"+accounts.getUsername());
		 Accounts acnt = (Accounts) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new AccountsRowMapper()); 
		 return acnt;  
		

		

	}

}
