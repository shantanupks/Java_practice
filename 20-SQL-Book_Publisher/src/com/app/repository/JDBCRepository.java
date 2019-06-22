package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.model.Chapter;
import com.app.model.Publisher;

public class JDBCRepository implements Needed_Functionality{

	@Override
	public List<Book> getBooksFromPublisher(int id) {
		
		Connection connection=null;
		List<Book> list = new ArrayList<Book>();
		
		try {
			connection = SQLConnectionFactory.getConnection();
			String sql = "select * from book where publisher_id in( select id from publisher where id=?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisher_id(rs.getInt("publisher_id"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Chapter> getChapterFromBooks(int isbn) {
		Connection connection=null;
		List<Chapter> list = new ArrayList<>();
		
		try {
			connection = SQLConnectionFactory.getConnection();
			String sql = "select * from chapter where book_isbn in( select isbn from book where isbn=?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, isbn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Chapter chapter = new Chapter();
				chapter.setBook_isbn(rs.getInt("book_isbn"));
				chapter.setIndex(rs.getInt("index_no"));
				chapter.setPages(rs.getInt("pages"));
				chapter.setTitle(rs.getString("title"));
				list.add(chapter);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

}
