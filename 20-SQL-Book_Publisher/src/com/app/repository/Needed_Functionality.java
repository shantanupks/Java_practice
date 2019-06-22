package com.app.repository;

import java.util.List;

import com.app.model.Book;
import com.app.model.Chapter;

public interface Needed_Functionality {
	public List<Book> getBooksFromPublisher(int id);
	public List<Chapter> getChapterFromBooks(int isbn);

}
