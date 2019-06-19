package com.app.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.model.Todo;

public class TodoService {
	
	List<Todo> exist = Arrays.asList(
			new Todo(1,"title1",false,LocalDateTime.of(2018, 11, 10, 10, 10)),
			new Todo(2,"title2",false,LocalDateTime.of(2014, 11, 9, 10, 10)),
			new Todo(3,"title3",false,LocalDateTime.of(2016, 11, 8, 10, 10)),
			new Todo(4,"title4",false,LocalDateTime.of(2011, 11, 20, 10, 10)),
			new Todo(5,"title5",false,LocalDateTime.now())
			);
	List<Todo> todos = new ArrayList<Todo>();
//	
	
//	Todo exist1 = new Todo(1,"title1",false,LocalDateTime.of(2018, 11, 10, 10, 10));
//	Todo exist2 = new Todo(2,"title2",false,LocalDateTime.of(2014, 11, 9, 10, 10));
//	Todo exist3 = new Todo(3,"title3",false,LocalDateTime.of(2016, 11, 8, 10, 10));
//	Todo exist4 = new Todo(4,"title4",false,LocalDateTime.of(2011, 11, 20, 10, 10));
//	Todo exist5 = new Todo(5,"title5",false,LocalDateTime.now());
	static int id=1;

			
//	Set<Todo> exist = new HashSet<Todo>();
//	Set<Todo> todos = new HashSet<Todo>();

//	public void add() {
//		exist.add(exist1);
//		exist.add(exist2);
//		exist.add(exist3);
//		exist.add(exist4);
//		exist.add(exist5);
//		
//		//System.out.println(exist);
//
//	}
	
	public void showTodo() {
		
		todos
		.stream()
		.forEach(System.out::println);
	}
	
	
	public void addTodoGood(String title) {
		
			Todo t = new Todo(id++, title, false, LocalDateTime.now()) ;
			todos.add(t);
		}
	
	
	public void addTodo(String title) {
		
		for(Todo todo : exist) {
			if(todo.getTitle()==title) {
				todos.add(todo);
			}
		}
	}

	public void editTodo(int id, String newTitle) {
		
		todos.replaceAll(item->{
			if(item.getId()==id) {
				item.setTitle(newTitle);
			}
			return item;
		});
		
		
//		
//		.stream()
//		.filter(item->item.getId()==id)
//		.forEach(item->item.setTitle(newTitle));
	}

	public boolean deleteTodo(int id) {		
		if(todos.removeIf(item->item.getId()==id))
		{
			return true;
		}
		
		return false;

	}
	
	public void completeTodo(int id) {
		todos.replaceAll(item->{
			if(item.getId()==id) {
				item.setCompleted(true);
			}
			return item;
		});
//		.stream()
//		.filter(item->item.getId()==id)
//		.forEach(item->item.setCompleted(true));
	}
	
	public void completeAll() {
		todos.replaceAll(item->{
			item.setCompleted(!item.isCompleted());
			return item;
		});
//		.stream()
//		.forEach(item->item.setCompleted(item.isCompleted()));
	
	}
	public int clearCompleted() {		
		
		int i = (int) todos
				.stream()
				.filter(item->item.isCompleted()==true)
				.count();
		
			todos.removeIf(item->item.isCompleted()==true);

			return i;
	}
	
	public List<Todo> filter(Predicate<Todo> predicate){
		return 
			 todos.
				stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	
	public List<Todo> sort(Comparator<Todo> com){
		return todos
				.stream()
				.sorted(com)
				.collect(Collectors.toList());
		
	}

		

}
