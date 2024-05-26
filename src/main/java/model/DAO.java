package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/agenda";
	private String user = "root";
	private String password = "root";

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful!");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error connecting to the database: " + e.getMessage());
		}
		return con;
	}

	public void getConnection() {
		try (Connection con = connect()) {
			if (con != null) {
				System.out.println("Connection object: " + con);
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (Exception e) {
			System.out.println("Error during connection: " + e.getMessage());
		}
	}
}
