package com.psc.users.client;

import java.io.IOException;









import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psc.authentication.domain.Accounts;
import com.psc.authentication.service.AccountsService;
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
	UserResponse adduser(@RequestBody UserRequest userRequest,@RequestParam("header") String json) {  
		//todo: authenticate user
		JSONObject json1 = null;
		logger.debug("user"+json);
	try {
		json1 = (JSONObject)new JSONParser().parse(json);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String auser=(String) json1.get("auser");
	String apwd=(String) json1.get("pwd");
	String config=(String) json1.get("config");	
	//System.out.println("auser"+auser+"password"+apwd+"config"+config);
	Accounts acnt=new Accounts();
	acnt.setUsername(auser);
	acnt.setPassword(apwd);
	acnt.setConfig(config);
	//System.out.println("cotroller acnt"+acnt);
	Accounts acnts=acountService.authenticationAccounts(acnt);
	//System.out.println("authentication username"+acnts.getUsername());
	if(acountService.authenticationAccounts(acnt)== null){
		return new UserResponse(3,"Authentication denied");
	}
	
	if(acnts.getUsername().equals(auser)){
		
	
	
		//validate user request object
		
		/*if(StringUtils.isNotBlank(userRequest.getUsername())&& StringUtils.isNotBlank(userRequest.getPassword())&& StringUtils.isNotBlank(userRequest.getEmail())&& StringUtils.isNotBlank(userRequest.getMobile())&& StringUtils.isNotBlank(userRequest.getFirstname())&& StringUtils.isNotBlank(userRequest.getLastname()) && StringUtils.isNotBlank(userRequest.getGender())){
			
			return new UserResponse(3,"all fields are mandatory");
		}*/
			
			if(StringUtils.isBlank(userRequest.getUsername()) || StringUtils.isBlank(userRequest.getPassword())){
				return new UserResponse(3,"username or password cannot be null");
				
			}else{
			
				//passwordvalidation
		        boolean pass=Validator.validatePassword(userRequest.getPassword());
		        if(pass == false){
		        	//System.out.println("password valid");		        	
		        	return new UserResponse(3,"Invalid password");
		        }
		        
		        boolean mob=Validator.validatemobile(userRequest.getMobile());
		        if(mob == false){
		        	//System.out.println("password valid");		        	
		        	return new UserResponse(3,"Mobile number missing or empty");
		        }
		        
		        boolean email=Validator.validateemail(userRequest.getEmail());
		        if(email == false){
		        	//System.out.println("password valid");		        	
		        	return new UserResponse(3,"email is  missing or empty");
		        }
		        boolean pwd=Validator.validatepasswrd(userRequest.getPassword());
		        if(pwd == false){
		        	//System.out.println("password valid");		        	
		        	return new UserResponse(3,"passwordd is  missing or empty");
		        }
		        boolean fname=Validator.validateFirstName(userRequest.getFirstname());
		        		   if(fname == false){
		   		        	//System.out.println("password valid");		        	
		   		        	return new UserResponse(3,"fname is   missing or empty");
		   		        }
		       boolean lname=Validator.validateLastName(userRequest.getLastname()) ;	
		       if(lname == false){
  		        	//System.out.println("password valid");		        	
  		        	return new UserResponse(3,"lastname is  missing or empty");
  		        }
		       boolean gender=Validator.validategender(userRequest.getLastname());
		       if(gender == false){
 		        	//System.out.println("password valid");		        	
 		        	return new UserResponse(3,"gender is missing or empty");
 		        }
		
	//System.out.println(userRequest.toString());
	//System.out.println("request json mapping "+userRequest.getFirstname());
	logger.debug("user request"+userRequest.toString());
		
		//Build user and userInfo objects
		User user = UserUtil.buildUserFromUserRequest(userRequest);
		UserInfo userInfo = UserUtil.buildUserInfoFromUserRequest(userRequest);
		System.out.println(" user "+user);
		//Register the User
		userservice.registerUser(user, userInfo);
		return new UserResponse(5,"user added");
			
	}
		
	}
	else{
		
		return new UserResponse(3,"Authentication denied");
		
	}
	
	
	
	}
}  
