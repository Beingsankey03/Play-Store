package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.App;
import com.example.demo.model.Category;
/*Author: Sanket Nadargi*/

@Repository
public interface AppRepository extends JpaRepository<App,Long> {
        
	    // Find all apps by category	
		List<App> findByCategory(Category category);
		
		// Find apps whose names contain the specified string, ignoring case
		List<App> findByNameContainingIgnoreCase(String name);
		
		// Find all apps with the specified rating
		List<App> findByRating(int rating);
}
