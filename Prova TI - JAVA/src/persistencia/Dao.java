package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	Connection conn; 
	PreparedStatement stmt; 
	ResultSet rs; 
	
	public void open()throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daniel_bd","root","");
	}
	public void close()throws Exception{
		conn.close();
	}
	
	public static void main(String[] args) {
		
		try {
			
			Dao d = new Dao();
			d.open();
			d.close();
			System.out.println("Connected.......");
			
		} catch (Exception e) {
			System.out.println("Problem Connection.......");
			e.printStackTrace(); 
			}
	}
}
