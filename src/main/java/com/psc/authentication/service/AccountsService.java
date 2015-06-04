package com.psc.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.psc.authentication.domain.Accounts;
import com.psc.authentication.mgr.AccountsMgr;



public class AccountsService {

	@Autowired
	AccountsMgr accountssmgr;

	

	public void authenticationAccounts(Accounts accounts){
		//validations
		//insert
		accountssmgr.getAccounts(accounts);
		
	}



	public void accounts(String user_id, String username, String password,
			String config) {
		// TODO Auto-generated method stub
		
	}
}
