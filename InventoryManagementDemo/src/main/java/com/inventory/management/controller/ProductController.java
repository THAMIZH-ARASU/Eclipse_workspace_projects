package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.model.Product;
import com.inventory.management.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Get trendy products
    @GetMapping("/trendy")
    public ResponseEntity<List<Product>> getTrendyProducts() {
        return ResponseEntity.ok(productService.getTrendyProducts());
    }

    // Get newly launched products
    @GetMapping("/newly-launched")
    public ResponseEntity<List<Product>> getNewlyLaunchedProducts() {
        return ResponseEntity.ok(productService.getNewlyLaunchedProducts());
    }

    // Get low-interest products
    @GetMapping("/low-interest")
    public ResponseEntity<List<Product>> getLowInterestProducts(@RequestParam int threshold) {
        return ResponseEntity.ok(productService.getLowInterestProducts(threshold));
    }

    // Search products by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProductsByName(name));
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Create or update a product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }
}