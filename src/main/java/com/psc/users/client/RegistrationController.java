package com.psc.users.client;

import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.psc.authentication.domain.Accounts;
import com.psc.authentication.service.AccountsService;
import com.psc.exceptions.CustomException;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.service.UserService;
import com.psc.users.util.UserUtil;
import com.psc.validator.Validator;

@Controller
@RequestMapping("/users")
public class RegistrationController {
	@Autowired
	UserService userservice;
	@Autowired
	AccountsService acountService;
	static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserResponse adduser(@RequestBody UserRequest userRequest)
			throws CustomException {
		Accounts acnt = new Accounts();
		acnt.setUsername(userRequest.getAusername());
		acnt.setPassword(userRequest.getApassword());
		boolean apass = Validator.validateApassword(userRequest.getApassword());
		System.out.println("apassword value" + apass);
		if (apass == false) {
			return new UserResponse(3, "Apassword is missing");
		}
		boolean auser = Validator.validateAusername(userRequest.getAusername());
		System.out.println("auser value" + auser);
		if (auser == false) {
			return new UserResponse(3, "Ausername is missing");
		}
		Accounts acnts = acountService.authenticationAccounts(acnt);
		if (acnts == null) {
			return new UserResponse(2, "authentication denied");
		}
		System.out.println("authentication username" + acnts.getUsername());
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		if (acnts.getUsername().equals(userRequest.getAusername())
				&& passwordEncryptor.checkPassword(userRequest.getApassword(),
						acnts.getPassword())) {
			System.out
					.println("password decryption is fine.Authenticated login");
			boolean pass = Validator.validatePasswordvalid(userRequest
					.getPassword());
			if (pass == false) {
				return new UserResponse(3, "Invalid password");
			}
			boolean us = Validator.validateUsername(userRequest.getUsername());
			if (us == false) {
				return new UserResponse(3, "Username missing or empty");
			}
			boolean pa = Validator.validatePassword(userRequest.getPassword());
			if (pa == false) {
				return new UserResponse(3, "Password missing or empty");
			}
			boolean mob = Validator.validateMobile(userRequest.getMobile());
			if (mob == false) {
				return new UserResponse(3, "Mobile number missing or empty");
			}
			boolean email = Validator.validateEmail(userRequest.getEmail());
			if (email == false) {
				return new UserResponse(3, "email is  missing or empty");
			}
			boolean fname = Validator.validateFirstName(userRequest
					.getFirstname());
			if (fname == false) {
				return new UserResponse(3, "fname is   missing or empty");
			}
			boolean lname = Validator.validateLastName(userRequest
					.getLastname());
			if (lname == false) {
				return new UserResponse(3, "lastname is  missing or empty");
			}
			boolean gende = Validator.validateGender(userRequest.getGender());
			if (gende == false) {
				return new UserResponse(3, "gender is missing or empty");
			}
			boolean age = Validator.validateAge(userRequest.getAge());
			if (age == true) {

				return new UserResponse(3, "age cannot be null or missing");
			}
			boolean em = Validator.validateEmailvalid(userRequest.getEmail());
			if (em == false) {
				return new UserResponse(3, "Email is not valid");
			}
			boolean mobi = Validator.validateMobilevalid(userRequest
					.getMobile());
			if (mobi == false) {
				return new UserResponse(3, "Mobile no is not valid");
			}
			logger.debug("user request" + userRequest.toString());
			logger.error("My custom error");
			User user = UserUtil.buildUserFromUserRequest(userRequest);
			UserInfo userInfo = UserUtil
					.buildUserInfoFromUserRequest(userRequest);
			String msg = userservice.registerUser(user, userInfo);
			System.out.println("messgae " + msg);
			if (msg == null || msg == "") {
				return new UserResponse(5, "user added");
			}
			return new UserResponse(6, msg);
		} else {

			return new UserResponse(5, "Authentication denied");
		}
	}
}
