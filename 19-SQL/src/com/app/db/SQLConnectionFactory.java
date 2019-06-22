package com.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class SQLConnectionFactory {
	private static Properties properties = new Properties();
	
	static {
		try {
			FileInputStream fileInputStream = new FileInputStream("db.properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// step-1 : register JDBC driver
		//	DriverManager.registerDriver(new Driver());
		
		try {
			Class.forName(properties.getProperty("db.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
	}
	
	//factory method
	public static Connection getConnection() throws SQLException {
		
		String url = properties.getProperty("db.url");
		String user = properties.getProperty("db.user");
		String password = properties.getProperty("db.password");
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	
	
	

	

}
