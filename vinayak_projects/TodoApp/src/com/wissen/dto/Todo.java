package com.wissen.dto;

import java.time.LocalDateTime;

public class Todo {

	private int id;
	private String title;
	private boolean isCompleted;
	private LocalDateTime createdAt;

	public Todo(int id, String title, boolean isCompleted, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.isCompleted = isCompleted;
		this.createdAt = createdAt;
	}

	public Todo(Todo todo) {
		this.id = todo.id;
		this.title = todo.title;
		this.isCompleted = todo.isCompleted;
		this.createdAt = todo.createdAt;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", isCompleted=" + isCompleted + ", createdAt=" + createdAt
				+ "]";
	}
}
