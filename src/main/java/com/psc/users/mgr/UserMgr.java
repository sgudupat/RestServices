package com.psc.users.mgr;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.psc.exceptions.CustomException;
import com.psc.users.dao.UserDao;
import com.psc.users.domain.User;

public class UserMgr {

	@Autowired
	UserDao userDao;
	
	

	
	
	 @Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=RuntimeException.class)
	public void insertUser(User user) throws CustomException {
		userDao.insertUser(user);
	}
}