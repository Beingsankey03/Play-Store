package com.example.demo.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
/*Author: Sanket Nadargi*/

//Entity class representing an application in the system
@Entity
public class App {
    // Primary key for the App entity, auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appId;
	
	private String name;
	private String description;
	private LocalDate releaseDate;
	private String version;
	private int rating;
	
	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

    // One-to-many relationship with the Comment entity, where an app can have multiple comments
	@OneToMany(mappedBy = "app", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> comment;
	
	private String genere;
	
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
    // One-to-many relationship with the Download entity, where an app can have multiple downloads
	@OneToMany(mappedBy = "app", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Download> downloads;


	public Long getAppId() {
		return appId;
	}


	public void setAppId(Long id) {
		this.appId = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
}

