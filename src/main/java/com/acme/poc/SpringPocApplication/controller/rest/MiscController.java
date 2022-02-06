package com.acme.poc.SpringPocApplication.controller.rest;

import com.acme.poc.SpringPocApplication.util.Url;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Url.MISC)
public class MiscController
{

	@GetMapping
	@PostMapping
	@PutMapping
	@DeleteMapping
	public Mono<Void> misc(){
		//TODO implement
		return Mono.empty();
	}
}
