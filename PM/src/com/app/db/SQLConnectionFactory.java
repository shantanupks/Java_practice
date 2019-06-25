package com.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnectionFactory {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// factory method
	public static Connection getConnection() throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String user = "hr";
		String password = "hr";

		return DriverManager.getConnection(url, user, password);

	}

}
