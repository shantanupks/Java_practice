package com.wissen.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.wissen.dto.Todo;

class TodoServiceTest {

	private Stream<Todo> todoStream;
	private TodoService todoService;
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	{
		
		UnaryOperator<Todo> newObjectFromOld = todo -> new Todo(atomicInteger.incrementAndGet()
				,"title-"+atomicInteger.get()
				, Math.random()<0.5d
				, randomDate())
				;
		
		Todo seed = new Todo(0, 
				"title-1", 
				Math.random()<0.5d, 
				randomDate());
		
		todoStream = Stream.iterate(seed, newObjectFromOld);
		
	}

	{
		todoService = new TodoService();
	}
	
	private LocalDateTime randomDate() {
		return LocalDateTime.of(
						LocalDate.ofYearDay(2019, (int) (Math.random()*360))
						,LocalTime.of((int) (12*Math.random()), (int) (60*Math.random()) )
				);
	}

	@Test
	void testStream() {
		todoStream.limit(5).forEach(System.out::println);
	}
	
	@Test
	void testAddTitle() {
		 todoStream.limit(5).forEach(todo-> this.todoService.addTodo(todo.getTitle()) );
	}

	@Test
	void testAddTodo() {
		List<Todo> expected = this.todoStream.limit(5).collect(Collectors.toList());
		
		List<Todo> actual = expected.stream()
				.map(todo->  { 
					this.todoService.add(todo);
					return this.todoService.get(todo.getId());
				})
				.collect(Collectors.toList());
		
		assertEquals(expected, actual);
	}
	@Test
	void testEditTodo() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		List<String> expected = data.stream()
									.map(todo-> todo.getTitle()+"#")
									.collect(Collectors.toList());
		
		
		List<String> actual = data.stream()
				.map(todo->  { 
					this.todoService.add(todo);
					return this.todoService.get(todo.getId());
				})
				.map(todo-> { 
					todo.setTitle(todo.getTitle()+"#");
					return todo;
				})
				.map( todo -> { 
					this.todoService.editTodo(todo.getId(), todo.getTitle());
					return this.todoService.get(todo.getId()).getTitle();
				})
				.collect(Collectors.toList());
		
		assertEquals(expected, actual);
	}

	@Test
	void testDeleteTodo() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		boolean isFailure = data.stream()
				.map(todo->  { 
					this.todoService.add(todo);
					return this.todoService.get(todo.getId());
				})
				.map(todo-> this.todoService.deleteTodo(todo.getId()) )
				.peek(System.out::println)
				.anyMatch(res-> !res);
		
		assertFalse(isFailure);
	}

	@Test
	void testCompleteTodo() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		List<Todo> actual = data.stream()
				.map(todo->  { 
					this.todoService.add(todo);
					return this.todoService.get(todo.getId());
				})
				.map(todo->  { 
					this.todoService.completeTodo(todo.getId());
					return this.todoService.get(todo.getId());
				})
				.collect(Collectors.toList());
		
		Map<Integer, Boolean> expected = data.stream()
				.collect(Collectors.toMap(Todo::getId, Todo::isCompleted));
		
		for(Todo todo : actual)
			assertTrue( todo.isCompleted()!= expected.get(todo.getId()));
	}

	@Test
	void testClearCompleted() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
				
		long actualCleared = this.todoService.clearCompleted();
		long expected = data.stream().filter(todo-> todo.isCompleted()).count();
		
		assertEquals(expected, actualCleared);
	}

	@Test
	void testFilterByCompleted() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().filter(todo-> todo.isCompleted()).collect(Collectors.toList());
		List<Todo> actual = this.todoService.filterBy("completed");
		
		assertEquals(expected, actual);
	}

	
	@Test
	void testFilterByActive() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().filter(todo-> !todo.isCompleted()).collect(Collectors.toList());
		List<Todo> actual = this.todoService.filterBy("active");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFilterByDate() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().filter(todo-> todo.getCreatedAt().compareTo(LocalDateTime.now()) > 0).collect(Collectors.toList());
		List<Todo> actual = this.todoService.filterBy("date");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSortById() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().sorted((t1,t2)-> Integer.compare(t1.getId(), t2.getId())).collect(Collectors.toList());
		List<Todo> actual = this.todoService.sortBy("id");
		
		assertEquals(expected, actual);
	}

	@Test
	void testSortByTitle() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().sorted((t1, t2) -> t1.getTitle().compareTo(t2.getTitle())).collect(Collectors.toList());
		List<Todo> actual = this.todoService.sortBy("title");
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSortByDate() {
		List<Todo> data = this.todoStream.limit(5).collect(Collectors.toList());
		
		data.stream()
				.forEach(todo-> this.todoService.add(todo) );
		
		List<Todo> expected = data.stream().sorted((t1, t2) -> t1.getCreatedAt().compareTo(t2.getCreatedAt())).collect(Collectors.toList());
		List<Todo> actual = this.todoService.sortBy("date");
		
		assertEquals(expected, actual);
	}
}
