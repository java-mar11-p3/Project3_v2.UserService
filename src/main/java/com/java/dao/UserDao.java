package com.java.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	User findByUsernameAndPassword(String username, String password);
}
