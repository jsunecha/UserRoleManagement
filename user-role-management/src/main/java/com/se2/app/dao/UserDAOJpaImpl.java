package com.se2.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se2.app.entity.User;

@Repository
public class UserDAOJpaImpl implements UserDAO {
	
	private EntityManager entityManager;

	
	@Autowired
	public UserDAOJpaImpl(EntityManager theEntityManager) {
	entityManager = theEntityManager;
	}
	
	@Override
	public List<User> findAll() {
		// create a query
		Query theQuery = entityManager.createQuery("from User");
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		// return the results
		return users;
		
	}

	@Override
	public User findById(int theId) {
		// get employee
		User theUser = entityManager.find(User.class, theId);
		// return employee
		return theUser;
	}

	@Override
	public void save(User theUser) {
		// save or update the employee
		User dbUser = entityManager.merge(theUser);
		// update with id from db ... so we can get generated id for save/insert
		theUser.setUserId(dbUser.getUserId());
		
	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
