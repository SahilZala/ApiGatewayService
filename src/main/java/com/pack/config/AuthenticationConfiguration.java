package com.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pack.dto.UserDto;
import com.pack.entity.JWTRequest;
import com.pack.entity.UserEntity;
import com.pack.util.JWTUtil;

@Configuration
public class AuthenticationConfiguration {
	
	@Autowired
	private UserDto userDto;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	public String authentication(JWTRequest req)
	{
		UserEntity userEntity = userDto.getUserByEmailId(req.getUserName());
		boolean result = userEntity.getPassword().equals(req.getPassword());
		
		return result ? generateToken(req) : null;
	}
	
	public String generateToken(JWTRequest jwtReq)
	{
		return jwtUtil.generateToken(jwtReq);
	}
	

	
}
