package com.psc.authentication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.psc.authentication.domain.Accounts;
import com.psc.authentication.mgr.AccountsMgr;

public class AccountsService {
	@Autowired
	AccountsMgr accountssmgr;
	static final Logger logger = Logger.getLogger(AccountsService.class);

	public Accounts authenticationAccounts(Accounts accounts) {
		return accountssmgr.getAccounts(accounts);
	}

	public void accounts(String user_id, String username, String password,
			String config) {
	}
}
