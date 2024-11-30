package com.example.demo;
import org.springframework.boot.autoconfigure.domain.EntityScan;


//import jakarta.persistence.Entity;

@EntityScan
public class Product   
{  
	//@Id
	private int id;  
	private String pname;  
	private String batchno;  
	private double price;  
	private int noofproduct;
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", batchno=" + batchno + ", price=" + price + ", noofproduct="
				+ noofproduct + "]";
	}

	public Product(int id, String pname, String batchno, double price, int noofproduct) {
		this.id = id;
		this.pname = pname;
		this.batchno = batchno;
		this.price = price;
		this.noofproduct = noofproduct;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNoofproduct() {
		return noofproduct;
	}
	public void setNoofproduct(int noofproduct) {
		this.noofproduct = noofproduct;
	}  
	 
	
}  