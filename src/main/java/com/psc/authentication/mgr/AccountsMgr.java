package com.psc.authentication.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.psc.authentication.dao.AccountsDao;
import com.psc.authentication.domain.Accounts;



public class AccountsMgr {
	@Autowired
	AccountsDao accountsDao;

	public Accounts getAccounts(Accounts accounts) {
		return accountsDao.getAccounts(accounts);
	}

}
