package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.config.AuthenticationConfiguration;
import com.pack.entity.JWTRequest;
import com.pack.entity.JWTResponse;
import com.pack.entity.Response;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	
	@PostMapping("/login")
	public ResponseEntity<Response> authenticate(@RequestBody JWTRequest req)
	{
		String token = authConfig.authentication(req);
		return token == null ? new ResponseEntity<>(new Response(HttpStatus.UNAUTHORIZED.value(),"unauthorized",new JWTResponse("")),HttpStatus.UNAUTHORIZED) :  new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"",new JWTResponse(token)),HttpStatus.OK);
	}
	
}
