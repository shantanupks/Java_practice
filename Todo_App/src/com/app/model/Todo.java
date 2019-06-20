package com.app.model;

import java.time.LocalDateTime;

public class Todo {
	private int id;
	private String title;
	private boolean completed;
	private LocalDateTime date;

	public Todo(int id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.completed = false;
		this.date = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", date=" + date + "]";
	}
	
	
	

}
