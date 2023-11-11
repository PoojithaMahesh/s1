package com.jsp.studentspringe2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.studentspringe2.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    @Query("select u from User u where u.name=?1")
	public Optional<User> findUserByName(String name);
}
