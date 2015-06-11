package com.psc.users.client;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonProperty;
public class UserRequest {
	 @JsonProperty(value = "username") 
	 @NotNull(message="username cannot be empty.")
	private String username;
	 @JsonProperty(value = "password")
	private String password;
	 @JsonProperty(value = "email")
	private String email;
	 @JsonProperty(value = "mobile")
	private String mobile;
	 @JsonProperty(value = "firstname")
	private String firstname;
	 @JsonProperty(value = "lastname")
    private String lastname;
	 @JsonProperty(value = "age")
    private int age;
	 @JsonProperty(value = "gender")
    private String gender;
	 @JsonProperty(value = "ausername")
	 private String ausername;
	 @JsonProperty(value = "apassword")
	 private String apassword;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", firstname="
				+ firstname + ", lastname=" + lastname + ", age=" + age
				+ ", gender=" + gender + ",ausername=" + ausername + ", apassword=" + apassword + "]";
	}
	}
