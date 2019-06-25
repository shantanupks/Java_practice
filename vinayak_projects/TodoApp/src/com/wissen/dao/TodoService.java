package com.wissen.dao;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.wissen.dto.Todo;
import com.wissen.store.TodoStore;

public class TodoService {

	private TodoStore store;

	private Map<String, Comparator<Todo>> comparators;
	private Map<String, Predicate<Todo>> filters;

	TodoService() {
		this.store = TodoStore.getInstance();
		this.comparators = new HashMap<>();
		this.filters = new HashMap<>();
		
		comparators.put("id", (t1, t2) -> Integer.compare(t1.getId(), t2.getId()));
		comparators.put("title", (t1, t2) -> t1.getTitle().compareTo(t2.getTitle()));
		comparators.put("date", (t1, t2) -> t1.getCreatedAt().compareTo(t2.getCreatedAt()));

		filters.put("active", todo -> !todo.isCompleted());
		filters.put("completed", todo -> todo.isCompleted());
		filters.put("date", todo -> todo.getCreatedAt().compareTo(LocalDateTime.now()) > 0);
		filters.put("all", this.filters.values().stream().reduce(todo -> true, (p1, p2) -> p1.and(p2)));

	}

	public Todo get(int id) {
		return this.store.get(id);
	}

	public void add(Todo todo) {
		this.store.put(todo);
	}

	public Todo addTodo(String title) {
		return this.store.put(title);
	}

	public void editTodo(int id, String newTitle) {
		Todo todo = this.store.get(id);

		todo.setTitle(newTitle);
		this.store.put(todo);
	}

	public boolean deleteTodo(int id) {
		Todo removedTodo = this.store.delete(id);
		return removedTodo != null;
	}

	public void completeTodo(int id) {
		Todo todo = this.store.get(id);

		// Toggle completion
		todo.setCompleted(!todo.isCompleted());
		this.store.put(todo);
	}

	public void completeAll() {
		this.store.perform(todo -> {
			todo.setCompleted(todo.isCompleted());
			return todo;
		});
	}

	public int clearCompleted() {
		return this.store.clear(todo -> !todo.isCompleted());
	}

	public List<Todo> filterBy(String key) {
		return this.store.filter(this.filters.getOrDefault(key, todo -> true));
	}

	public List<Todo> sortBy(String key) {
		return this.store.getStream().sorted(this.comparators.getOrDefault(key, (t1, t2) -> 0))
				.collect(Collectors.toList());
	}

}
