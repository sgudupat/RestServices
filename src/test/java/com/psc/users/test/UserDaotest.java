package com.psc.users.test;



import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psc.authentication.service.AccountsService;
import com.psc.users.dao.UserDao;
import com.psc.users.domain.User;
import com.psc.users.service.UserService;



@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Configurable(autowire = Autowire.BY_TYPE)
@RunWith(SpringJUnit4ClassRunner.class)

public class UserDaotest extends TestCase{
	
	static final Logger logger = Logger.getLogger(UserDaotest.class); 
	 @Autowired 
	UserDao userDao;
	
	
	 @Test
	 public void testinsertUser(){
		 
		
		 
		 User user=new User();
		 user.setEmail("murali@gmail.com");
		 user.setMobile("98876548");
		 user.setUsername("murali14");
		 user.setPassword("muraliM@123");
		 System.out.println(user);
		 
		 //userDao.insertUser(user);
		 
	 }
	 
	 
	 
	 @Test
	  public void testloginUser(){
	   User user=new User();
	   user.setUsername("murali");
	  // user.setPassword("denny");
	   //System.out.println(user);
	   userDao.loginUser(user);
	  }

}
