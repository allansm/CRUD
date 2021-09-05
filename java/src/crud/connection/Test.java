package connection;

import java.sql.Connection;

public class Test{
	public static void main(String[]args){
		DbConnection con = new DbConnection();
		Connection connection = con.getConnection();
		if(connection != null){
			System.out.println("connected");
		}else{
			System.out.println("no connection");
		}
	}
}
