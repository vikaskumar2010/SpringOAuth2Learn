package com.snapdeal.serviceImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

@Service("MyClientDetailServiceImplMySql")
public class ClientDetailsServiceImpl 
	implements ClientDetailsService, ClientRegistrationService{
	
	private DataSource dataSource;
	
	private JdbcClientDetailsService jdbcClientService;
	
	final String RESOURCE_ID = "blog_resource";
	
	@Autowired
	public ClientDetailsServiceImpl(DataSource s){
		this.dataSource = s;
		jdbcClientService = new JdbcClientDetailsService(dataSource);
		
//		ApiClient client = new ApiClient("client1","secret1");
//		client.setAuthorities("ROLE_CLIENT");
//		client.setAuthorizationGrantType("client_credentials");
//		client.setScopes("read");
//		client.setResourceIds(RESOURCE_ID);
//		client.setAccessTokenValidity(500);
		
		ApiClient client = new ApiClient().createApiClient()
				.setClientId("client1")
				.setClientSecret("secret1")
				.setAuthorities("ROLE_CLIENT")
				.setAuthorizationGrantType("client_credentials")
				.setScopes("read")
				.setResourceIds(RESOURCE_ID)
				.setAccessTokenValidity(500) //defaultvalue 43200secs (12Hr)
				.build();
		
		//System.out.println(client+"\n\n"+client2);
		
		
//		jdbcClientService.addClientDetails(client);
		
	}
	
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		System.out.println("loading client");
		
		ClientDetails client = jdbcClientService.loadClientByClientId(clientId);
		System.out.println(client.getClientId()+" "+client.getClientSecret());
		return client;
	}

	public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
		System.out.println("addClientDetails is called...");
		jdbcClientService.addClientDetails(clientDetails);
	}
	
	public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
		System.out.println("updateClientDetails called");
		jdbcClientService.updateClientDetails(clientDetails);
	}

	public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
		System.out.println("updateClientSecret called");
		jdbcClientService.updateClientSecret(clientId, secret);		
	}

	public void removeClientDetails(String clientId) throws NoSuchClientException {
		System.out.println("removeClientDetails called");
		jdbcClientService.removeClientDetails(clientId);
	}

	public List<ClientDetails> listClientDetails() {
		System.out.println("listClientDetails called");
		return jdbcClientService.listClientDetails();
	}
	
	
	
	
	
	
	/*
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
	*/
	
	

}
