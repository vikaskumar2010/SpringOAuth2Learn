package com.snapdeal.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ApiClient implements ClientDetails{
	
	private String clientId;
	private String clientSecret;
	private Set<String> resourceIds;
	private boolean secretRequired;
	private boolean scoped;
	private Set<String> scopes;
	private Set<String> authorizedGrantTypes;
	private Integer accessTokenValiditySeconds;
	private Integer refreshTokenValiditySeconds;
	Collection<GrantedAuthority> authorities;
	Map<String,Object> additionInfo;
	
	public ApiClient(){	}
	
	public ApiClient(String clientId, String clientSecret, Set<String> resourceIds, boolean secretRequired,
			boolean scoped, Set<String> scopes, Set<String> authorizedGrantTypes, Integer accessTokenValiditySeconds,
			Integer refreshTokenValiditySeconds, Collection<GrantedAuthority> authorities,
			Map<String, Object> additionInfo) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.resourceIds = resourceIds;
		this.secretRequired = secretRequired;
		this.scoped = scoped;
		this.scopes = scopes;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
		this.authorities = authorities;
		this.additionInfo = additionInfo;
	}

	public ApiClient(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorities = new ArrayList<GrantedAuthority>();
		this.authorizedGrantTypes = new LinkedHashSet<String>();
		this.scopes = new HashSet<String>();
		this.resourceIds = new HashSet<String>();
		this.additionInfo = new HashMap<String,Object>();
	}
/*
	public void setAuthorizationGrantType(String ... grantTypes){
		if(this.authorizedGrantTypes == null)
			this.authorizedGrantTypes = new HashSet<String>();
		
		for(String grantType : grantTypes){
			authorizedGrantTypes.add(grantType);
		}
		
	}
	public void setScopes(String ... scopes){
		if(this.scopes == null)
			this.scopes = new HashSet<String>();
		for(String scope : scopes){
			this.scopes.add(scope);
		}
		
	}
	public void setResourceIds(String... ids){
		if(this.resourceIds == null)
			this.resourceIds = new HashSet<String>();
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
*/	
	

	@Override
	public String toString() {
		return "ApiClient [clientId=" + clientId + ", clientSecret=" + clientSecret + ", resourceIds=" + resourceIds
				+ ", secretRequired=" + secretRequired + ", scoped=" + scoped + ", scopes=" + scopes
				+ ", authorizedGrantTypes=" + authorizedGrantTypes + ", accessTokenValiditySeconds="
				+ accessTokenValiditySeconds + ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds
				+ ", authorities=" + authorities + ", additionInfo=" + additionInfo + "]";
	}

	public static ApiClientBuilder createApiClient(){
		return new ApiClientBuilder();
	}

	public String getClientId() {
		return this.clientId;
	}

	public Set<String> getResourceIds() {
		
		return resourceIds;
	}

	public boolean isSecretRequired() {
		return secretRequired;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public boolean isScoped() {
		return scoped;
	}

	public Set<String> getScope() {
		return scopes;
	}

	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public boolean isAutoApprove(String scope) {
		return true;
	}

	public Map<String, Object> getAdditionalInformation() {
		System.out.println("NULL returning");
		return additionInfo;
	}

	public static class ApiClientBuilder{
		private String clientId;
		private String clientSecret;
		private Set<String> resourceIds;
		private boolean secretRequired;
		private boolean scoped;
		private Set<String> scopes;
		
		private Set<String> authorizedGrantTypes;
		private Integer accessTokenValiditySeconds;
		private Integer refreshTokenValiditySeconds;
		Collection<GrantedAuthority> authorities;
		Map<String,Object> additionInfo;
		
		
		public ApiClientBuilder setAuthorizationGrantType(String ... grantTypes){
			if(this.authorizedGrantTypes == null)
				this.authorizedGrantTypes = new HashSet<String>();
			
			for(String grantType : grantTypes){
				authorizedGrantTypes.add(grantType);
			}
			return this;
		}
		public ApiClientBuilder setScopes(String ... scopes){
			if(this.scopes == null)
				this.scopes = new HashSet<String>();
			for(String scope : scopes){
				this.scopes.add(scope);
			}
			return this;
		}
		public ApiClientBuilder setResourceIds(String... ids){
			if(this.resourceIds == null)
				this.resourceIds = new HashSet<String>();
			for(String id : ids){
				resourceIds.add(id);
			}
			return this;
		}
		public ApiClientBuilder setAuthorities(String ... authorities){
			this.authorities = AuthorityUtils.createAuthorityList(authorities);
			return this;
		}
		public ApiClientBuilder setClientId(String clientId){
			this.clientId = clientId;
			return this;
		}
		public ApiClientBuilder setClientSecret(String clientSecret){
			this.clientSecret = clientSecret;
			return this;
		}
		public ApiClientBuilder setAccessTokenValidity(int seconds){
			accessTokenValiditySeconds = seconds;
			return this;
		}
		public ApiClient build(){
			additionInfo = new HashMap<String,Object>();
			return new ApiClient(clientId, clientSecret, resourceIds, secretRequired,
					scoped, scopes, authorizedGrantTypes,
					accessTokenValiditySeconds, refreshTokenValiditySeconds,
					authorities, additionInfo);
		}
	}
	
}
