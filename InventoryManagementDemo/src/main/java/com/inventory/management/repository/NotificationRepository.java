package com.inventory.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.management.model.RestockNotification;

public interface NotificationRepository extends JpaRepository<RestockNotification, Long> {

    // Check if notification has already been sent for a specific product
    @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM RestockNotification n WHERE n.product.id = :productId AND n.notified = true")
    boolean existsNotificationForProduct(@Param("productId") Long productId);

    // Fetch all notifications for products that require restocking
    @Query("SELECT n FROM RestockNotification n WHERE n.notified = false")
    List<RestockNotification> findAllPendingRestockNotifications();

    // Fetch all notifications for a specific product
    @Query("SELECT n FROM RestockNotification n WHERE n.product.id = :productId")
    List<RestockNotification> findByProductId(@Param("productId") Long productId);

    // Mark a notification as sent (notified = true)
    @Query("UPDATE RestockNotification n SET n.notified = true WHERE n.product.id = :productId")
    void markNotificationAsSent(@Param("productId") Long productId);
}