package com.inventory.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.Inventory;
import com.inventory.management.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Get all inventory items
    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    // Get low stock products (stock quantity less than a threshold)
    public List<Inventory> getLowStockProducts(int threshold) {
        return inventoryRepository.findLowStockProducts(threshold);
    }

    // Get oldest stock first (FIFO system)
    public List<Inventory> getOldestStockFirst() {
        return inventoryRepository.findOldestStockFirst();
    }

    // Get inventory by product ID
    public List<Inventory> getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    // Check if a product has stock available
    public boolean isProductInStock(Long productId) {
        return inventoryRepository.existsByProductIdAndInStock(productId);
    }

    // Save or update an inventory item
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}