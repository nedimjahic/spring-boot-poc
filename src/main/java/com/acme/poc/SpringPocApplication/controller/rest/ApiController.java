package com.acme.poc.SpringPocApplication.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ApiController
{
	@GetMapping(value = "/ping")
	public Mono<ServerResponse> ping(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = "/log")
	public Mono<ServerResponse> log(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}
}
