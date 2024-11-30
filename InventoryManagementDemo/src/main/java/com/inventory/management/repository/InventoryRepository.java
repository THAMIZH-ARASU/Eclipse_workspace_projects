package com.inventory.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.management.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Fetch inventory items with low stock (e.g., less than 10 units in stock)
    @Query("SELECT i FROM Inventory i WHERE i.stockQuantity < :threshold")
    List<Inventory> findLowStockProducts(@Param("threshold") int threshold);

    // Fetch the oldest inventory items first (FIFO order)
    @Query("SELECT i FROM Inventory i ORDER BY i.stockDate ASC")
    List<Inventory> findOldestStockFirst();

    // Fetch inventory by product ID (for specific stock details)
    @Query("SELECT i FROM Inventory i WHERE i.product.id = :productId")
    List<Inventory> findByProductId(@Param("productId") Long productId);

    // Check if inventory is available for a product (check by product ID)
    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM Inventory i WHERE i.product.id = :productId AND i.stockQuantity > 0")
    boolean existsByProductIdAndInStock(@Param("productId") Long productId);
}