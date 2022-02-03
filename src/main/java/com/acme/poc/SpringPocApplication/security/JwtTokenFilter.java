package com.acme.poc.SpringPocApplication.security;

import com.acme.poc.SpringPocApplication.model.User;
import com.acme.poc.SpringPocApplication.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter
{

	private final JwtUtil jwtUtil;

	public JwtTokenFilter(JwtUtil jwtUtil)
	{
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
													throws ServletException, IOException {
		// Get authorization header and validate
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header == null || !header.startsWith("Bearer "))
		{
			chain.doFilter(request, response);
			return;
		}

		// Get jwt token and validate
		final String token = header.split(" ")[1].trim();
		// TODO Implement actual validation
		if(!jwtUtil.validateToken(token, new User("testUsername", "testPassword")))
		{
			chain.doFilter(request, response);
		}
	}

}
