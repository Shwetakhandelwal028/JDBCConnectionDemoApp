package com.shweta.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSetup {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ecommercedb";
		String user = "root";
		String password = "root";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		
		try {
			
			// 1. Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Create Connection
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. Create query
			String query = "select * from eproduct";
			
			// 4. Create a statement
			stmt = conn.createStatement();
			
			// 5. Execute query
			rst = stmt.executeQuery(query);
			
			while(rst.next()) {
				System.out.println("--------------------------------------");
				System.out.println(rst.getInt(1) + " " + rst.getString(2) + " " + rst.getDouble(3));
			}
			
		}catch(Exception e) {
			
		}finally {
			rst.close();
			stmt.close();
			conn.close();
		}

	}

}
