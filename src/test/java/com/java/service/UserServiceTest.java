package com.java.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.dao.UserDao;
import com.java.dto.User;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	@TestConfiguration
	static class TestConfig{
		@Bean
		public UserService userService() {
			return new UserServiceImpl_1();
		}
	}
	
	@Autowired
	private UserService service;
	@MockBean
	UserDao repo;
	
	@Test
	public void loginValidUserTest() {
		User user = new User();
		user.setFirstName("For ");
		user.setLastName("testing");
		user.setEmail("testing@mail.com");
		user.setSalt("justice");
		user.setPassword("network201");
		
		Mockito.when(repo.findByEmailAndPassword("testing@mail.com", "network201")).thenReturn(user);
		
		User result = service.login("testing@mail.com", "network201");
		assertNotNull(result);
		assertEquals("For ", result.getFirstName());
	}
	
	@Test
	public void loginInvalidUserTest() {
		Mockito.when(repo.findByEmailAndPassword("testing@mail.com", "network202")).thenReturn(null);
		User user = service.login("testing@mail.com", "network202");
		assertNull(user);
	}
}
