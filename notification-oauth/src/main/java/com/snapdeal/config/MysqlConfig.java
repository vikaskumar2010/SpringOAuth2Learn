package com.snapdeal.config;

import javax.annotation.Resource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MysqlConfig {

	@Resource
	private Environment env;


	@Bean
	public DataSource getDataSource(){
		DataSource dataSource= new DataSource();
		
		System.out.println(env.getRequiredProperty("mysql.driver"));
		
		dataSource.setDriverClassName(env.getRequiredProperty("mysql.driver"));
		dataSource.setUrl(env.getRequiredProperty("mysql.jdbcurl"));
		dataSource.setUsername(env.getRequiredProperty("mysql.user"));
		dataSource.setPassword(env.getRequiredProperty("mysql.password"));
		return dataSource;
	}
}