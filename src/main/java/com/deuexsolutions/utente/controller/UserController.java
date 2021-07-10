package com.deuexsolutions.utente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deuexsolutions.utente.entity.User;
import com.deuexsolutions.utente.error.UserNotFoundException;
import com.deuexsolutions.utente.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@ApiOperation(value= "/users", tags= "User profile controller")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="Add a User", response= User.class)
	@ApiResponses(value= {
			@ApiResponse(code= 200, message= "Success"),
			@ApiResponse(code= 401, message= "Unauthorized"),
			@ApiResponse(code= 403, message= "Forbidden"),
			@ApiResponse(code= 404, message= "Not Found")
	})
	@PostMapping("/add")
	public User saveUser(
			@RequestBody User user) {
		return userService.saveUser(user);
	}

	@ApiOperation(value= "List all users", response= Iterable.class)
	@GetMapping("/find/all")
	public List<User> getUserList(){
		return userService.getUserList();
	}

	@ApiOperation(value="Find a User by ID", response= User.class)
	@GetMapping("/find/{id}")
	public User getUserById(
			@PathVariable("id") Long userId
			) throws UserNotFoundException {
		return userService.getUserById(userId);
	}

	@ApiOperation(value="Update a User", response= User.class)
	@PutMapping("/update/{id}")
	public User updateUser(
			@PathVariable("id") Long userId,
			@RequestBody User user
			) {
		return userService.updateUser(userId, user);
	}

}
