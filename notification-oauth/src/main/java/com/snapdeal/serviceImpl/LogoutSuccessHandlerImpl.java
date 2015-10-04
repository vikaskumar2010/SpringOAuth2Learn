package com.snapdeal.serviceImpl;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler{
	@Autowired 
	private TokenStore tokenStore;
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		System.out.println("Logout success handler called!");
		
//		System.out.println("Client:"+authentication.getName() 
//			+" "+authentication.getPrincipal()
//			+" "+authentication.getDetails());
//		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("client1");
//		System.out.println("List of token for client1:"+tokens);
//		for(OAuth2AccessToken token : tokens){
//			System.out.println("Removing token:"+token);
//			tokenStore.removeAccessToken(token);
//		}
	}

}
