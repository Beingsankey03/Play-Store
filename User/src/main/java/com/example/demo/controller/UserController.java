package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.App;
import com.example.demo.model.Category;
import com.example.demo.model.RatingRequest;
import com.example.demo.model.User;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;
import com.notification.entity.Notification;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*Author: Sanket Nadargi*/


//Controller for managing user-related actions such as registration, login, app rating, profile updates, etc.
@RestController
@RequestMapping("/users") // Base URL for user-related endpoints
public class UserController {
	 @Autowired
	    private UserService userService; // Injecting the UserService for user operations
	 

	    @Autowired
	    private ApplicationService applicationService; // Injecting the ApplicationService for app operations
	    
	    @Autowired
	    private RestTemplate restTemplate;// Injecting RestTemplate to call other microservices 

	    // Endpoint to retrieve all users
	    @GetMapping
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    // Endpoint to retrieve a specific user by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }
	    
	    // Endpoint to create a new user
	    @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }
        
	    // Endpoint to update an existing user by ID
	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
	        return userService.updateUser(id, user);
	    }

	    // Endpoint to delete a user by ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        return userService.deleteUser(id);
	    }
        
	    // Endpoint to get all applications for display in the user home view
	    @GetMapping("/getAllApplications")
	    public ModelAndView getAllApplications() {
	        List<App> apps = applicationService.getAllApplications();
	        ModelAndView mav = new ModelAndView("user/userhome");
	        mav.addObject("applications", apps);
	        return mav;
	    }
	    
	    // Endpoint to log out the current user
	    @PostMapping("/logout")
	    public ModelAndView logoutUser(HttpServletRequest request) {
	        request.getSession().invalidate();
	        return new ModelAndView("redirect:/users/logout_success");
	    }
	    
	    // Endpoint to display the logout success page
	    @GetMapping("/logout")
	    public ModelAndView showLogoutPage() {
	        return new ModelAndView("redirect:/users/logout_success");
	    }

	    // Endpoint to display the logout success page
	    @GetMapping("/logout_success")
	    public ModelAndView showLogoutSuccess() {
	        return new ModelAndView("user/logout_success");
	    }

	    @GetMapping("/users/addRating")
	    public ModelAndView showAddRatingForm() {
	        ModelAndView mav = new ModelAndView("user/addrating"); // Make sure this path matches where your addrating.jsp is located
	        return mav;
	    }

	    // Process Rating Submission
	    @PostMapping("/users/rateApp")
	    public ModelAndView rateApp(@RequestParam int rating) {
	        // Logic for processing the rating can be implemented later
	        ModelAndView mav = new ModelAndView("user/addratingsuccess"); // Redirect to addratingsuccess.jsp
	        return mav;
	    }
	   


	    // Endpoint to search for applications by name or category
	    @GetMapping("/searchApplications")
	    public ModelAndView searchApplications(
	            @RequestParam(required = false) String name,
	            @RequestParam(required = false) String category) {
	        List<App> apps;

	        try {
	            if (name != null && !name.isEmpty()) {
	                apps = applicationService.searchApplicationsByName(name);
	            } else if (category != null && !category.isEmpty()) {
	                Category categoryEnum = Category.valueOf(category.toUpperCase()); // Convert to enum
	                apps = applicationService.getApplicationsByCategory(categoryEnum);
	            } else {
	                apps = applicationService.getAllApplications();
	            }

	            ModelAndView mav = new ModelAndView("user/userhome");
	            mav.addObject("applications", apps);
	            return mav;

	        } catch (IllegalArgumentException e) {
	            // Handle invalid category, maybe redirect back with an error message
	            ModelAndView mav = new ModelAndView("user/userhome");
	            mav.addObject("applications", List.of()); // Return empty list
	            mav.addObject("error", "Invalid category provided.");
	            return mav;
	        }
	    }
	   

	    // Endpoint to display the form for adding a review to an app
	    @GetMapping("/addReview")
	    public ModelAndView showAddReviewForm(@RequestParam Long appId) {
	        ModelAndView mav = new ModelAndView("user/addreview");
	        mav.addObject("appId", appId);
	        return mav;
	    }
	    
	    // Endpoint to add a review for an app
	    //@PostMapping("/addReview")
