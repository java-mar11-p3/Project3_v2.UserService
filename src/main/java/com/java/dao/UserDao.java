package com.java.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	List<User> findByUsernameAndPassword(String username, String password);
}
