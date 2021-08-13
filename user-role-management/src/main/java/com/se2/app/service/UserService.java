package com.se2.app.service;

import java.util.List;

import com.se2.app.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int theId);
	public void save(User theEmployee);
	public void deleteById(int theId);
}
