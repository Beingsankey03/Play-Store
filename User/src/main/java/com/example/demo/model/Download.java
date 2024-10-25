package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/*Author: Sanket Nadargi*/

//Entity class representing a download event of an application
@Entity
public class Download {
	 // Primary key for the Download entity, auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	// Many-to-one relationship with the App entity, where multiple downloads can belong to one app
	@ManyToOne
	@JoinColumn(name = "app_id") // Foreign key column in the 'Download' table referencing 'App'
	private App app;

	private LocalDateTime downloadDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public LocalDateTime getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(LocalDateTime downloadDate) {
		this.downloadDate = downloadDate;
	}

	
}
