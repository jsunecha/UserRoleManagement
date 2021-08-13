package com.se2.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se2.app.dao.UserDAOJpaImpl;
import com.se2.app.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAOJpaImpl userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAOJpaImpl theUserDAO) {
		userDAO = theUserDAO;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theId) {
		// TODO Auto-generated method stub
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theEmployee) {
		// TODO Auto-generated method stub
		userDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		userDAO.deleteById(theId);
	}

}
