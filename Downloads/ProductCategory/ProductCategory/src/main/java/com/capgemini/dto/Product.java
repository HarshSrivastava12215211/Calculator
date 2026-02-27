package com.capgemini.dto;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;

@Entity

public class Product {
	@Id
	int id ; 
	String name ; 
	double price ; 
	@ManyToOne
	private Category c ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", c=" + c + "]";
	} 
	
}
