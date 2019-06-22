package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.model.Publisher;

public class Book_Repository {
	
	public void save(Book book) {
		Connection connection=null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into book(isbn,title,price,publisher_id) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getPublisher_id());

			int count = ps.executeUpdate();
			if (count == 1)
				System.out.println("New record inserted");
			else {
				System.out.println("failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	Optional<Book> findById(int isbn) {
		return null;
	}

	void delete(int isbn) {
	}

	void update(int id, double price) {
	}

	List<Book> findAl() {
		return null;
	}

}
