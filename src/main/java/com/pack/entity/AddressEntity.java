package com.pack.entity;


public class AddressEntity {

	private String id;
	private String address1;
	private String address2;
	private String city;
	private String pincode;
	private String landmark;
	private String state;
	private boolean activation;
	

	private UserEntity userEntity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isActivation() {
		return activation;
	}

	public void setActivation(boolean activation) {
		this.activation = activation;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public AddressEntity(String address1, String address2, String city, String pincode, String landmark,
			String state, boolean activation, UserEntity userEntity) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.pincode = pincode;
		this.landmark = landmark;
		this.state = state;
		this.activation = activation;
		this.userEntity = userEntity;
		
		
	}
	
	

	public AddressEntity() {
		super();
	}

//	@Override
//	public String toString() {
//		return "AddressEntity [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
//				+ ", pincode=" + pincode + ", landmark=" + landmark + ", state=" + state + ", activation=" + activation
//				+ ", userEntity=" + userEntity + "]";
//	}
	
	
	
	
	
}