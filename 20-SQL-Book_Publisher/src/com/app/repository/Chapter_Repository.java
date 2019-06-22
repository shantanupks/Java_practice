package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.model.Chapter;

public class Chapter_Repository {
	public void save(Chapter chapter) {
		Connection connection=null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into chapter(index_no,title,pages,book_isbn) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, chapter.getIndex());
			ps.setString(2, chapter.getTitle());
			ps.setDouble(3, chapter.getPages());
			ps.setInt(4, chapter.getBook_isbn());

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

//	Optional<Chapter> findById(int isbn);
//
//	void delete(int isbn);
//
//	void update(int id, double price);
//
//	List<Book> findAl();

}
