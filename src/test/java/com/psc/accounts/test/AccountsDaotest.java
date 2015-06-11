package com.psc.accounts.test;


import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psc.authentication.dao.AccountsDao;
import com.psc.authentication.domain.Accounts;



@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Configurable(autowire = Autowire.BY_TYPE)
@RunWith(SpringJUnit4ClassRunner.class)

public class AccountsDaotest extends TestCase{
 
 static final Logger logger = Logger.getLogger(AccountsDaotest.class); 
  @Autowired 
 AccountsDao accountsDao;
 
  @Test
  public void testgetAccounts(){
   
  
   
   Accounts accounts=new Accounts();
  
   accounts.setUsername("david");
   
   System.out.println(accounts);
   
   accountsDao.getAccounts(accounts);
   
  }

}