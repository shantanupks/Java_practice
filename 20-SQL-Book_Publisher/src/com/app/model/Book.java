package com.app.model;

public class Book {
	private int isbn;
	private String title;
	private double price;
	private int publisher_id;
	public Book(int isbn, String title, double price, int publisher_id) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publisher_id = publisher_id;
	}
	
	
	
	public Book() {
		super();
	}



	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisher_id=" + publisher_id + "]";
	}
	
	

}
