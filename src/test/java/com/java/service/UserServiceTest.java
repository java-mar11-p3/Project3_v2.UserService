package com.java.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

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
/*
 * When doing unit test at the service layer, we do not want to call to the real repo object.
 * We assume the repo will always work and return us what we want.
 * Thus, we create a mock object of the repo.
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {
	//Since we only run the test, and not the application itself, spring will not be able to locate the bean for UserServiceImpl_1.
	//So, we created this static class to defined the bean.
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
		// We use mockito to mock the behavior of the mock repo object.
		when(repo.findByEmailAndPassword("testing@mail.com", "network201")).thenReturn(user);
		
		User result = service.login("testing@mail.com", "network201");
		//test if the result is not null
		assertNotNull(result);
		//test if we are getting back the right result.
		assertEquals("For ", result.getFirstName());
	}
	// This is the test for when the email and password does not exist in the table.
	@Test
	public void loginInvalidUserTest() {
		when(repo.findByEmailAndPassword("testing@mail.com", "network202")).thenReturn(null);
		User user = service.login("testing@mail.com", "network202");
		assertNull(user);
	}
}
