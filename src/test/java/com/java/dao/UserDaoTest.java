package com.java.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.dto.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoTest {
	@Autowired
	TestEntityManager testManager;
	
	@Autowired
	UserDao repo;
	
	@Test
	public void getUserByValidLoginInfoTest() {
		User user = new User();
		user.setFirstName("For ");
		user.setLastName("testing");
		user.setEmail("testing@mail.com");
		user.setSalt("justice");
		user.setPassword("network101");
		testManager.merge(user);
		//testManager.persist(user);
		testManager.flush();
		User result = repo.findByEmailAndPassword("testing@mail.com", "network101");
		assertNotNull(result);
		assertEquals(1, result.getUser_id());
	}
	@Test
	public void getUserByInvalidLoginInfoTest() {
		User result = repo.findByEmailAndPassword("testing@mail.com", "network102");
		assertNull(result);
		
	}
}
