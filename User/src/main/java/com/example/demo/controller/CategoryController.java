package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

/*Author: Sanket Nadargi*/

//Controller to manage categories for the application
@RestController
@RequestMapping("/apps/category")// Base URL mapping for all category-related endpoints
public class CategoryController {
	
	@Autowired 
	CategoryService categoryservice;// Injecting CategoryService to handle category-related logic
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Category>> getAllCategories()
	{
		// Fetch all categories using the service
		List<Category> categories = categoryservice.getAllCategories();
		return ResponseEntity.ok(categories);
		
	}

}
