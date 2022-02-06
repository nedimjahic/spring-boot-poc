package com.acme.poc.SpringPocApplication.controller.rest;

import com.acme.poc.SpringPocApplication.util.Url;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController("restAdminController")
@RequestMapping(Url.ADMIN)
public class AdminController
{

	@GetMapping(value = Url.DASHBOARD)
	public Mono<ServerResponse> dashboard(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = Url.USERS)
	public Mono<ServerResponse> users(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = Url.APIKEYS)
	public Mono<ServerResponse> apikeys(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}
}
