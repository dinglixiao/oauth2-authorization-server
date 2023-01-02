package com.bsp.oauth2.authorization.server.oauth2.customizer.token.claims;

import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsContext;

public interface OAuth2TokenClaimsCustomizer {

	void customizeTokenClaims(OAuth2TokenClaimsContext context);
	
}