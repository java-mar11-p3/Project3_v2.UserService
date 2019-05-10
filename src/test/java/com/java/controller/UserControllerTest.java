package com.java.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.User;
import com.java.service.UserService;

import lombok.Data;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@MockBean UserService service;
	@Autowired MockMvc mvc;
	
	@Test
	public void validLoginTest() throws Exception {
		User user = new User();
		user.setFirstName("For ");
		user.setLastName("testing");
		user.setEmail("testing@mail.com");
		user.setSalt("justice");
		user.setPassword("network301");
		
		when(service.login("testing@mail.com", "network301")).thenReturn(user);
		ObjectMapper mapper = new ObjectMapper();
		LoginInfo info = new LoginInfo();
		info.setEmail("testing@mail.com");
		info.setPassword("network301");
		String data = mapper.writeValueAsString(info);
		mvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON).content(data)).andExpect(status().isOk());
	}
}
