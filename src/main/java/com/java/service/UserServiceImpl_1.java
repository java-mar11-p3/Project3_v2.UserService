package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.dto.User;

@Service
public class UserServiceImpl_1 implements UserService {
	@Autowired
	private UserDao userRepo;

	@Override
	public User login(String usernameInput, String passwordInput) {
		// TODO Auto-generated method stub
		User result = userRepo.findByUsernameAndPassword(usernameInput, passwordInput);
		return result;
	}

}
