package Default;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	
	public static Connection getConnection()throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/hotel_booking";
			String username = "KVR";
			String password ="Allisone@1";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is made");
			return con;
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	
	}

}
