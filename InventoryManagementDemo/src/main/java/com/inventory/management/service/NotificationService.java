package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.RestockNotification;
import com.inventory.management.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Get all pending restock notifications
    public List<RestockNotification> getAllPendingRestockNotifications() {
        return notificationRepository.findAllPendingRestockNotifications();
    }

    // Check if a notification for restocking a product exists
    public boolean notificationExistsForProduct(Long productId) {
        return notificationRepository.existsNotificationForProduct(productId);
    }

    // Mark notification as sent
    public void markNotificationAsSent(Long productId) {
        notificationRepository.markNotificationAsSent(productId);
    }

    // Save or update a notification
    public RestockNotification saveNotification(RestockNotification notification) {
        return notificationRepository.save(notification);
    }
}