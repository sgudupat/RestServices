package com.psc.users.util;

import com.psc.users.client.UserRequest;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;

public class UserUtil {
	public static User buildUserFromUserRequest(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setMobile(request.getMobile());
		return user;
	}

	public static UserInfo buildUserInfoFromUserRequest(UserRequest request) {
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(request.getAge());
		userInfo.setFirstname(request.getFirstname());
		userInfo.setLastname(request.getLastname());
		userInfo.setGender(request.getGender());
		return userInfo;
	}
}
