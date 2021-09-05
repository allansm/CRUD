package persistence;

import connection.DbConnection;
import java.sql.Connection;

public class PersonDao{
	private Dbconnection con;

	public PersonDao(){
		this.con = new DbConnection();
	}

	public bool create(Person person){
		Connection = this.con.getConnection();	
	}
}
