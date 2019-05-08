package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;

@Service
public class UserServiceImpl_1 {
	@Autowired
	UserDao userRepo;
}
