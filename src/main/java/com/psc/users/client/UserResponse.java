package com.psc.users.client;

public class UserResponse {
    private String code;
    private String message;

    public UserResponse() {
    }

    public UserResponse(int code, String message) {
        //this.code = code;
        this.message = message;
    }
    public UserResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
