package com.pack.entity;

import java.util.List;


public class UserEntity {

	private String id;
	private String userName;
	private String emailId;
	private String password;
	private String mobileNumber;
	private String role;
	private boolean activation;
	
	private List<AddressEntity> address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<AddressEntity> getAddress() {
		return address;
	}
	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}
	
	
	public UserEntity(String id, String userName, String emailId, String password, String mobileNumber, String role,
			boolean activation, List<AddressEntity> address) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.activation = activation;
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", role=" + role + ", activation=" + activation + ", address="
				+ address + "]";
	}
	
	public UserEntity(String id, String userName, String emailId, String password, String mobileNumber, String role,
			boolean activation) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.activation = activation;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
