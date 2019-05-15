package com.java.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.dto.User;

//Spring will inject the class and method for us here.
//This interface is used for accessing data from the database.
//contains spring defined method, and programmer-defined method.
@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}
