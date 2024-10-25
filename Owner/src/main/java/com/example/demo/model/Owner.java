package com.example.demo.model;

import jakarta.persistence.*;
/*Author: Sanket Nadargi*/



@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	//Field to store username and password with unique username always.
	@Column(unique = true)
	private String email;
	private String password;
	
	// Getter and setter methods for each field.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
