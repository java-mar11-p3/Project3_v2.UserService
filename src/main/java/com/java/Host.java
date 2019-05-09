package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.controller.UserController;
import com.java.dao.UserDao;

@SpringBootApplication
public class Host {
	public static void main(String[] args) {
		SpringApplication.run(Host.class, args);
		UserController controller = new UserController();
		controller.login("tester", "network");
	}
}
//spring.cloud.config.uri=
//
//eureka.client.register-with-eureka=true
//eureka.client.fetch-registry=true
//eureka.client.serviceUrl.defaultZone=