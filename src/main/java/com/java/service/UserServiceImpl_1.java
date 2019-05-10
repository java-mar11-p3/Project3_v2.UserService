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
	public User login(String emailInput, String passwordInput) {
		User result = userRepo.findByEmailAndPassword(emailInput, passwordInput);
		return result;
	}

	@Override
	public boolean checkUserEmail(String emailInput) {
		if(userRepo.findByEmail(emailInput) != null)
			return true;
		return false;
	}
	

}
