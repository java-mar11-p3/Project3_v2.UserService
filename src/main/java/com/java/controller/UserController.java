package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
}
