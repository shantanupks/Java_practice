package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.app.db.SQLConnectionFactory;
import com.app.model.Publisher;


public class Publisher_Repository {
	
	public void save(Publisher publisher) {
		Connection connection=null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into publisher(id,name) values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, publisher.getId());
			ps.setString(2, publisher.getName());

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


}
