package com.acme.poc.springpocapplication.controller;

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
				return "error/403";
			case 500:
				return "error/500";
			case 404:
			default:
				return "error/404";
		}
	}
}
