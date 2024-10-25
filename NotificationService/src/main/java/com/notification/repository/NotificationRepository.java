package com.notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification.entity.Notification;
/*Author: Sanket Nadargi*/

//Repository interface for managing Notification entities
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Method to find notifications by the owner ID
    List<Notification> findByOwnerid(Long ownerid); 

}
