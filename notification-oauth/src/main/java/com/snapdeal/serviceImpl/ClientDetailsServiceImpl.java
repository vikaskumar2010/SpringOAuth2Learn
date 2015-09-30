package com.snapdeal.serviceImpl;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class ClientDetailsServiceImpl implements ClientDetailsService{
	
	
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		final String RESOURCE_ID = "notification_resource";
		ApiClient client = null;
		System.out.println("Inside ClientServiceDetailsImpl");
		
		if("client1".equals(clientId)){
			System.out.println("Client1 found");
			client = new ApiClient("client1","secret1");
			client.setAuthorities("ROLE_CLIENT");
			client.setAuthorizationGrantType("client_credentials");
			client.setScopes("read");
			client.setResourceIds(RESOURCE_ID);
			client.setAccessTokenValidity(500);
			return client;
		}else if("client2".equals(clientId)){
			System.out.println("Client2 found");
			client = new ApiClient("client2","secret2");
			client.setAuthorities("ROLE_CLIENT");
			client.setAuthorizationGrantType("client_credentials");
			client.setScopes("write");
			client.setResourceIds(RESOURCE_ID);
			client.setAccessTokenValidity(500);
			return client;
		}
		System.out.println("Client not found");
		throw new ClientRegistrationException("Client "+clientId+" is not registered." );
	

	}

}
