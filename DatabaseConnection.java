package Translationapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String URL="jdbc:mysql://localhost:3306/word_db";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}

}
