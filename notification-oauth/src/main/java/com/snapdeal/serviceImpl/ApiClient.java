package com.snapdeal.serviceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ApiClient implements ClientDetails{
	
	private String clientId;
	private Set<String> resourceIds;
	private boolean secretRequired;
	private String clientSecret;
	private boolean scoped;
	private Set<String> scopes;
	private Set<String> authorizedGrantTypes;
	private Integer accessTokenValiditySeconds;
	private Integer refreshTokenValiditySeconds;
	Collection<GrantedAuthority> authorities;
	
	public ApiClient(String clientId,String clientSecret){
		resourceIds = new HashSet<String>();
		scopes = new HashSet<String>();
		authorizedGrantTypes = new HashSet<String>();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	public void setAuthorizationGrantType(String ... grantTypes){
		for(String grantType : grantTypes){
			authorizedGrantTypes.add(grantType);
		}
	}
	public void setScopes(String ... scopes){
		for(String scope : scopes){
			this.scopes.add(scope);
		}
	}
	public void setResourceIds(String... ids){
		for(String id : ids){
			resourceIds.add(id);
		}
	}
	public void setAuthorities(String ... authorities){
		this.authorities = AuthorityUtils.createAuthorityList(authorities);
	}
	
	public void setAccessTokenValidity(int seconds){
		accessTokenValiditySeconds = seconds;
	}
	
	
	public String getClientId() {
		return this.clientId;
	}

	public Set<String> getResourceIds() {
		
		return resourceIds;
	}

	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return secretRequired;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public boolean isScoped() {
		// TODO Auto-generated method stub
		return scoped;
	}

	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return scopes;
	}

	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return authorizedGrantTypes;
	}

	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return refreshTokenValiditySeconds;
	}

	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
