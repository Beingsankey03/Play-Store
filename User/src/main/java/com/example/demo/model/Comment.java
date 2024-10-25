package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*Author: Sanket Nadargi*/

//Entity class representing comments made on an application
@Entity
public class Comment {

    // Primary key for the Comment entity, auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String content;
	
    // Many-to-one relationship with the App entity, where multiple comments can belong to one app
	@ManyToOne
	@JoinColumn(name = "app_id")// Foreign key column in the 'Comment' table referencing 'App'
	private App app;

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
