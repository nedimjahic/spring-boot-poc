package com.acme.poc.SpringPocApplication.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@GetMapping(value = "/dashboard")
	public Mono<ServerResponse> dashboard(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = "/users")
	public Mono<ServerResponse> users(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = "/apikeys")
	public Mono<ServerResponse> apikeys(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}
}
