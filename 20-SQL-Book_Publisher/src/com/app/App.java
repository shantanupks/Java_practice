package com.app;

import com.app.model.Book;
import com.app.model.Chapter;
import com.app.model.Publisher;
import com.app.repository.Book_Repository;
import com.app.repository.Chapter_Repository;
import com.app.repository.JDBCRepository;
import com.app.repository.Publisher_Repository;

public class App {
	public static void main(String[] args) {
		

	Publisher_Repository publisher_Repository = new Publisher_Repository();
	Book_Repository book_Repository = new Book_Repository();
	Chapter_Repository chapter_Repository = new Chapter_Repository();
	JDBCRepository jdbcRepository = new JDBCRepository();

//	Publisher publisher1 = new Publisher(1, "A");
//	Publisher publisher2 = new Publisher(2, "B");
//	
//	publisher_Repository.save(publisher1);
//	publisher_Repository.save(publisher2);
	
//	Book book1 = new Book(101, "Book1", 200, 1);
//	Book book2 = new Book(102, "Book2", 300, 1);
//	Book book3 = new Book(103, "Book3", 400, 1);
//	Book book4 = new Book(104, "Book4", 100, 2);
//	Book book5 = new Book(105, "Book5", 500, 2);
	
	
//	book_Repository.save(book1);
//	book_Repository.save(book2);
//	book_Repository.save(book3);
//	book_Repository.save(book4);
//	book_Repository.save(book5);
	
//	Chapter chapter1 = new Chapter(10, "chapter1", 10, 101);
//	Chapter chapter2 = new Chapter(20, "chapter2", 5, 101);
//	Chapter chapter3 = new Chapter(25, "chapter3", 10, 101);
//	Chapter chapter4 = new Chapter(10, "chapter1", 10, 102);
//	Chapter chapter5 = new Chapter(30, "chapter2", 20, 102);
//	Chapter chapter6 = new Chapter(10, "chapter1", 10, 103);
//	Chapter chapter7 = new Chapter(10, "chapter1", 10, 104);
//	Chapter chapter8 = new Chapter(10, "chapter1", 10, 105);
//
//	
//	chapter_Repository.save(chapter1);
//	chapter_Repository.save(chapter2);
//	chapter_Repository.save(chapter3);
//	chapter_Repository.save(chapter4);
//	chapter_Repository.save(chapter5);
//	chapter_Repository.save(chapter6);
//	chapter_Repository.save(chapter7);
//	chapter_Repository.save(chapter8);
	
	jdbcRepository.getBooksFromPublisher(1)
	.forEach(System.out::println);
	
	jdbcRepository.getChapterFromBooks(101)
	.forEach(System.out::println);
	
	
	}

}
