package com.inventory.management.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int stockQuantity;
    private Date stockDate;
    
	public Inventory(Long id, Product product, int stockQuantity, Date stockDate) {
		super();
		this.id = id;
		this.product = product;
		this.stockQuantity = stockQuantity;
		this.stockDate = stockDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", product=" + product + ", stockQuantity=" + stockQuantity + ", stockDate="
				+ stockDate + "]";
	}

    
}