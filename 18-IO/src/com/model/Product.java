package com.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;
	private Company company;
	
	private static int stavar=123;
	
	
	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", company=" + company + "]";
	}



	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}
