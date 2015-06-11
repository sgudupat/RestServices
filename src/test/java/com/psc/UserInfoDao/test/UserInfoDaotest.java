package com.psc.UserInfoDao.test;
import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psc.users.dao.UserInfoDao;
import com.psc.users.domain.UserInfo;



@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@Configurable(autowire = Autowire.BY_TYPE)
@RunWith(SpringJUnit4ClassRunner.class)

public class UserInfoDaotest extends TestCase{
 
 static final Logger logger = Logger.getLogger(UserInfoDaotest.class); 
  @Autowired 
 UserInfoDao userInfoDao;
 
  @Test
  public void testinsertUserInfo(){
   
  
   
   UserInfo userInfo=new UserInfo();
   userInfo.setId(3);
   userInfo.setFirstname("david");
   userInfo.setLastname("son");
   userInfo.setAge(12);
   userInfo.setGender("male");
   System.out.println(userInfo);
   
   userInfoDao.insertUserinfo(userInfo);
   
  }

}