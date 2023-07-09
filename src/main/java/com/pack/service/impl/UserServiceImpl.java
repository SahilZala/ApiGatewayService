package com.pack.service.impl;

import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pack.entity.Response;
import com.pack.entity.UserEntity;
import com.pack.exceptions.UnAuthorizedException;
import com.pack.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	RestTemplate restTemplate;
	
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public UserEntity getUserByEmailId(String emailId) {
		try {
			String uri = "http://localhost:8082/user_service/user/get/?emailId="+emailId;

			ResponseEntity<Response> res = restTemplate
				.getForEntity(uri,Response.class);
			return getObjectToUser(res.getBody().getBody());
		}
		catch(RuntimeException ex)
		{
			log.info(ex.getMessage().substring(ex.getMessage().indexOf(": ")+3,ex.getMessage().indexOf("}")+1));
			GsonJsonParser gson = new GsonJsonParser();
			
			log.info(""+gson.parseMap(ex.getMessage().substring(ex.getMessage().indexOf(": ")+3,ex.getMessage().indexOf("}")+1)));
			
			throw new UnAuthorizedException(""+gson.parseMap(ex.getMessage().substring(ex.getMessage().indexOf(": ")+3,ex.getMessage().indexOf("}")+1)).get("message"));
		}
	}
	
	
	private UserEntity getObjectToUser(Object object) {
		@SuppressWarnings("unchecked")
		LinkedHashMap<String,Object> data = (LinkedHashMap<String, Object>)object;
		return new UserEntity(
				data.get("id").toString(),
				data.get("userName").toString(),
				data.get("emailId").toString(),
				data.get("password").toString(),
				data.get("mobileNumber").toString(),
				data.get("role").toString(),
				Boolean.parseBoolean("activation"));
		
	}
}
