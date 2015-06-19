package com.psc.authentication.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.psc.authentication.domain.Account;
import com.psc.authentication.mgr.AccountsMgr;

public class AccountsService {
	@Autowired
	AccountsMgr accountssmgr;
	static final Logger logger = Logger.getLogger(AccountsService.class);

	public Account authenticationAccounts(Account accounts) {
		return accountssmgr.getAccounts(accounts);
	}

	
}
