package com.psc.users.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.service.UserService;
import com.psc.users.util.UserUtil;

@Controller  
@RequestMapping("/users")   
public class RegistrationController {  

	@Autowired
	UserService userservice;

	static final Logger logger = Logger.getLogger(RegistrationController.class);  

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public @ResponseBody  
	UserResponse adduser(@RequestBody UserRequest userRequest, @RequestParam("header") String json) {  
		//todo: authenticate user
		//validate user request object
		//Build user and userInfo objects
		User user = UserUtil.buildUserFromUserRequest(userRequest);
		UserInfo userInfo = UserUtil.buildUserInfoFromUserRequest(userRequest);
		//Register the User
		userservice.registerUser(user, userInfo);
		return new UserResponse(5,"authentication denied");
	}


}  