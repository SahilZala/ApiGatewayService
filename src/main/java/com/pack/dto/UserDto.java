package com.pack.dto;

import com.pack.entity.UserEntity;

public interface UserDto {
	
	public UserEntity getUserByEmailId(String emailId);

}
