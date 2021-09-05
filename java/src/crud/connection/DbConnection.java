package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection{
	public Connection getConnection(){
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
		}catch(Exception e){
			System.out.println("error!!");
			return null;
		}
	}
}
