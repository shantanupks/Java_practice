package com.app;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.app.model.Todo;
import com.app.service.TodoService;

public class TodoApp {
	public static void main(String[] args) {
		
		TodoService todoService = new TodoService();

		
//		todoService.addTodoGood("title1");
//		todoService.addTodoGood("title1");
//		todoService.addTodoGood("title3");
//		todoService.addTodoGood("title2");
//		todoService.addTodoGood("title4");

		
//		todoService.editTodo(1, "title11");
//		//todoService.deleteTodo(1);
//		todoService.completeTodo(1);
//		todoService.completeTodo(4);
		
		//todoService.completeAll();

		
		//int i=todoService.clearCompleted();
		//System.out.println(i);
		
		//List<Todo> list=todoService.sortId();
		//List<Todo> list = todoService.sortTitle();
		//List<Todo> list = todoService.sortDate();

		
		//list.forEach(System.out::println);
		
		//todoService.completeAll();
//		Comparator<Todo> comId = (o1,o2)->Integer.compare(o1.getId(), o2.getId());
//		Comparator<Todo> comTitle = (o1,o2)->o1.getTitle().compareTo(o2.getTitle());
//		Comparator<Todo> comDate = (o1,o2)->o1.getDate().compareTo(o2.getDate());
//		
//		Predicate<Todo> predActive = e->e.isCompleted()==false;
//		Predicate<Todo> predCompleted = e->e.isCompleted()==true;		
//	
//		List<Todo> list= todoService.filter(predActive);
//		list.forEach(System.out::println);

//		List<Todo> list=todoService.sort(comId);
		//todoService.showTodo();
		

		
	}

}
