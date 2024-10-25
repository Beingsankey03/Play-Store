package com.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.dto.NotificationDTO;
import com.notification.entity.Notification;
import com.notification.service.NotificationService;
/*Author: Sanket Nadargi*/

@RestController // Indicates that this class is a REST controller
@RequestMapping("/notifications") // Base URL for all notification-related endpoints
public class NotificationController {
	@Autowired
    private NotificationService notificationService;

	 // Endpoint to create a new notification
    @PostMapping
    public Notification createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotification(notificationDTO);
    }

    // Endpoint to retrieve notifications for a specific owner by their ID
    @GetMapping("/owner/{ownerId}")
    public List<Notification> getNotificationsByOwnerId(@PathVariable Long ownerId) {
        return notificationService.getNotificationsByOwnerId(ownerId);
    }

}
