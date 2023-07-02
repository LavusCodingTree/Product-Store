package com.js.dto;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.js")
public class Myconfig {

	@Bean
	public EntityManagerFactory geEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("uday");

	}

}
