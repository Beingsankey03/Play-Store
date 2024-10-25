package com.example.demo.repository;


/*Author: Sanket Nadargi*/

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Owner;
import com.example.demo.model.User;
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	
	Owner findByUsername(String username); 
	// Custom query method to find an Owner by their username. The method name follows the Spring Data JPA naming conventions, 
	// which will automatically implement the method based on the provided name.

}
