package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.dto.User;

@Service
public class UserServiceImpl_1 implements UserService {
	@Autowired
	UserDao userRepo;

	@Override
	public User login(String usernameInput, String passwordInput) {
		// TODO Auto-generated method stub
		System.out.println("1. Hello");
		User result = userRepo.findByUsernameAndPassword(usernameInput, passwordInput);
		System.out.println(result);
		return result;
	}

}
