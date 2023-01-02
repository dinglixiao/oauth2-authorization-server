package com.example.oauth2.authorization.server.service;

import com.example.oauth2.authorization.server.jpa.entity.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserPrincipalService extends UserDetailsService {

	@Override
    UserPrincipal loadUserByUsername(String username);
	
}
