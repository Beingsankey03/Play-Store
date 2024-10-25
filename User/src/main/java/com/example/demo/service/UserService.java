package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
/*Author: Sanket Nadargi*/



@Service // Marks this class as a Spring service component
public class UserService {
	@Autowired // Automatically injects an instance of UserRepository
    private UserRepository userRepository;
	
	// Method to register a new user
	public void register1(User user) {
		if (user == null || user.getUsername() == null || user.getPassword() == null) {
	        throw new InvalidRequestException("User data cannot be null.");
	    }
        userRepository.save(user);
    }

	 // Method to validate user credentials
    public boolean validateUser1(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new InvalidRequestException("User not found.");
        }
        if (!user.getPassword().equals(password)) {
            throw new InvalidRequestException("Invalid credentials.");
        }
        return user != null && user.getPassword().equals(password);
    }
    
     // Method to find a user by username
    public User findUserByUsername1(String username) {
    	User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new InvalidRequestException("User not found with username: " + username);
        }
    	
        return userRepository.findByUsername(username);
    }

    // Method to update an existing user
//    public void updateUser1(User updatedUser) {
//        userRepository.save(updatedUser);
//    }
    public ResponseEntity<User> updateUser(Long id, User user) {
        if (user == null) {
            throw new InvalidRequestException("User data cannot be null.");
        }
        if (!userRepository.existsById(id)) {
            throw new InvalidRequestException("User not found with ID: " + id);
        }
        user.setId(id);
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Method to retrieve a user by ID
    public ResponseEntity<User> getUserById(Long id) {
    	return userRepository.findById(id)
    	        .map(ResponseEntity::ok)
    	        .orElseThrow(() -> new InvalidRequestException("User not found with ID: " + id));
        //Optional<User> user = userRepository.findById(id);
       // return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Method to create a new user
    public ResponseEntity<User> createUser(User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    
    // Method to update an existing user by ID
//    public ResponseEntity<User> updateUser(Long id, User user) {
//        if (!userRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        user.setId(id);
//        User updatedUser = userRepository.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
    
    // Method to delete a user by ID
    public ResponseEntity<Void> deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    public void register(User user) {
        // Logic to register user in the database
    }

    // Method to find a user by username
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);  // Fetches the user from the database using username
    }

    // Method to update user details
    public void updateUser(User updatedUser) {
        
        User existingUser = userRepository.findByUsername(updatedUser.getUsername());

        if (existingUser != null) {
           
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());  // Make sure to hash the password in production
            userRepository.save(existingUser);  // Save the updated user back to the database
        }
    }

}
