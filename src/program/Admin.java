package program;

import java.sql.Connection;
import java.sql.DriverManager;

public class Admin {
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/movie_rental_system";
			String username = "root";
			String password = "1234";
				
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
				
		} catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	//INSERT INTO tablename2 select *, DATE_FORMAT(datetime, '%m/%d/%Y') from tablename1 WHERE datetime <= DATE_SUB(SYSDATE(), INTERVAL 30 DAY);

	//DELETE FROM tablename1 WHERE datetime <= DATE_SUB(SYSDATE(), INTERVAL 30 DAY);
	
}
