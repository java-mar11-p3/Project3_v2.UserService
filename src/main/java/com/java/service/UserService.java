package com.java.service;

import com.java.dto.User;

public interface UserService {	
	User login(String usernameInput, String passwordInput);
}
