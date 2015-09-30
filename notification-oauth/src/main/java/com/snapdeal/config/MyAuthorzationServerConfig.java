package com.snapdeal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import com.snapdeal.serviceImpl.ClientDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer	
public class MyAuthorzationServerConfig extends AuthorizationServerConfigurerAdapter{
	
	final String RESOURCE_ID = "blog_resource";
	
	//@Autowired
    //private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	
    }
    
    @Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    	
	}

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    	clients.withClientDetails(new ClientDetailsServiceImpl());
    		
//    	clients.inMemory()
//		 .withClient("client-with-registered-redirect")
//		 .authorizedGrantTypes("authorization_code")
//		 .authorities("ROLE_CLIENT")
//		 .scopes("read", "trust")
//		 .resourceIds(RESOURCE_ID)
//		 .redirectUris("http://localhost:8080/home?key=value")
//		 .secret("secret123")
//		 .and()
//		 .withClient("client1")
//		 .authorizedGrantTypes("client_credentials", "password")
//		 .authorities("ROLE_CLIENT")
//		 .scopes("read")
//		 .accessTokenValiditySeconds(500)
//		 .resourceIds(RESOURCE_ID)
//		 .secret("secret1")
//		 .and()
//		 .withClient("client2")
//		 .authorizedGrantTypes("password")
//		 .authorities("ROLE_CLIENT")
//		 .scopes("read")
//		 .accessTokenValiditySeconds(100)
//		 .resourceIds(RESOURCE_ID)
//		 .secret("secret2")
//		 .and()
//		 .withClient("my_new_client")
//		 .authorizedGrantTypes("implicit_grant")
//		 .accessTokenValiditySeconds(300)
//		 .scopes("read")
//		 .resourceIds(RESOURCE_ID)
//		 .secret("mysecret");
		
    } 


}
