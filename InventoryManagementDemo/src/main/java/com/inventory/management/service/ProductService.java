package com.inventory.management.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Product;
import com.inventory.management.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get trendy products
    public List<Product> getTrendyProducts() {
        return productRepository.findAllTrendyProducts();
    }

    // Get newly launched products
    public List<Product> getNewlyLaunchedProducts() {
        return productRepository.findNewlyLaunchedProducts();
    }

    // Get low-interest products (less than a threshold)
    public List<Product> getLowInterestProducts(int threshold) {
        return productRepository.findLowInterestProducts(threshold);
    }

    // Search product by name
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    // Get product by ID
    public Product getProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    // Save or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}