package com.psc.authentication.mgr;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.psc.authentication.dao.AccountsDao;
import com.psc.authentication.domain.Account;

public class AccountsMgr {
	@Autowired
	AccountsDao accountsDao;
	static final Logger logger = Logger.getLogger(AccountsMgr.class);

	public Account getAccounts(Account accounts) {
		return accountsDao.getAccounts(accounts);
	}
}
