package persistence;

import connection.DbConnection;
import entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonDao{
	private DbConnection con;

	public PersonDao(){
		this.con = new DbConnection();
	}

	public boolean create(Person person){
		try{
			String sql = "insert into person (firstName,lastName,email) values (?,?,?)";
			Connection connection = this.con.getConnection();

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,person.getFirstName());
			stmt.setString(2,person.getLastName());
			stmt.setString(3,person.getEmail());
			
			stmt.execute();
			stmt.close();

			return true;
		}catch(Exception e){
			return false;
		}
	}
}
