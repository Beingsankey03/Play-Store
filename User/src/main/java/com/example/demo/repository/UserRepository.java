package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
/*Author: Sanket Nadargi*/

@Repository // Indicates that this interface is a Spring Data repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	 // Method to find a User by their username
	User findByUsername(String username); 
	

}
