package com.jsp.studentspringe2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.studentspringe2.Studentspringe2Application;
import com.jsp.studentspringe2.dto.User;
import com.jsp.studentspringe2.repository.UserRepo;

@Repository
public class UserDao {

	
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);	
	}

	public User findUserById(int id) {
		Optional<User> optional=repo.findById(id);
		
		if(optional.isPresent()) {
//			id is present
			User user=optional.get();
			return user;
		}else {
//			id is not present
			return null;
		}
	}

	public User findUserByName(String name) {
		Optional<User> optional=repo.findUserByName(name);
		if(optional.isPresent()) {
//			user exist with this name
			return optional.get();
		}
		return null;
	}
	
	
	public User deleteUserById(int userId) {

      Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
//			id is present and now i can delete this user
			User user=optional.get();
			repo.delete(user);
			return user;
		}
		return null;
	}

	public List<User> getAllUser() {
	
		return repo.findAll();
	}

	public User updateUser(int userId, User user) {
//	 how to update
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
//			id is present then i can update the data
			user.setId(userId);
			return repo.save(user);
		}
		
		return null;
	}

	
	
	
	
	
	
	
}
