package com.pack.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtil {
	
	public static List<String> PUBLIC_URLS = Arrays.asList("/login","/user_service/user/create");
	public static List<String> USER_URLS = Arrays.asList("/user_service/user/address/create");
	public static List<String> ADMIN_URLS = Arrays.asList(
			"/user_service/admin/user/get/all",
			"/product_service/admin/create/product",
			"/product_service/admin/create/main_category",
			"/product_service/admin/create/sub_category",
			"/product_service/admin/get_all/product",
			"/product_service/admin/get_all/main_category",
			"/product_service/admin/get_all/sub_category");
	
	public static String USER_ROLE = "ROLE_USER";
	public static String ADMIN_ROLE = "ROLE_ADMIN";
}	
