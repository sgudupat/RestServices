package com.psc.users.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.psc.exceptions.AuthenticationException;
import com.psc.exceptions.CustomException;
import com.psc.exceptions.UserException;
import com.psc.users.dao.UserDao;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.mgr.UserInfoMgr;
import com.psc.users.mgr.UserMgr;

public class UserService {
	UserInfo userinfo = new UserInfo();
	@Autowired
	UserMgr usermgr;
	@Autowired
	UserDao userdao;
	@Autowired
	UserInfoMgr userInfoMgr;
	static final Logger logger = Logger.getLogger(UserService.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
	public String registerUser(User user, UserInfo userInfo)
			throws UserException {
		User userda = userdao.getUser(user);
		if (userda != null) {
			if (userda.getUsername().equals(user.getUsername())) {
				 throw new UserException("UserNameExists");
			}
			if (userda.getMobile().equals(user.getMobile())) {
				 throw new UserException("MobileExists");
			}
			if (userda.getEmail().equals(user.getEmail())) {
				throw new UserException("EmailExists");
			}
		}
		User userCreated = usermgr.insertUser(user);
		System.out.println("Service layer usrcreated object"
				+ userCreated.getId() + "user name" + userCreated.getUsername()
				+ "mobile" + userCreated.getMobile());
		userInfo.setId(userCreated.getId());
		System.out.println("user info object" + userInfo);
		userInfoMgr.inserUserInfo(userInfo);
		return null;
	}
	
	public User loginUser(User user) throws CustomException {
		
		
		User user1=	usermgr.loginUser(user);
		System.out.println("user1 object" +user1);
			
			return user1;
	
	
	}
}