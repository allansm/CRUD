package test;

import connection.Conn;
import java.sql.Connection;

public class Test{
	public static void main(String[]args){
		Connection con = new Conn().getConnection();	
	}
}
