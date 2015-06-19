package com.psc.users.client;

import com.psc.authentication.domain.Account;
import com.psc.authentication.service.AccountsService;
import com.psc.common.MessageBundle;
import com.psc.exceptions.AuthenticationException;
import com.psc.exceptions.CustomException;
import com.psc.exceptions.LoginException;
import com.psc.exceptions.UserException;
import com.psc.exceptions.UserValidationException;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.service.UserService;
import com.psc.users.util.UserUtil;
import com.psc.validator.Validator;
import com.psc.users.client.ContactRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class RegistrationController {
	@Autowired
	UserService userservice;

	@Autowired
	AccountsService accountService;

	@Autowired
	Validator validator;

	static final Logger logger = Logger.getLogger(RegistrationController.class);
	private static final MessageBundle messageBundle = MessageBundle
			.getInstance();

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserResponse addUser(@RequestBody UserRequest userRequest)
			throws CustomException {
		try {

			System.out.println("user request controller "
					+ userRequest.toString());

			// Validator validator=new Validator();
			// logger.info("Registrationj controller:"+ userRequest.toString());
			// Authentication validation
			validator.authenticateRequest(userRequest);
			// User Request Validation
			Validator.validateUserRequest(userRequest);
			// Build objects for Adding User
			logger.debug("user request" + userRequest.toString());
			User user = UserUtil.buildUserFromUserRequest(userRequest);
			UserInfo userInfo = UserUtil
					.buildUserInfoFromUserRequest(userRequest);
			// Register the User
			userservice.registerUser(user, userInfo);
			return new UserResponse("01", "user added");
		} catch (UserValidationException e) {
			String errorMsg = "exceptions.UserValidationException."
					+ e.getMessage();
			UserResponse userResponse = new UserResponse(
					messageBundle.getMessage(errorMsg + ".responseCode"),
					messageBundle.getMessage(errorMsg + ".responseDescription"));
			return userResponse;
		} catch (AuthenticationException e) {
			String errorMsg = "exceptions.AuthenticationException."
					+ e.getMessage();
			System.out.println("authentication exception " + errorMsg);
			logger.info("authentication exception  " + errorMsg);
			System.out.println("message bundle code "
					+ messageBundle.getMessage(errorMsg + ".responseCode")
					+ "  message bundle message  "
					+ messageBundle.getMessage(errorMsg
							+ ".responseDescription"));
			UserResponse userResponse = new UserResponse(
					messageBundle.getMessage(errorMsg + ".responseCode"),
					messageBundle.getMessage(errorMsg + ".responseDescription"));
			System.out.println("userresponse " + userResponse.getMessage()
					+ " " + userResponse.getCode());
			return userResponse;
		} catch (UserException e) {
			String errorMsg = "exceptions.UserException." + e.getMessage();
			UserResponse userResponse = new UserResponse(
					messageBundle.getMessage(errorMsg + ".responseCode"),
					messageBundle.getMessage(errorMsg + ".responseDescription"));
			return userResponse;
		}

		catch (Exception e2) {
			System.out.println("exception " + e2);
			return new UserResponse(6, e2.getMessage());
		}
	}

	@RequestMapping(value = "/Login", produces = { "application/json" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserResponse loginUser(@RequestBody UserRequest userRequest)
			throws CustomException {

		   try {
	        	
		        
		         validator.authenticateRequest(userRequest); 
	        	   Validator.validateLoginRequest(userRequest);	 
	        	   logger.debug("user request" + userRequest.toString());
	               User user = UserUtil.buildUserFromUserRequest(userRequest);       
	        	 
	        	  User user1 = userservice.loginUser(user);
	        	  System.out.println("user1 object" +user1);
	     		  if(user1 != null){
	     			 return new UserResponse("1","successful login");
	     		 }else{
	     			 return new UserResponse("5","unsuccessful login");}
	     		
	            
	      	 
	   }catch (LoginException e) {
	 	            String errorMsg = "exceptions.LoginException." + e.getMessage();
		            UserResponse userResponse = new UserResponse(messageBundle.getMessage(errorMsg + ".responseCode"), messageBundle.getMessage(errorMsg + ".responseDescription"));
		            return userResponse;
		        }
		 catch (Exception e) {
		        	System.out.println("exception "+ e);
		            return new UserResponse(7, e.getMessage());
		        }

	}
	
	
	@RequestMapping(value = "/addconatct", produces = { "application/json" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserResponse addContact(@RequestBody ContactRequest contactRequest)
			throws CustomException {
		
		
				return null;
	
	}
}
