package com.psc.accounts.test;


import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psc.authentication.dao.AccountsDao;
import com.psc.authentication.domain.Account;
import com.psc.users.client.UserRequest;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Configurable(autowire = Autowire.BY_TYPE)
@RunWith(SpringJUnit4ClassRunner.class)

public class AccountsDaotest extends TestCase{

	static final Logger logger = Logger.getLogger(AccountsDaotest.class); 
	@Autowired 
	AccountsDao accountsDao;

	@Test
	public void testgetAccounts(){
		Account accounts=new Account();
		accounts.setUsername("murali");
		System.out.println(accounts);
		accountsDao.getAccounts(accounts);
	}


	@Test
	public void testValidations(){
		UserRequest userRequest=new UserRequest();
		userRequest.setApassword("");
		System.out.println("user paswword"+userRequest.getApassword());
		
		//System.out.println("NuLL:" + StringUtils.isEmpty(null));
		//System.out.println("blank:" + StringUtils.isEmpty(""));
		//System.out.println(" space:" + StringUtils.isEmpty(" "));
		//System.out.println("NuLL:" + StringUtils.isBlank(null));
		System.out.println("blank:" + StringUtils.isBlank(userRequest.getApassword()));
		//System.out.println(" space:" + StringUtils.isBlank(" "));
		//System.out.println("NuLL:" + StringUtils.isEmpty(null));

	}}