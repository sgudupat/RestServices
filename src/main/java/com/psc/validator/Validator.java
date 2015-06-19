package com.psc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.psc.authentication.domain.Account;
import com.psc.authentication.service.AccountsService;
import com.psc.exceptions.AuthenticationException;
import com.psc.exceptions.LoginException;
import com.psc.exceptions.UserValidationException;
import com.psc.users.client.LoginRequest;
import com.psc.users.client.UserRequest;
import com.psc.users.domain.User;

public class Validator {

	@Autowired
	AccountsService accountService;

	AccountsService accountService1 = new AccountsService();

	static final Logger logger = Logger.getLogger(Validator.class);

	private static Pattern pswNamePtrn = Pattern
			.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
	private static Pattern emailNamePtrn = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static Pattern mobileptrn = Pattern
			.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");

	public Account authenticateRequest(UserRequest userRequest)
			throws AuthenticationException {

		if (StringUtils.isBlank(userRequest.getApassword())) {
			System.out.println("Pswword is blank");
			throw new AuthenticationException("AuthenticatepasswordMissing");
		}

		if (StringUtils.isBlank(userRequest.getAusername())) {
			throw new AuthenticationException("AuthenticateuserMissing");
		}
		System.out.println("No exceptions");
		Account acnt = new Account();
		acnt.setUsername(userRequest.getAusername());
		acnt.setPassword(userRequest.getApassword());
		System.out.println("acounts: " + acnt);

		System.out.println("accountService: " + accountService);
		Account acnts = accountService.authenticationAccounts(acnt);
		if (acnts == null) {
			System.out.println("service acount: " + acnts);
			throw new AuthenticationException("AunthenticateDenied");
		}
		System.out.println("dao acnt: " + acnts.toString());
		// System.out.println("authentication username" + acnts.getUsername());
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		boolean auth = acnts.getUsername().equals(userRequest.getAusername())
				&& passwordEncryptor.checkPassword(userRequest.getApassword(),
						acnts.getPassword());
		if (auth == false) {

			throw new AuthenticationException("AunthenticateDenied");

		}
		return acnts;
	}

	public static void validateUserRequest(UserRequest userRequest)
			throws UserValidationException {

		System.out.println("Inside userrequest validation");
		// Username validation
		if (StringUtils.isBlank(userRequest.getUsername())) {
			throw new UserValidationException("userNotValid");
		}
		// Password validation
		if (StringUtils.isBlank(userRequest.getPassword())) {
			throw new UserValidationException("passwordIsEmpty");
		} else {
			Matcher mtch = pswNamePtrn.matcher(userRequest.getPassword());
			if (!(mtch.matches())) {
				throw new UserValidationException("passwordNotValid");
			}
		}
		// Validate Mobile

		if (StringUtils.isBlank(userRequest.getMobile())) {
			throw new UserValidationException("mobileIsEmpty");
		} else {
			Matcher mtch = mobileptrn.matcher(userRequest.getMobile());
			if (!(mtch.matches())) {
				throw new UserValidationException("mobileNotValid");
			}
		}

		// Validate email
		if (StringUtils.isBlank(userRequest.getEmail())) {
			throw new UserValidationException("emailIsEmpty");
		} else {
			Matcher mtch = emailNamePtrn.matcher(userRequest.getEmail());
			if (!(mtch.matches())) {
				throw new UserValidationException("emailNotValid");
			}
		}

		// Validate Firstname

		if (StringUtils.isBlank(userRequest.getFirstname())) {
			throw new UserValidationException("firstnameIsEmpty");
		}

		// Validate lastname
		if (StringUtils.isBlank(userRequest.getLastname())) {
			throw new UserValidationException("lastnameIsEmpty");
		}
		// Validate gender
		if (StringUtils.isBlank(userRequest.getGender())) {
			throw new UserValidationException("genderIsEmpty");
		}

	}
	
	
    public static User validateLoginRequest(UserRequest userRequest) throws UserValidationException, LoginException {
        if (StringUtils.isBlank(userRequest.getUsername())&& (StringUtils.isBlank(userRequest.getMobile())&&(StringUtils.isBlank(userRequest.getEmail()))))  {  
            throw new LoginException("loginDataIsEmpty");
        }
        // validate password
        if (StringUtils.isBlank(userRequest.getPassword())) {
        	System.out.println("Password is blank");
            throw new LoginException("LoginpasswordMissing");
            
        }  else {
            Matcher mtch = pswNamePtrn.matcher(userRequest.getPassword());
            if (!(mtch.matches())) {
                throw new UserValidationException("LoginpasswordNotValid");
            }         
       // validate username password
        if (StringUtils.isEmpty(userRequest.getUsername()) || (StringUtils.isEmpty(userRequest.getPassword())))  {  
            throw new LoginException("loginFieldIsEmpty");
        }
		return null;
        
    }

}
}
