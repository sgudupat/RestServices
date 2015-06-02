package com.psc.users.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.psc.users.dao.UserDao;
import com.psc.users.domain.User;

public class UserMgr {

	@Autowired
	UserDao userDao;

	public void insertUser(User user) {
		userDao.insertUser(user);
	}
}