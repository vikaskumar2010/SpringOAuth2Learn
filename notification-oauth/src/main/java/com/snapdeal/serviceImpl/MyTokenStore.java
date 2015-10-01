package com.snapdeal.serviceImpl;

import java.util.Collection;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Service;

@Service("MyTokenStore")
public class MyTokenStore implements TokenStore {

	private InMemoryTokenStore inMemoryTokenStore;
	
	public MyTokenStore(){
		inMemoryTokenStore = new InMemoryTokenStore();
	}
	
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		System.out.println("readAuthentication with OAuth2AccessToken obj called");
		return inMemoryTokenStore.readAuthentication(token);
	}

	public OAuth2Authentication readAuthentication(String token) {
		System.out.println("readAuthentication with String token called");
		return inMemoryTokenStore.readAuthentication(token);
	}

	public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
		System.out.println("storeAccessToken called ...");
		inMemoryTokenStore.storeAccessToken(token, authentication);
	}

	public OAuth2AccessToken readAccessToken(String tokenValue) {
		System.out.println("readAccessToken called");
		return inMemoryTokenStore.readAccessToken(tokenValue);
	}

	public void removeAccessToken(OAuth2AccessToken token) {
		System.out.println("removeAccessToken called");
		inMemoryTokenStore.removeAccessToken(token);
		
	}

	public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
		System.out.println("storeRefreshToken called");
		inMemoryTokenStore.storeRefreshToken(refreshToken, authentication);
	}

	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		System.out.println("readRefreshToken called");
		return inMemoryTokenStore.readRefreshToken(tokenValue);
	}

	public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
		System.out.println("readAuthenticationForRefreshToken called");
		return inMemoryTokenStore.readAuthenticationForRefreshToken(token);
	}

	public void removeRefreshToken(OAuth2RefreshToken token) {
		System.out.println("removeRefreshToken called");
		inMemoryTokenStore.removeRefreshToken(token);
	}

	public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
		System.out.println("removeAccessTokenUsingRefreshToken called");
		inMemoryTokenStore.removeAccessTokenUsingRefreshToken(refreshToken);
	}

	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		System.out.println("getAccessToken called : "+inMemoryTokenStore.getAccessToken(authentication));
		
		return inMemoryTokenStore.getAccessToken(authentication);
	}

	public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
		System.out.println("findTokensByClientIdAndUserName called");
		return inMemoryTokenStore.findTokensByClientIdAndUserName(clientId, userName);
	}

	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		System.out.println("findTokensByClientId called");
		return inMemoryTokenStore.findTokensByClientId(clientId);
	}

}
