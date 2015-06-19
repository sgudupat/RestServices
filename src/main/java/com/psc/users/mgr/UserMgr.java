package com.psc.users.mgr;

import org.apache.log4j.Logger;
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
	static final Logger logger = Logger.getLogger(UserMgr.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
	public User insertUser(User user) throws CustomException {
		User user1 = userDao.insertUser(user);
		System.out.println("user object" + user1.getId());
		return user1;
	}
	
		public User loginUser(User user) throws CustomException {
			 
			User user1=userDao.loginUser(user);
			
			if(user1!=null){
			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
			
		boolean a=passwordEncryptor.checkPassword(user.getPassword(), user1.getPassword());
		
				
				System.out.println("password decryption is fine.Authenticated login"+a);
			
			return user1;
			}else
				
				
			return null;	
			
		}
}