package com.pack.entity;

public class UserCredentials {
	private String userName;
	private String role;
	public UserCredentials(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
