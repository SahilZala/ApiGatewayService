package com.pack.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;
import com.pack.service.UserService;

@Service
public class UserDtoImpl implements UserDto{

	@Autowired
	UserService userService;
	
	@Override
	public UserEntity getUserByEmailId(String emailId) {
		return userService.getUserByEmailId(emailId);
	}
	
}	
