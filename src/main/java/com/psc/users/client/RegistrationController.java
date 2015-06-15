package com.psc.users.client;

import com.psc.authentication.service.AccountsService;
import com.psc.common.MessageBundle;
import com.psc.exceptions.CustomException;
import com.psc.exceptions.UserValidationException;
import com.psc.users.domain.User;
import com.psc.users.domain.UserInfo;
import com.psc.users.service.UserService;
import com.psc.users.util.UserUtil;
import com.psc.validator.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class RegistrationController {
    @Autowired
    UserService userservice;

    @Autowired
    AccountsService accountService;

    static final Logger logger = Logger.getLogger(RegistrationController.class);
    private static final MessageBundle messageBundle = MessageBundle.getInstance();

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    UserResponse addUser(@RequestBody UserRequest userRequest) throws CustomException {
        try {
            //Authentication validation
            Validator.authenticateRequest(userRequest);
            //User Request Validation
            Validator.validateUserRequest(userRequest);
            //Build objects for Adding User
            logger.debug("user request" + userRequest.toString());
            User user = UserUtil.buildUserFromUserRequest(userRequest);
            UserInfo userInfo = UserUtil.buildUserInfoFromUserRequest(userRequest);
            //Register the User
            userservice.registerUser(user, userInfo);
            return new UserResponse(5, "user added");
        } catch (UserValidationException e) {
            String errorMsg = "exceptions.UserValidationException." + e.getMessage();
            UserResponse userResponse = new UserResponse(messageBundle.getMessage(errorMsg + ".responseCode"), messageBundle.getMessage(errorMsg + ".responseDescription"));
            return userResponse;
        } catch (Exception e2) {
            return new UserResponse(6, e2.getMessage());
        }
    }
}
