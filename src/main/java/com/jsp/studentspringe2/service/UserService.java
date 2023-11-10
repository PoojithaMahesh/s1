package com.jsp.studentspringe2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.studentspringe2.dao.UserDao;
import com.jsp.studentspringe2.dto.User;
import com.jsp.studentspringe2.exception.UserIdNOtFoundException;
import com.jsp.studentspringe2.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
//		1.It should sent this user object to the UserDao to save
		User dbUser=userDao.saveUser(user);
//		2.IT should return a Proper response
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setMessage("UserDataSavedSuccessfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<User>> findUserById(int userId) {
         User dbUser=userDao.findUserById(userId);
         
         if(dbUser!=null) {
//        	 id is present
        	 ResponseStructure<User> structure=new ResponseStructure<User>();
        	 structure.setMessage("USERDATAFETCHEDSUCCESSFULLY");
        	 structure.setHttpStatus(HttpStatus.FOUND.value());
        	 structure.setData(dbUser);
        	 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
        	 
         }else {
//        	 id is not present
        	throw new UserIdNOtFoundException("Sorry failed to find User");
        	 
         }
         
         
         
         
         
         

		
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int userId) {
		User dbUser=userDao.deleteUserById(userId);
		 if(dbUser!=null) {
//        	 id is present
        	 ResponseStructure<User> structure=new ResponseStructure<User>();
        	 structure.setMessage("USERDATA Deleted SUCCESSFULLY");
        	 structure.setHttpStatus(HttpStatus.FOUND.value());
        	 structure.setData(dbUser);
        	 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
        	 
         }else {
//        	 id is not present
        	 ResponseStructure<User> structure=new ResponseStructure<User>();
        	 structure.setMessage("Sorry Id is not present");
        	 structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
        	 structure.setData(null);
        	 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
                	 
        	 
         }
	}


	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		List<User> list=userDao.getAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		structure.setMessage("User data fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}


	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) {
		User dbUser=userDao.updateUser(userId, user);
		
		if(dbUser!=null) {
//			id is present and we updated successfully
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("User data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
			
			
		}else {
//			id is not present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Sorry id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
