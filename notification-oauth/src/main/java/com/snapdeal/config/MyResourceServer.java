package com.snapdeal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableResourceServer
public class MyResourceServer extends ResourceServerConfigurerAdapter{
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.requestMatchers()
				.and()
				.authorizeRequests()
				.antMatchers("/home")
					.access("#oauth2.hasScope('write')")
				.antMatchers("/test")
					.access("#oauth2.hasScope('read')")
				.anyRequest()
					.access("#oauth2.hasScope('read')")
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER);
//			.and()
//				.logout().logoutUrl("logout")
//				.invalidateHttpSession(true)
//				.logoutSuccessHandler(logoutSuccessHandler);
		
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("blog_resource");
	
	}
}
