package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.User;
import com.java.service.UserService;

import lombok.Data;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public User login(@RequestBody LoginInfo loginInfo) {
		
		return userService.login(loginInfo.getUsername(), loginInfo.getPassword());
	}
	@GetMapping("/logout")
	public void logout() {
		System.out.println("Being implemented...");
	}
}
@Data
class LoginInfo{
	String username;
	String password;
}