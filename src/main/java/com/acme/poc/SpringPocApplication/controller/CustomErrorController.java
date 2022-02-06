package com.acme.poc.SpringPocApplication.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {
	@GetMapping
	public String error(final HttpServletResponse response)	{
		final int statusCode = response.getStatus();

		switch(statusCode) {
			case 403:
				return "403";
			case 500:
				return "500";
			case 404:
			default:
				return "404";
		}
	}
}
