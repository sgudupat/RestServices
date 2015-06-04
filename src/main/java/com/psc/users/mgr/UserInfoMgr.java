package com.psc.users.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.psc.users.dao.UserInfoDao;
import com.psc.users.domain.UserInfo;

public class UserInfoMgr {

	@Autowired  
	UserInfoDao userInfoDao;  

	 @Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=RuntimeException.class)
	public void inserUserInfo(UserInfo userinfo) {
		userInfoDao.insertUserinfo(userinfo);
	}
}