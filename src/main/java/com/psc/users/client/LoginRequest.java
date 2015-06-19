package com.psc.users.client;

import org.codehaus.jackson.annotate.JsonProperty;

public class LoginRequest {
 @JsonProperty(value = "username")
 private String username;
  @JsonProperty(value = "password")
  private String password;
  @JsonProperty(value = "mobile")
  private int mobile;
  @JsonProperty(value = "email")
  private String email;
  @JsonProperty(value = "ausername")
  private String ausername;
  @JsonProperty(value = "apassword")
  private String apassword;
 public String getUsername() {
  return username;
 }
 public void setUsername(String username) {
  this.username = username;
 }
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }
 public int getMobile() {
  return mobile;
 }
 public void setMobile(int mobile) {
  this.mobile = mobile;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getAusername() {
  return ausername;
 }
 public void setAusername(String ausername) {
  this.ausername = ausername;
 }
 public String getApassword() {
  return apassword;
 }
 public void setApassword(String apassword) {
  this.apassword = apassword;
 }
 @Override
 public String toString() {
  return "LoginRequest [username=" + username + ", password=" + password
    + ", mobile=" + mobile + ", email=" + email + ", ausername="
    + ausername + ", apassword=" + apassword + "]";
 }
  
}
