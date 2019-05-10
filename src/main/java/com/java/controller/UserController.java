package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.User;
import com.java.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginInfo loginInfo) {
		MessageObject emailError = new MessageObject("Email Not Found");
		MessageObject passwordError = new MessageObject("Incorrect Password");
		
		if(!userService.checkUserEmail(loginInfo.getEmail()))
			return ResponseEntity.ok(emailError);
		
		User temp = userService.login(loginInfo.getEmail(), loginInfo.getPassword());
		
		if(temp == null)
			return ResponseEntity.ok(passwordError);
		return ResponseEntity.ok(temp);
	}
	@GetMapping("/logout")
	public void logout() {
		System.out.println("Being implemented...");
	}
}
@Data
class LoginInfo{
	String email;
	String password;
}
@Data
@AllArgsConstructor
class MessageObject{
	String error;
}