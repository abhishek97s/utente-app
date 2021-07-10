package com.deuexsolutions.utente.service;

import java.util.List;

import com.deuexsolutions.utente.entity.User;
import com.deuexsolutions.utente.error.UserNotFoundException;

public interface UserService {

	User saveUser(User user);

	List<User> getUserList();

	User getUserById(Long userId) throws UserNotFoundException;

	User updateUser(Long userId, User user);


}
