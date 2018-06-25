package controller.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String userName = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost/tourfirm";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Database connection complite");
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}

}
