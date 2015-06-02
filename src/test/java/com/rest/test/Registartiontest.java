package com.rest.test;

import junit.framework.TestCase;




import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psc.users.domain.User;
import com.psc.users.service.UserService;



@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Configurable(autowire = Autowire.BY_TYPE)
@RunWith(SpringJUnit4ClassRunner.class)
public class Registartiontest extends TestCase{
	
	
	 final static Logger logger = Logger.getLogger(Registartiontest.class);
	
	 @Autowired 
		UserService userservice;
	
	 
	 
	 @Test
	 public void testinsertdata(){
		// Register reg=new Register();
		 User user=new User();
		 user.setUsername("preethi");
		 user.setPassword("bhat");
		 user.setMobile("1234");
		 user.setEmail("preethi@gmail.com");
		// reg.setFirstname("preethi");
		// reg.setLastname("bhat");
		// reg.setAge(24);
		// reg.setGender("female");
		
		
		 try{
			//regdao.insertData(reg);
		// regservice.insertData(reg); 
		 //regbus.insertData(reg);
			 
			// userservice.insertUser(user);
		 }catch(Exception e){
			 e.printStackTrace();
			 
			 System.out.println("exception "+e);
			 
		 }
		 
	 }

}
