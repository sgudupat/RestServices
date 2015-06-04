package com.psc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Validator {
	
	private static Pattern pswNamePtrn =
	        Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
	     
	    public static boolean validatePassword(String userName){
	         
	        Matcher mtch = pswNamePtrn.matcher(userName);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	    }
	    
	
	    public static boolean validatemobile(String mobile){
	    	if(StringUtils.isNotBlank(mobile)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    public static boolean validateemail(String email){
	    	if(StringUtils.isNotBlank(email)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    public static boolean validatepasswrd(String pwd){
	    	if(StringUtils.isNotBlank(pwd)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    public static boolean validateFirstName(String fname){
	    	if(StringUtils.isNotBlank(fname)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    public static boolean validateLastName(String lname){
	    	if(StringUtils.isNotBlank(lname)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    public static boolean validategender(String gender){
	    	if(StringUtils.isNotBlank(gender)){
	    	return true;
	    	}
	    	return false;
	    	
	    }
	    
}
