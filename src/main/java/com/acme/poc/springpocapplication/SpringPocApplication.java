package com.acme.poc.springpocapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.acme.poc.springpocapplication")
public class SpringPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPocApplication.class, args);
	}

}
