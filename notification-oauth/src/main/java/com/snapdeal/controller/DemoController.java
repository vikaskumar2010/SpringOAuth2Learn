package com.snapdeal.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	@Autowired 
	private TokenStore tokenStore;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ResponseEntity<String> home(){
		
		return new ResponseEntity<String>("Hello world!",HttpStatus.OK);
	}
	
	@RequestMapping(value="/mylogout",method=RequestMethod.GET)
	public ResponseEntity<String> myLogout(){
		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("client1");
		System.out.println("List of token for client1:"+tokens);
		for(OAuth2AccessToken token : tokens){
			System.out.println("Removing token:"+token);
			tokenStore.removeAccessToken(token);
	}
		return new ResponseEntity<String>("Hello world!",HttpStatus.OK);
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Test!",HttpStatus.OK);
	}
	
	
}
