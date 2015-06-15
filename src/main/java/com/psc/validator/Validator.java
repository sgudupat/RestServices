package com.psc.validator;

import com.psc.authentication.domain.Accounts;
import com.psc.exceptions.AuthenticationException;
import com.psc.exceptions.UserValidationException;
import com.psc.users.client.UserRequest;
import com.psc.users.client.UserResponse;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.password.BasicPasswordEncryptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
    private static Pattern emailNamePtrn = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static Pattern expression = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");


    public static void authenticateRequest(UserRequest userRequest) throws AuthenticationException {
        boolean apass = Validator.validateApassword(userRequest.getApassword());
        System.out.println("apassword value" + apass);
        if (apass == false) {
            throw new AuthenticationException("");
        }
        boolean auser = Validator.validateAusername(userRequest.getAusername());
        System.out.println("auser value" + auser);
        if (auser == false) {
            throw new AuthenticationException("");
        }
        Accounts acnts = accountService.authenticationAccounts(acnt);
        if (acnts == null) {
            throw new AuthenticationException("");
        }
        System.out.println("authentication username" + acnts.getUsername());
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        if (acnts.getUsername().equals(userRequest.getAusername())
                && passwordEncryptor.checkPassword(userRequest.getApassword(), acnts.getPassword())) {
        }
    }

    public static void validateUserRequest(UserRequest userRequest) throws UserValidationException {
        //Username validation
        if (StringUtils.isBlank(userRequest.getUsername())) {
            throw new UserValidationException("userNotValid");
        }
        //Password validation
        if (StringUtils.isBlank(userRequest.getPassword())) {
            throw new UserValidationException("passwordIsEmpty");
        } else {
            Matcher mtch = pswNamePtrn.matcher(userRequest.getPassword());
            if (!(mtch.matches())) {
                throw new UserValidationException("passwordNotValid");
            }
        }
        //Validate Mobile

        boolean mob = Validator.validateMobile(userRequest.getMobile());
        if (mob == false) {
            return new UserResponse(3, "Mobile number missing or empty");
        }
        boolean email = Validator.validateEmail(userRequest.getEmail());
        if (email == false) {
            return new UserResponse(3, "email is  missing or empty");
        }
        Validator.validateFirstName(userRequest.getFirstname());
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
    }

    public static boolean validateEmailvalid(String Email) {
        Matcher mtch = emailNamePtrn.matcher(Email);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            return true;
        }
        return false;
    }


    public UserResponse validateFirstName(String fname) {
        if (StringUtils.isBlank(fname)) {
            return new UserResponse(3, "fname is   missing or empty");
        }
        return null;
    }

    public static boolean validateLastName(String lname) {
        if (StringUtils.isNotBlank(lname)) {
            return true;
        }
        return false;
    }

    public static boolean validateMobile(String Mobile) {
        if (StringUtils.isNotBlank(Mobile)) {
            return true;
        }
        return false;
    }

    public static boolean validateGender(String gender) {
        if (StringUtils.isNotBlank(gender)) {
            return true;
        }
        return false;
    }

    public static boolean validateMobilevalid(String Mobile) {

        Matcher mtch = expression.matcher(Mobile);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    public static boolean validateAge(int age) {
        System.out.println("validator age" + age);
        if (age == 0) {
            return true;
        }
        return false;
    }

    public static boolean validateAusername(String Ausername) {
        if (StringUtils.isNotBlank(Ausername)) {
            return true;
        }
        return false;
    }

    public static boolean validateApassword(String Apassword) {
        if (StringUtils.isNotBlank(Apassword)) {
            return true;
        }
        return false;
    }
}
