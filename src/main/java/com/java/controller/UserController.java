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
		//create message object to return in case of error.
		MessageObject emailError = new MessageObject("Email Not Found");
		MessageObject passwordError = new MessageObject("Incorrect Password");
		//check if there is a user with the input email in the database.
		//if not, return error message.
		if(!userService.checkUserEmail(loginInfo.getEmail()))
			return ResponseEntity.ok(emailError);
		//Use the input to find a user in the database.
		//if no user is found, it means the password is incorrect.
		User temp = userService.login(loginInfo.getEmail(), loginInfo.getPassword());
		
		if(temp == null)
			return ResponseEntity.ok(passwordError);
		//return the user object.
		return ResponseEntity.ok(temp);
	}
}
// This class is used for storing the json data received from the front-end.
@Data
class LoginInfo{
	String email;
	String password;
}
// This class is used for sending back a message in json format to the front-end.
@Data
@AllArgsConstructor
class MessageObject{
	String error;
}