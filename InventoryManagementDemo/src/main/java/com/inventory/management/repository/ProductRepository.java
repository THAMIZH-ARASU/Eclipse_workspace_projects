package com.inventory.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.management.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Fetch all trendy products (products with high demand/interest)
    @Query("SELECT p FROM Product p WHERE p.isTrendy = true")
    List<Product> findAllTrendyProducts();

    // Fetch all products with low interest
    @Query("SELECT p FROM Product p WHERE p.interestCount < :threshold")
    List<Product> findLowInterestProducts(@Param("threshold") int threshold);

    // Fetch newly launched products based on the launch date (e.g., launched in the last 30 days)
    @Query("SELECT p FROM Product p WHERE p.launchDate > CURRENT_DATE - 30")
    List<Product> findNewlyLaunchedProducts();

    // Fetch products by name (search functionality)
    List<Product> findByNameContainingIgnoreCase(String name);

    // Fetch product details by product ID
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product findProductById(@Param("id") Long id);
}