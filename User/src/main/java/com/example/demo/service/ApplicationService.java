package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.App;
import com.example.demo.model.Category;
import com.example.demo.model.Rating;
import com.example.demo.repository.AppRepository;
import com.example.demo.repository.RatingRepository;
/*Author: Sanket Nadargi*/

@Service // Marks this class as a Spring service component
public class ApplicationService {

	@Autowired
	AppRepository appRepo; // Dependency injection for AppRepository
	@Autowired
	private RatingRepository ratingRepository; // Dependency injection for RatingRepository

	// Method to calculate the average rating for an application by its ID
	public double getAverageRating(Long appId) {
		return ratingRepository.calculateAverageRating(appId);
	}

	// Method to add a rating for a specific application
	public void addRating(Long appId, int ratingValue) {
		App app = appRepo.findById(appId).orElseThrow(() -> new RuntimeException("App not found"));

		Rating rating = new Rating();
		rating.setValue(ratingValue);
		rating.setApp(app);
		ratingRepository.save(rating);

	}

	// Method to save a new application
	public App saveApplication(App app) {
		return appRepo.save(app);
	}
    
    // Method to retrieve all applications
	public List<App> getAllApplications() {
		return appRepo.findAll();
	}
    
    // Method to retrieve an application by its ID
	public App getApplicationById(Long id) {
		return appRepo.findById(id).orElse(null);
	}
    
    // Method to search for applications by name (case-insensitive)
	public List<App> searchApplicationsByName(String name) {
		return appRepo.findByNameContainingIgnoreCase(name);
	}

    // Method to retrieve applications by category
	public List<App> getApplicationsByCategory(Category category) {
		return appRepo.findByCategory(category);
	}

    // Method to retrieve applications by rating
	public List<App> getApplicationByRating(int rating) {
		return appRepo.findByRating(rating);
	}

    // Method to delete an application by its ID
	public void deleteApplicationById(Long id) {
		if (appRepo.existsById(id)) {
			appRepo.deleteById(id);
			System.out.println("Deleted application with id: " + id);
		} else {
			System.out.println("Attempted to delete non-existing application with id: " + id);
		}
	}

    // Method to update an existing application
	public App updateApplication(Long id, App updatedApp) {
		if (appRepo.existsById(id)) {
			updatedApp.setAppId(id); // Ensure the ID is set to update the correct entity
			return appRepo.save(updatedApp);
		} else {
			throw new RuntimeException("Application not found with ID: " + id);
		}
	}

}
