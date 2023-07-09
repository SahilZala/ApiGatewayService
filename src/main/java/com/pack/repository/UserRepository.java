package com.pack.repository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pack.entity.UserEntity;

import reactivefeign.spring.config.ReactiveFeignClient;


@Service
@ReactiveFeignClient(name="USER-SERVICE")
public interface UserRepository {
	
	
	@GetMapping("/user_service/user/get/{emailId}")
	public UserEntity findByEmailId(@PathVariable("emailId") String emailId);
	
}
