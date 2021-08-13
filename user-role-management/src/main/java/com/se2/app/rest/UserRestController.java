package com.se2.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se2.app.entity.User;
import com.se2.app.service.UserServiceImpl;

@RestController
@RequestMapping("/api")

public class UserRestController {
	// private UserDAO UserDAO;
	private UserServiceImpl userService;

	@Autowired
	public UserRestController(UserServiceImpl theUserService) {
		userService = theUserService;
	}

	/*
	 * @Autowired public UserRestController(UserDAO theUserDAO) {
	 * UserDAO = theUserDAO; }
	 * 
	 * @GetMapping("/Users") public List<User> findAll() { return
	 * UserDAO.findAll(); }
	 */
	// expose "/Users" and return list of Users
	@GetMapping("/Users")
	public List<User> findAll() {
		return userService.findAll();
	}

	// add mapping for GET /Users/{UserId}
	@GetMapping("/Users/{UserId}")
	public User getUser(@PathVariable int userId) {
		User theUser = userService.findById(userId);
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		return theUser;
	}

	// add mapping for POST /Users - add new User
	@PostMapping("/Users")
	public User addUser(@RequestBody User theUser) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theUser.setUserId(0);
		userService.save(theUser);
		return theUser;
	}

	// add mapping for PUT /Users - update existing User
	@PutMapping("/Users")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}

	// add mapping for DELETE /Users/{UserId} - delete User
	@DeleteMapping("/Users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User tempUser = userService.findById(userId);
		// throw exception if null
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		userService.deleteById(userId);
		return "Deleted User id - " + userId;
	}

}
