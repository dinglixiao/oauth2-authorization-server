package com.bsp.oauth2.authorization.server.service;

import com.bsp.oauth2.authorization.server.entity.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserPrincipalService extends UserDetailsService {

	@Override
    UserPrincipal loadUserByUsername(String username);
	
}
