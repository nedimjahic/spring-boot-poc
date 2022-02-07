package com.acme.poc.springpocapplication;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties("jwt")
public class JwtProperties {
	private String secret;
}
