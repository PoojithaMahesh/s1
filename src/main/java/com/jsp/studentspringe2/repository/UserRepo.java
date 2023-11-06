package com.jsp.studentspringe2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.studentspringe2.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
