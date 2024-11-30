
package com.inventory.management.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date launchDate;
    private int interestCount;
    private boolean isTrendy;
    
	public Product(Long id, String name, String description, Date launchDate, int interestCount, boolean isTrendy) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.launchDate = launchDate;
		this.interestCount = interestCount;
		this.isTrendy = isTrendy;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	public int getInterestCount() {
		return interestCount;
	}
	public void setInterestCount(int interestCount) {
		this.interestCount = interestCount;
	}
	public boolean isTrendy() {
		return isTrendy;
	}
	public void setTrendy(boolean isTrendy) {
		this.isTrendy = isTrendy;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", launchDate=" + launchDate
				+ ", interestCount=" + interestCount + ", isTrendy=" + isTrendy + "]";
	}
	
}
