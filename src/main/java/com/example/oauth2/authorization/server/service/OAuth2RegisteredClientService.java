package com.example.oauth2.authorization.server.service;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.util.List;

public interface OAuth2RegisteredClientService {

	List<RegisteredClient> getOAuth2RegisteredClient();
	
}
