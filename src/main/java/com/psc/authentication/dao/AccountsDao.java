package com.psc.authentication.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.psc.authentication.domain.Account;
import com.psc.users.dao.ConnectionDao;

public class AccountsDao extends ConnectionDao {
	static final Logger logger = Logger.getLogger(AccountsDao.class);
	public Account getAccounts(Account accounts) {
		String query = "SELECT * FROM authentication_accounts where username = ?";
		System.out.println("SQL" + query + "USERNAME" + accounts.getUsername());
		try {
			System.out.println("jdbcTemplate::" + jdbcTemplate);
			List<Account> accts = jdbcTemplate.query(query, new Object[]{accounts.getUsername()}, new AccountsRowMapper());
			if (accts == null || accts.size() == 0) {
				return null;
			} else if (accts.size() > 0) {
				return accts.get(0);
			}
			return null;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	private class AccountsRowMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account acnt = new Account();
			acnt.setUsername(rs.getString("username"));
			acnt.setPassword(rs.getString("password"));
			acnt.setConfig(rs.getString("config"));
			System.out.println("ACCOUNT ROWMAPPER" + acnt);
			return acnt;
		}
	}
}