package com.jsp.studentspringe2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentspringe2.dao.UserDao;
import com.jsp.studentspringe2.dto.User;

@RestController
public class UserController {
    @Autowired
	private UserDao userDao;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userDao.saveUser(user);
	}
	@GetMapping("/find")
	public User findUserById(@RequestParam int userId) {
		return userDao.findUserById(userId);
	}
	
	@DeleteMapping("/delete")
	public User deleteUserById(@RequestParam int userId) {
		return userDao.deleteUserById(userId);
	}
	@GetMapping("/findall")
	public List<User> findAll(){
     return userDao.getAllUser();
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestParam int userId,@RequestBody User user) {
		return userDao.updateUser(userId,user);
	}
	
	
	
	
	
	
}
