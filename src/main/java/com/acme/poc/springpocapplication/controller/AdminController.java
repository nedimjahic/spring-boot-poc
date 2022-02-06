package com.acme.poc.springpocapplication.controller;

import com.acme.poc.springpocapplication.util.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("uiAdminController")
@RequestMapping(Url.UI + Url.ADMIN)
public class AdminController {

	@GetMapping(Url.DASHBOARD)
	public String getDashboard() {
		return Url.ADMIN + Url.DASHBOARD;
	}

	@GetMapping(Url.USERS)
	public String getUsers() {
		return Url.ADMIN + Url.USERS;
	}

	@GetMapping(Url.APIKEYS)
	public String getApikeys() {
		return Url.ADMIN + Url.APIKEYS;
	}

	@GetMapping(Url.ABOUT)
	public String getAbout() {
		return Url.ADMIN + Url.ABOUT;
	}
}
