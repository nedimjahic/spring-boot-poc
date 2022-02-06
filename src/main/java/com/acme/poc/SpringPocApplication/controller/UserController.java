package com.acme.poc.SpringPocApplication.controller;

import com.acme.poc.SpringPocApplication.util.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Url.UI + Url.USER)
public class UserController {

	@GetMapping(Url.ACCOUNT)
	public String getAccount() {
		return Url.USER + Url.ACCOUNT;
	}

	@GetMapping(Url.PROFILE)
	public String getProfile() {
		return Url.USER + Url.PROFILE;
	}
}
