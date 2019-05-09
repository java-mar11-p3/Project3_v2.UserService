package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/login")
	public void login(@RequestParam String usernameInput,@RequestParam String passwordInput) {
		System.out.println(userService.login(usernameInput, passwordInput));
	}
}
