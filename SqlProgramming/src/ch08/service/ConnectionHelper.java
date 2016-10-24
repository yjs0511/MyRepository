package ch08.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
}
