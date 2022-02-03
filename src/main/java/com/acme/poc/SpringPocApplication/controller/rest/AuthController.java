package com.acme.poc.SpringPocApplication.controller.rest;

import com.acme.poc.SpringPocApplication.model.User;
import com.acme.poc.SpringPocApplication.util.JwtUtil;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController
{
	JwtUtil jwtUtil;

	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@PostMapping(value = "/login")
	public Mono<String> login(@RequestBody User user) {
		return Mono.just(jwtUtil.generateToken(user));
	}

	@GetMapping("/forgot")
	public Mono<Void> forgot() {
		//TODO implement
		return Mono.empty();
	}
}
