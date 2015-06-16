package com.psc.authentication.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class Account {
	@JsonProperty(value = "username")
	private String username;
	@JsonProperty(value = "password")
	private String password;
	@JsonProperty(value = "config")
	private String config;

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

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	@Override
	public String toString() {
		return "Authentication [ username=" + username + ", password="
				+ password + ", config=" + config + "]";
	}
}
