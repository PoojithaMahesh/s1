package com.jsp.studentspringe2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.studentspringe2.dto.User;
import com.jsp.studentspringe2.repository.UserRepo;

@Repository
public class UserDao {

	
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);	
	}

	
	
	
	
	
	
	
}
