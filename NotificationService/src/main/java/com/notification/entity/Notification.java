package com.notification.entity;

import java.util.Date;

import jakarta.persistence.*;
/*Author: Sanket Nadargi*/

@Entity // Marks this class as a JPA entity
public class Notification {
	@Id // Indicates the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    
    private String message;

    @Column(nullable = false)
    private Long ownerid;

    @Column(nullable = false)
    private Long appId;

    @Column(nullable = false)
    private Date notificationDate;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}    


}
