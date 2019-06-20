package com.app.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {

	Map<String, List<Todo>> todoMap = new HashMap<String, List<Todo>>();

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
//	public void showTodo() {
//
//		todos.stream().forEach(System.out::println);
//	}

	public void addTodo(String user, String title) {
		Todo todo = new Todo(atomicInteger.incrementAndGet(), title);
		List<Todo> todos = todoMap.get(user);
		
		if(todos==null) {
			todos = new ArrayList<>();
			todos.add(todo);
			todoMap.put(user, todos);
		
		}else {
			todos.add(todo);
		}

	}

	public void editTodo(String user, int id, String newTitle) {
		List<Todo> todos = todoMap.get(user);

		todos.replaceAll(item -> {
			if (item.getId() == id) {
				item.setTitle(newTitle);
			}
			return item;
		});

//		
//		.stream()
//		.filter(item->item.getId()==id)
//		.forEach(item->item.setTitle(newTitle));
	}

	public boolean deleteTodo(String user, int id) {
		List<Todo> todos = todoMap.get(user);
		if (todos.removeIf(item -> item.getId() == id)) {
			return true;
		}

		return false;

	}

	public void completeTodo(String user,int id) {
		List<Todo> todos = todoMap.get(user);
		todos.replaceAll(item -> {
			if (item.getId() == id) {
				item.setCompleted(true);
			}
			return item;
		});
//		.stream()
//		.filter(item->item.getId()==id)
//		.forEach(item->item.setCompleted(true));
	}

	public void completeAll(String user) {
		List<Todo> todos = todoMap.get(user);
		todos.replaceAll(item -> {
			item.setCompleted(!item.isCompleted());
			return item;
		});
//		.stream()
//		.forEach(item->item.setCompleted(item.isCompleted()));

	}

	public int clearCompleted(String user) {
		List<Todo> todos = todoMap.get(user);

		int i = (int) todos.stream().filter(item -> item.isCompleted()).count();

		todos.removeIf(item -> item.isCompleted() == true);

		return i;
	}

	public List<Todo> filter(String user, String filter) {
		List<Todo> todos = todoMap.get(user);
		Predicate<Todo> predicate = null;

		switch (filter) {
		case "ALL":
			return todos;
		case "Completed":
			predicate = item -> item.isCompleted();
		case "Active":
			predicate = item -> !item.isCompleted();

		default:
			break;
		}

		return todos.stream().filter(predicate).collect(Collectors.toList());

	}

	public List<Todo> sort(String user, String property) {
		List<Todo> todos = todoMap.get(user);

		Comparator<Todo> com1 = null;

		switch (property) {
		case "id":
			com1 = Comparator.comparingInt(Todo::getId);
			break;
		case "title":
			com1 = Comparator.comparing(Todo::getTitle);

		default:
			break;

		}
		return todos.stream().sorted(com1).collect(Collectors.toList());

	}

}
