package com.jsp.studentspringe2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentspringe2.dao.UserDao;
import com.jsp.studentspringe2.dto.User;

@RestController
public class UserController {
    @Autowired
	private UserDao userDao;
	
	@RequestMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userDao.saveUser(user);
	}
}
