package com.deuexsolutions.utente.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.deuexsolutions.utente.entity.User;
import com.deuexsolutions.utente.error.UserNotFoundException;
import com.deuexsolutions.utente.repo.UserRepository;

class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		User user=
				User.builder()
				.userId(1L)
				.firstName("Abhishek")
				.lastName("Sharma")
				.email("abhishek@email.com")
				.build();
		Mockito.when(userRepository.findById(1L).get())
		.thenReturn(user);
				
	}

	@Test
	public void whenValidUserId_thenUserShouldBeFound() throws UserNotFoundException {
		Long userId= 1L;
		
		User userFound=
				userService.getUserById(userId);
		assertEquals(userId, userFound.getUserId());
	}

}
