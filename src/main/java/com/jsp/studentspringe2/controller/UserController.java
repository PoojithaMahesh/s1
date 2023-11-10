package com.jsp.studentspringe2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.jsp.studentspringe2.service.UserService;
import com.jsp.studentspringe2.util.ResponseStructure;

@RestController
public class UserController {
    @Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserById(@RequestParam int userId) {
		return service.findUserById(userId);
	}
		
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUserById(@RequestParam int userId) {
		return service.deleteUserById(userId);
	}	
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
     return service.getAllUser();
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int userId,@RequestBody User user) {
		return service.updateUser(userId,user);
	}
//	
//	
//	
	
	
	
}
