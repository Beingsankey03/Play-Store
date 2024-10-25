package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.App;
import com.example.demo.model.Comment;
import com.example.demo.repository.AppRepository;
import com.example.demo.repository.CommentRepository;
/*Author: Sanket Nadargi*/

@Service // Marks this class as a Spring service component
public class CommentService {
	
	@Autowired // Automatically injects an instance of CommentRepository
	CommentRepository commentRepository;
	
	@Autowired // Automatically injects an instance of AppRepository
	AppRepository appRepo;
	
	// Method to add a comment to an application
	public Comment addComment(Long appId, String content)
	{
		 // Retrieves the App by ID; throws an exception if not found
		App app = appRepo.findById(appId)
				.orElseThrow(() -> new RuntimeException("Application Not Found"));
		
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setApp(app);
		
		return commentRepository.save(comment);
	}
	
	

}
