package com.deuexsolutions.utente.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deuexsolutions.utente.entity.User;
import com.deuexsolutions.utente.error.UserNotFoundException;
import com.deuexsolutions.utente.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	
	//Method to save user
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	//Method to list all users present
	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	//Method to find user by userId
	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		Optional<User> user= userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User not available");
		return user.get();
	}

	//Method to update user
	@Override
	public User updateUser(Long userId, User user) {
		User userDB= userRepository.findById(userId).get();

		if(Objects.nonNull(user.getFirstName())&&
				!"".equalsIgnoreCase(user.getFirstName()))
			userDB.setFirstName(user.getFirstName());
		
		if(Objects.nonNull(user.getLastName())&&
				!"".equalsIgnoreCase(user.getLastName())
				)
			userDB.setLastName(user.getLastName());
		
		if(Objects.nonNull(user.getEmail())&&
				!"".equalsIgnoreCase(user.getEmail())
				)
			userDB.setEmail(user.getEmail());			

		return userRepository.save(userDB);
	}

}
