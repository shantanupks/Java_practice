package com.app.model;

public class Chapter {
	private int index;
	private String title;
	private int pages;
	private int book_isbn;
	public Chapter(int index, String title, int pages, int book_isbn) {
		super();
		this.index = index;
		this.title = title;
		this.pages = pages;
		this.book_isbn = book_isbn;
	}
	
	public Chapter() {
		super();
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(int book_isbn) {
		this.book_isbn = book_isbn;
	}
	@Override
	public String toString() {
		return "Chapter [index=" + index + ", title=" + title + ", pages=" + pages + ", book_isbn=" + book_isbn + "]";
	}
	
	

}
