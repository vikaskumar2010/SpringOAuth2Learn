package com.snapdeal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



//@Configuration
//@EnableWebSecurity
public class WebSpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
//				.loginPage("/login").failureUrl("/login?error").permitAll().and()
//				.logout().permitAll();
//		http.authorizeRequests().antMatchers("/oauth/authorize").permitAll();
//	}

	
	/*
	 * This is not used in GrantType=client_credentials.
	 * Only used when it requires resource owner authentication/authorization
	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("admin")
//				.roles("ADMIN", "USER").and().withUser("user").password("user")
//				.roles("USER");
//	}

}