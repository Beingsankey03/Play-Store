package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.App;
import com.example.demo.model.Category;
import com.example.demo.service.ApplicationService;
/*Author: Sanket Nadargi*/

//Controller for handling HTTP requests related to applications (apps)
@RestController
@RequestMapping("/apps")// Base URL mapping for all app-related endpoints
public class AppController {
	
	@Autowired
    private ApplicationService applicationService;
	 // Endpoint to create a new app
    @PostMapping("/create")
    public ResponseEntity<?> addApplication(@RequestBody App app) {
        App savedApplication = applicationService.saveApplication(app);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }
    
    // Endpoint to retrieve a specific app by its ID
    @GetMapping("/{id}")
    public ResponseEntity<App> getApplicationById(@PathVariable Long id) {
        App app = applicationService.getApplicationById(id);
        if (app != null) {
            return new ResponseEntity<>(app, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 

    // Endpoint to retrieve all applications
    @GetMapping("/getall")
    public ResponseEntity<Iterable<App>> getAllApplications() {
        return new ResponseEntity<>(applicationService.getAllApplications(), HttpStatus.OK);
    }
    
    // Endpoint to search applications by name
    @GetMapping("/search")
    public ResponseEntity<List<App>> searchApplications(@RequestParam String name) {
        List<App> apps = applicationService.searchApplicationsByName(name);
        return ResponseEntity.ok(apps);
    }
    
    // Endpoint to filter applications by category
    @GetMapping("/category")
    public ResponseEntity<List<App>> getApplicationsByCategory(@RequestParam Category category) {
        return ResponseEntity.ok(applicationService.getApplicationsByCategory(category));
    }
    
    // Endpoint to filter applications by rating
    @GetMapping("/rating")
    public ResponseEntity<List<App>> searchApplications(@RequestParam int rating) {
        List<App> apps = applicationService.getApplicationByRating(rating);
        return ResponseEntity.ok(apps);
    }
    
    // Endpoint to delete an app by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationById(@PathVariable Long id) {
        App app = applicationService.getApplicationById(id);
        if (app != null) {
            applicationService.deleteApplicationById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
