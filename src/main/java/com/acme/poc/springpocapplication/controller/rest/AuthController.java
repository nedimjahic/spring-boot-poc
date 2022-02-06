package com.acme.poc.springpocapplication.controller.rest;

import com.acme.poc.springpocapplication.model.User;
import com.acme.poc.springpocapplication.util.JwtUtil;
import com.acme.poc.springpocapplication.util.Url;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Url.AUTH)
public class AuthController
{

	JwtUtil jwtUtil;

	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@PostMapping(value = Url.LOGIN)
	public Mono<String> login(@RequestBody User user) {
		return Mono.just(jwtUtil.generateToken(user));
	}

	@GetMapping(Url.FORGOT)
	public Mono<Void> forgot() {
		//TODO implement
		return Mono.empty();
	}
}
