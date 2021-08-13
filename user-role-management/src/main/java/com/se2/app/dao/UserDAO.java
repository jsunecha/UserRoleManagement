package com.se2.app.dao;

import java.util.List;

import com.se2.app.entity.User;

public interface UserDAO {
	public List<User> findAll();
	public User findById(int theId);
	public void save(User user);
	public void deleteById(int id);

}
