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

import com.inventory.management.model.Inventory;
import com.inventory.management.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Get all inventory items
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventoryItems() {
        return ResponseEntity.ok(inventoryService.getAllInventoryItems());
    }

    // Get low stock products
    @GetMapping("/low-stock")
    public ResponseEntity<List<Inventory>> getLowStockProducts(@RequestParam int threshold) {
        return ResponseEntity.ok(inventoryService.getLowStockProducts(threshold));
    }

    // Get oldest stock first
    @GetMapping("/oldest-stock")
    public ResponseEntity<List<Inventory>> getOldestStockFirst() {
        return ResponseEntity.ok(inventoryService.getOldestStockFirst());
    }

    // Get inventory by product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Inventory>> getInventoryByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.getInventoryByProductId(productId));
    }

    // Check if a product is in stock
    @GetMapping("/in-stock/{productId}")
    public ResponseEntity<Boolean> isProductInStock(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.isProductInStock(productId));
    }

    // Create or update an inventory item
    @PostMapping
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.saveInventory(inventory));
    }
}