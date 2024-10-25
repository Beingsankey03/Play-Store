package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.globalException.ResourceNotFoundException;
import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;
/*Author: Sanket Nadargi*/



@Service
//Marks this class as a Spring service component, allowing Spring to manage it as a bean.
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepo;
	
	// Method to register a new owner by saving it to the database.
	public void register(Owner owner) {
		ownerRepo.save(owner);
	}
	
	// Method to validate the owner's credentials during login.
	public boolean validateOwner(String username, String password) {
        //Owner owner = ownerRepo.findByUsername(username);
        Owner owner = ownerRepo.findByUsername(username);

        if (owner == null) {
            throw new ResourceNotFoundException("Owner not found with username: " + username);
        }
        if (!owner.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password for username: " + username);
        }
        
        //return owner != null && owner.getPassword().equals(password);
        return true;
    }
	
	// Method to find and return the owner by their username.
	public Owner findOwnerByUsername(String username) {
       // return ownerRepo.findByUsername(username);
		 Owner owner = ownerRepo.findByUsername(username);
	        if (owner == null) {
	            throw new ResourceNotFoundException("Owner not found with username: " + username);
	        }
	        return owner;
    }
	
	// Method to update the owner's information in the database.
	public void updateOwner(Owner updatedOwner) {
        //ownerRepo.save(updatedOwner);
		 if (ownerRepo.existsById(updatedOwner.getId())) {
	            ownerRepo.save(updatedOwner);
	        } else {
	            throw new ResourceNotFoundException("Owner not found with ID: " + updatedOwner.getId());
	        }
    }
}
