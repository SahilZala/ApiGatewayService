package com.pack.util;

import org.springframework.stereotype.Component;

@Component
public final class RestURLUtil {
	
	public static final String GET_USER_BY_EMAILID= "lb://USER-SERVICE/user_service/user/get/?emailId=";
	
	RestURLUtil() {
		
	}
}
