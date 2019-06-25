package com.wissen.store;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wissen.dto.Todo;

public class TodoStore {

	private Map<Integer, Todo> todos = new HashMap<>();

	private static TodoStore todoStore = new TodoStore();

	private int counter = 0;

	private TodoStore() {

	}

	public static TodoStore getInstance() {
		return todoStore;
	}

	public Todo get(int id) {
		return new Todo(todos.get(id));
	}

	public void put(int id, Todo todo) {
		this.todos.put(id, todo);
	}

	public Todo delete(int id) {
		return this.todos.remove(id);
	}

	public int nextKey() {
		return counter + 1;
	}

	public Todo put(String title) {
		Todo todo = new Todo(this.nextKey(), title, false, LocalDateTime.now());
		this.todos.put(todo.getId(), todo);
		return todo;
	}

	public void put(Todo todo) {
		this.put(todo.getId(), todo);
	}
	
	public void perform(Function<Todo, Todo> func) {
		this.todos = this.todos.entrySet()
							.stream()
							.map(entry->entry.getValue())
							.map(func)
							.collect(Collectors.toMap(todo->todo.getId(), todo->todo));
	}
	
	public int clear(Predicate<Todo> pred) {
		int beforeDeletionSize = this.todos.size();
		this.todos = this.todos.entrySet()
							.stream()
							.map(entry->entry.getValue())
							.filter(pred)
							.collect(Collectors.toMap(todo->todo.getId(), todo->todo));
		
		return beforeDeletionSize - this.todos.size();
	}
	
	public List<Todo> filter(Predicate<Todo> pred) {
		return this.todos.values().stream()
							.filter(pred)
							.collect(Collectors.toList());
	}
	
	public Stream<Todo> getStream(){
		return this.todos.values().stream();
	}
}
