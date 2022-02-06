package com.acme.poc.springpocapplication.util;

import com.acme.poc.springpocapplication.JwtProperties;
import com.acme.poc.springpocapplication.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil
{
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	public static final String PASSWORD = "password";

	private final JwtProperties jwtProperties;

	public JwtUtil(JwtProperties jwtProperties)
	{
		this.jwtProperties = jwtProperties;
	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	public String getPasswordFromToken(String token) {
		return getClaimFromToken(token, claims -> (String)claims.get(PASSWORD));
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(PASSWORD, user.getPassword());
		return doGenerateToken(claims, user.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
			.signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
	}

	public Boolean validateToken(String token, User user) {
		final String username = getUsernameFromToken(token);
		final String password = getPasswordFromToken(token);
		return (username.equals(user.getUsername()) && password.equals(user.getPassword()) && !isTokenExpired(token));
	}
}
