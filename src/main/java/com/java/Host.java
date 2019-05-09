package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.java.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackages="com.java")
public class Host {
	public static void main(String[] args) {
		SpringApplication.run(Host.class, args);
	}
}