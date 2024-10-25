package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/*Author: Sanket Nadargi*/

//Entity class representing a rating for an application
@Entity
public class Rating {
    // Primary key for the Rating entity, auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int value;
    
	// Many-to-one relationship with the App entity, where multiple ratings can belong to one app
	@ManyToOne
	@JoinColumn(name = "app_id")
	private App app;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

}