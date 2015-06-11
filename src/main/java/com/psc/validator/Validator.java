package com.psc.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
public class Validator {	
	private static Pattern pswNamePtrn =
	        Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
	private static Pattern emailNamePtrn = Pattern.compile(
		    "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");	     
	private static Pattern expression = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");	
	public static boolean validatePasswordvalid(String userName){	         
	        Matcher mtch = pswNamePtrn.matcher(userName);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	        }	    
	    public static boolean validateEmailvalid(String Email){
	    	Matcher mtch = emailNamePtrn.matcher(Email);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	    }  	    
	    public static boolean validateEmail(String email){
	    	if(StringUtils.isNotBlank(email)){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validatePassword(String pwd){
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
	    public static boolean validateMobile(String Mobile){
	    	if(StringUtils.isNotBlank(Mobile)){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validateUsername(String Username){
	    	if(StringUtils.isNotBlank(Username)){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validateGender(String gender){
	    	if(StringUtils.isNotBlank(gender)){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validateMobilevalid(String Mobile){
	         
	        Matcher mtch = expression.matcher(Mobile);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	    }
	    public static boolean validateAge(int age){	    	
	    	System.out.println("validator age"+age);
	    if(age==0){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validateAusername(String Ausername){
	    	if(StringUtils.isNotBlank(Ausername)){
	    	return true;
	    	}
	    	return false;
	    	}
	    public static boolean validateApassword(String Apassword){
	    	if(StringUtils.isNotBlank(Apassword)){
	    	return true;
	    	}
	    	return false;
	    	}
	    }
