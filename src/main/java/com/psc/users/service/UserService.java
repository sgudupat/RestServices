package com.psc.users.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.mgr.UserInfoMgr;
import com.psc.users.mgr.UserMgr;

public class UserService {

	@Autowired
	UserMgr usermgr;

	@Autowired
	UserInfoMgr userInfoMgr;

	public void registerUser(User user, UserInfo userInfo){
		//validations
		//insert
		usermgr.insertUser(user);
		userInfoMgr.inserUserInfo(userInfo);
	}
}