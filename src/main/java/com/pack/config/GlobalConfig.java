package com.pack.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalConfig {
	@Bean
	public RestTemplate getResTemplate()
	{
		RestTemplate tem = new RestTemplate();
		//tem.setErrorHandler(new ResponseErrorHandler());
		return tem;
	}
	
	
}
