package com.notification.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.dto.NotificationDTO;
import com.notification.entity.Notification;
import com.notification.repository.NotificationRepository;
/*Author: Sanket Nadargi*/

@Service // Service class for handling notification-related business logic
public class NotificationService {
	@Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setAppId(notificationDTO.getAppId());
        notification.setOwnerid(notificationDTO.getOwnerid());
        notification.setMessage(notificationDTO.getMessage());
        notification.setNotificationDate(new Date());

        return notificationRepository.save(notification);
    }
    // Method to retrieve notifications based on owner ID
    public List<Notification> getNotificationsByOwnerId(Long ownerid) {
    	
        return notificationRepository.findByOwnerid(ownerid); // Fetch notifications for the given owner ID
    }

}
