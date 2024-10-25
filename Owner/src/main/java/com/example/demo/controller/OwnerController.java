package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

import com.example.demo.dto.CommentRequest;
import com.example.demo.model.App;
import com.example.demo.model.Category;
import com.example.demo.model.Owner;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.OwnerService;
import com.notification.dto.NotificationDTO;
/*Author: Sanket Nadargi*/

@RestController
//Maps HTTP requests that start with "/owners" to methods in this controller.
@RequestMapping("/owners")
public class OwnerController {
	// Automatically injects the `RestTemplate` bean to make HTTP requests
	@Autowired
	private RestTemplate restTemplate;

	
	// Automatically injects the `ApplicationService` for handling application-related operations.
	@Autowired
	private ApplicationService applicationService;
	
	// Automatically injects the `OwnerService` for handling owner-related operations.
	@Autowired
	private OwnerService ownerService;

	// Handles GET requests to "/owners/home" and returns a simple string message.
	@GetMapping("/home")
	public String hello() {
		return "welcome Owner";
	}
    
	// Handles GET requests to "/owners/logout" and returns a logout success page view.
	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView model) {
		return new ModelAndView("/owner/logout_success");
	}


	// Handles GET requests to get the average rating of an application by ID.
	@GetMapping("/averageRating/{id}")
	public ResponseEntity<String> getAverageRating(@PathVariable Long id) {
		try {
			double averageRating = applicationService.getAverageRating(id);
			return ResponseEntity.ok("Average rating: " + averageRating);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Failed to get average rating: " + e.getMessage());
		}
	}

	
	// Handles PUT requests to update the status of a comment by ID.
	@PutMapping("/updateComment/{id}")
	public ResponseEntity<?> updateCommentActiveStatus(@PathVariable Long id,
			@RequestBody CommentRequest commentRequest) {
		String answerServiceUrl = "http://localhost:8091/apps/comments/update/" + id;
		HttpEntity<CommentRequest> requestEntity = new HttpEntity<>(commentRequest);
		ResponseEntity<String> response = restTemplate.exchange(answerServiceUrl, HttpMethod.PUT, requestEntity,
				String.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			return ResponseEntity.ok("comment status updated successfully");
		} else {
			return ResponseEntity.status(response.getStatusCode()).body("Failed to update answer status");
		}
	}
	

	// Handles DELETE requests to delete a comment by ID.
	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable Long id) {
		String commentServiceUrl = "http://localhost:8091/apps/comments/delete/" + id;

		ResponseEntity<String> response = restTemplate.exchange(commentServiceUrl, HttpMethod.DELETE, null,
				String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			return ResponseEntity.ok("Comment deleted successfully");
		} else {
			return ResponseEntity.status(response.getStatusCode()).body("Failed to delete comment");
		}
	}
	

	// Handles GET requests to show the app creation form.
	@GetMapping ("/create")
	public ModelAndView GetAddApp(ModelAndView model) {
		return new ModelAndView("/owner/addapp");
	}
	

	// Handles GET requests to show the success page after an app is added.
	@GetMapping("/appaddsuccess")
	public ModelAndView showSuccessPage() {
	    return new ModelAndView("owner/appaddsuccess"); // Assuming appaddsuccess.jsp is in the owner folder
	}
	
	

	// Handles POST requests to create a new application.
	@PostMapping("/createApplication")
	public String saveApplication(@ModelAttribute App app) {
	    applicationService.saveApplication(app);
	    return "redirect:/owner/appaddsuccess"; // Redirect to the success page
	}

	
	// Handles GET requests to retrieve an application by ID for editing.
	@GetMapping("/getApplication/{id}")
	public ModelAndView getApplicationForEdit(@PathVariable Long id) {
	    App app = applicationService.getApplicationById(id); // Fetch the app details
	    ModelAndView modelAndView = new ModelAndView("owner/editapp");
	    modelAndView.addObject("app", app); // Pass the app object to the view
	    return modelAndView;
	}
	
	
	
	// Handles POST requests to update an existing application.
	@PostMapping("/updateApp/{id}")
	public String updateApp(@PathVariable Long id, @ModelAttribute App app) {
	    applicationService.updateApplication(id, app); // Call your update service
	    return "redirect:/owners/getAllApplications"; // Redirect back to the app list
	}


	
	// Handles GET requests to retrieve all applications and display them in the admin home page.
	@GetMapping("/getAllApplications")
	public ModelAndView getAllApplications(Model model) {
		List<App> applications = applicationService.getAllApplications();
		model.addAttribute("applications", applications);
		return new ModelAndView("owner/Admin_Home");
	}

	
	
	// Handles GET requests to search for applications by name.
	@GetMapping("/searchApplications")
	public ModelAndView searchApplications(@RequestParam String name, Model model) {
	    List<App> applications = applicationService.searchApplicationsByName(name);
	    model.addAttribute("applications", applications);
	    return new ModelAndView("owner/Admin_Home");
	}

	
	
	// Handles GET requests to retrieve applications by category.
	@GetMapping("/getApplicationsByCategory")
	public ResponseEntity<List<App>> getApplicationsByCategory(@RequestParam Category category) {
		String appServiceUrl = "http://localhost:8091/apps/category?category=" + category;
		ResponseEntity<List<App>> response = restTemplate.exchange(appServiceUrl, HttpMethod.GET, null,
				(Class<List<App>>) (Class<?>) List.class);
		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}

	
	// Handles GET requests to search for applications by rating.
	@GetMapping("/searchApplicationsByRating")
	public ResponseEntity<List<App>> searchApplicationsByRating(@RequestParam int rating) {
		String appServiceUrl = "http://localhost:8091/apps/rating?rating=" + rating;
		ResponseEntity<List<App>> response = restTemplate.exchange(appServiceUrl, HttpMethod.GET, null,
				(Class<List<App>>) (Class<?>) List.class);
		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}

	
	// Handles POST requests to delete an application by ID.
	@PostMapping("/deleteApplication/{id}")
    public String deleteApplication(@PathVariable("id") Long id) {
        applicationService.deleteApplicationById(id);
        return "redirect:/owners/Admin_Home"; // Redirect back to the app list
    }


	// Handles GET requests to show the owner registration form.
	@GetMapping("/register")
	public ModelAndView showRegistrationForm() {
		ModelAndView mav = new ModelAndView("owner/register");
		mav.addObject("owner", new Owner());
		return mav;
	}

	// Handles POST requests to register a new owner.
	@PostMapping("/register")
	public ModelAndView registerUser(@ModelAttribute("owner") Owner owner) {
		ownerService.register(owner);
		ModelAndView mav = new ModelAndView("redirect:/owners/login");
		mav.addObject("message", "Registration successful!");
		return mav;
	}
	

	// Handles GET requests to show the owner login form.
	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("owner/login");
	}

	// Handles POST requests for owner login.
	@PostMapping("/login")
	public ModelAndView loginOwner(@ModelAttribute Owner owner, Model model) {
		ModelAndView mav;
		if (ownerService.validateOwner(owner.getUsername(), owner.getPassword())) {
			String result = "/";
            ModelAndView mv = new ModelAndView();
            mv.setViewName("owner/Admin_Home");

			return mv;

		} else {
			String result = "owner/login";
			model.addAttribute("error", "Invalid credentials");
			mav = new ModelAndView("owner/login");
			mav.addObject("error", "Invalid credentials");
			return mav;
		}
		

	}

	// Handles GET requests to show the owner's profile page.
	@GetMapping("/profile")
	public ModelAndView showProfile(@RequestParam("username") String username) {
		Owner owner = ownerService.findOwnerByUsername(username);
		ModelAndView mav = new ModelAndView("owner/profile");
		mav.addObject("owner", owner);
		 mav.addObject("message", "Profile updated successfully.");
		return mav;
	}
  
	// Handles POST requests to update the owner's profile information.
	@PostMapping("/update")
	public ModelAndView updateOwner(@ModelAttribute("owner") Owner updatedOwner) {
		ownerService.updateOwner(updatedOwner);
		ModelAndView mav = new ModelAndView("owner/profile");
		mav.addObject("owner", updatedOwner);
		mav.addObject("message", "Profile updated successfully.");
		return mav;
	}
}