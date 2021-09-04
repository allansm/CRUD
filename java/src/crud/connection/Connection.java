package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection{
	public java.sql.Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		}catch(Exception e){
			return null;
		}
	}
}
