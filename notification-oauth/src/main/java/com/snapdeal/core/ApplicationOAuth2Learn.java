package com.snapdeal.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(
		{@PropertySource(value={"classpath:application.properties"},ignoreResourceNotFound=true)}
	)

@EnableAutoConfiguration
@ComponentScan({"com.snapdeal"})
public class ApplicationOAuth2Learn {
	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(ApplicationOAuth2Learn.class, args);	
		
//		System.out.println("Count:"+c.getBeanDefinitionCount());
//		
//		for(String s : c.getBeanDefinitionNames())
//			System.out.println("\n"+s);
	}
}
