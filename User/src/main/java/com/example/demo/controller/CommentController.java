package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
/*Author: Sanket Nadargi*/


//Controller to manage comments for apps
@RestController
@RequestMapping("/apps/comments") // Base URL mapping for all comment-related endpoints
public class CommentController {
	
	@Autowired 
	CommentService  commentService;// Injecting CommentService to handle comment-related logic
	
	
	 // Endpoint to create a new comment for a specific app
	@PostMapping("/create")
	public ResponseEntity<Comment> addComment(@RequestParam Long appId, @RequestParam String content )
	{
		Comment comment = commentService.addComment(appId, content);
		
		return new ResponseEntity<>(comment, HttpStatus.CREATED);
	}
	
	// Endpoint to update an existing comment for a specific app
	@PutMapping("/update")

	public ResponseEntity<Comment> updateComment(@RequestParam Long appId, @RequestParam String Content){
		Comment comment=commentService.addComment(appId, Content);
		return new ResponseEntity<>(comment, HttpStatus.ACCEPTED);
	}
}

