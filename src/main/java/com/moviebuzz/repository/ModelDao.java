/**
 * 
 */
package com.moviebuzz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author SrimanthChinta
 *
 */
public class ModelDao {
	
	
	static Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3306/moviebuzz";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	
	/**
	 * 
	 * @return connection
	 */
	public static Connection openConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	
	/**
	 * void 
	 */
	
	public static void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