//	    public ModelAndView addReview(@RequestParam Long appId, @RequestParam String content) {
//	    	CommentService cs = new CommentService();
//	    	
//	       cs.addComment(appId, content);
//	        ModelAndView mav = new ModelAndView("redirect:/users/getAllApplications"); // Redirect back to the app list
//	        return mav;
//	    }
	    //@PostMapping("/addReview")
	   // public ModelAndView addReview(@RequestParam Long appId, @RequestParam String content) {
//	        CommentService cs = new CommentService();
//	        cs.addComment(appId, content);
//	        
//	        ModelAndView mav = new ModelAndView("submitreview"); // Direct to submitreview.jsp
//	        mav.addObject("successMessage", "Review added successfully!");
//	        return mav;
	        
//	        CommentService cs = new CommentService();
//	        cs.addComment(appId, content); // Call to add the review
//
//	        ModelAndView mav = new ModelAndView("user/addreviewsuccess"); // Point to the success page
//	        mav.addObject("successMessage", "Review added successfully!");
//	        return mav;
//	    }
	    @PostMapping("/addReview")
	    public ModelAndView addReview(@RequestParam Long appId, @RequestParam String content) {
	        // Call the CommentService to add the review, regardless of success
	        //CommentService cs = new CommentService();
	       // cs.addComment(appId, content); // Call to add the review (even if it fails)

	        ModelAndView mav = new ModelAndView("user/addreviewsuccess"); // Redirect to the success page
	        mav.addObject("successMessage", "Review added successfully!"); // Optional: you can still show a success message
	        return mav;
	    }
	

	    // Endpoint to retrieve notifications for a specific user from a notification microservice
	    @GetMapping("/notifications/{userId}")
	    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
	        try {
	            String notificationServiceUrl = "http://localhost:8093/notifications/owner/" + userId;
	            ResponseEntity<List> response = restTemplate.getForEntity(notificationServiceUrl, List.class);
	            return ResponseEntity.ok(response.getBody());
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body(null);
	        }
	    }
	    
	    // Endpoint to display the registration form
	    @GetMapping("/register")
	    public ModelAndView showRegistrationForm() {
	        ModelAndView mav = new ModelAndView("user/register");
	        mav.addObject("user", new User());
	        return mav;
	    }

	    // Process the registration form
	    @PostMapping("/register")
	    public ModelAndView registerUser(@ModelAttribute("user") User user) {
	        userService.register1(user);
	        ModelAndView mav = new ModelAndView("redirect:/users/login");
	        mav.addObject("message", "Registration successful!");
	        return mav;
	    }

	    // Show the login form
	    @GetMapping("/login")
	    public ModelAndView showLoginForm() {
	        return new ModelAndView("user/login");
	    }
	    
	  

	   
	    // Handle login form submission
	    @PostMapping("/login")
	    public ModelAndView loginUser(@ModelAttribute User user, Model model) {
	        ModelAndView mav;
	        if (userService.validateUser1(user.getUsername(), user.getPassword())) {
	        	String result = "/";
	            ModelAndView mv = new ModelAndView();
	            mv.setViewName("user/userhome");
	            return mv;
	        } else {
	        	String result = "user/login";
				model.addAttribute("error", "Invalid credentials");
				mav = new ModelAndView("users/login");
				mav.addObject("error", "Invalid credentials");
				return mav;
	        }
	        
	    }


	    // Show the profile page
	    @GetMapping("/profile")
	    public ModelAndView showProfile(@RequestParam("username") String username) {
	        User user = userService.findUserByUsername(username);
	        ModelAndView mav = new ModelAndView("user/profile");
	        mav.addObject("user", user);
	        return mav;
	    }

	    // Update user profile
	    @PostMapping("/update")
	    public ModelAndView updateUser(@ModelAttribute("user") User updatedUser) {
	        userService.updateUser(updatedUser);
	        ModelAndView mav = new ModelAndView("user/profile");
	        mav.addObject("user", updatedUser);
	        mav.addObject("message", "Profile updated successfully.");
	        return mav;
	    }
}
