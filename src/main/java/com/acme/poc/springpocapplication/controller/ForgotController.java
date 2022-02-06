package com.acme.poc.springpocapplication.controller;

import com.acme.poc.springpocapplication.util.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Url.UI + Url.FORGOT)
public class ForgotController {

	@GetMapping
	public String get() {
		return Url.FORGOT;
	}
}
