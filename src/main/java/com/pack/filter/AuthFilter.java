package com.pack.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.google.common.net.HttpHeaders;
import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;
import com.pack.exceptions.HeaderNotFoundException;
import com.pack.exceptions.UnAuthorizedException;
import com.pack.util.AuthenticationUtil;
import com.pack.util.JWTUtil;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDto userDto;
	
	private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);
	
	public static class  Config{
		
	}

	public AuthFilter() {
		super(Config.class);
	}

	public AuthFilter(Class<Config> configClass) {
		super(configClass);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain) -> {
			String path = exchange.getRequest().getPath().toString();
			log.info(path);
			if(AuthenticationUtil.PUBLIC_URLS.contains(path))
			{
				return chain.filter(exchange);
			}
			
			if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
			{	
				throw new HeaderNotFoundException("authorization header is missing.");
			}
			
			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			
			authHeader = authHeader.substring(7);	
			String userName = jwtUtil.extractUsername(authHeader);
			log.info(userName);
			
			UserEntity userEntity = userDto.getUserByEmailId(userName);
			
			if(userEntity == null)
				throw new RuntimeException("user not found exception");
			else {
				if(userEntity.getRole().equals(AuthenticationUtil.USER_ROLE))
				{
					if(AuthenticationUtil.USER_URLS.contains(path))
					{
						return chain.filter(exchange);
					}
					else{

						throw new UnAuthorizedException("Not authorized");
					}
				}
				else {
					if(AuthenticationUtil.ADMIN_URLS.contains(path))
					{
						return chain.filter(exchange);
					}
					else{

						throw new UnAuthorizedException("Not authorized");
					}					
				}
			}
		});
	}
	
	
}
