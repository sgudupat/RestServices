package com.psc.users.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.psc.users.dao.UserInfoDao;
import com.psc.users.domain.UserInfo;

public class UserInfoMgr {

	@Autowired  
	UserInfoDao userInfoDao;  

	public void inserUserInfo(UserInfo userinfo) {
		userInfoDao.insertUserinfo(userinfo);
	}
}