package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.model.RestockNotification;
import com.inventory.management.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Get all pending restock notifications
    @GetMapping("/pending")
    public ResponseEntity<List<RestockNotification>> getAllPendingRestockNotifications() {
        return ResponseEntity.ok(notificationService.getAllPendingRestockNotifications());
    }

    // Check if notification exists for a product
    @GetMapping("/exists/{productId}")
    public ResponseEntity<Boolean> notificationExistsForProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(	notificationService.notificationExistsForProduct(productId));
    }

    // Mark notification as sent
    @PutMapping("/mark-sent/{productId}")
    public ResponseEntity<Void> markNotificationAsSent(@PathVariable Long productId) {
        notificationService.markNotificationAsSent(productId);
        return ResponseEntity.ok().build();
    }

    // Create or update a notification
    @PostMapping
    public ResponseEntity<RestockNotification> saveNotification(@RequestBody RestockNotification notification) {
        return ResponseEntity.ok(notificationService.saveNotification(notification));
    }
}