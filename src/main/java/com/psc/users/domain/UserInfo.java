package com.psc.users.domain;
public class UserInfo {	
	private int id;
	private String firstname;
    private String lastname;
    private int age;
    private String gender;	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + "]";
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
	}
