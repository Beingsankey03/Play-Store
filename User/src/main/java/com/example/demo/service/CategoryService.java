package com.example.demo.service;

import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
/*Author: Sanket Nadargi*/

 

@Service // Marks this class as a Spring service component
public class CategoryService {
	
	// Method to retrieve all categories as a list
	public List<Category> getAllCategories()
	{
		return Arrays.asList(Category.values());
	}

}