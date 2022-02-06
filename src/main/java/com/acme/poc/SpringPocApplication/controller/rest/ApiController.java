package com.acme.poc.SpringPocApplication.controller.rest;

import com.acme.poc.SpringPocApplication.util.Url;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Url.API)
public class ApiController
{

	@GetMapping(value = Url.PING)
	public Mono<ServerResponse> ping(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}

	@GetMapping(value = Url.LOG)
	public Mono<ServerResponse> log(){
		//TODO implement
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build();
	}
}
