package persistence;

import connection.DbConnection;
import entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

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
			connection.close();

			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<Person> read(){
		List<Person> list = new ArrayList<Person>();
		try{
			String sql = "select * from person";

			Connection connection = this.con.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Person tmp = new Person();
				
				tmp.setId(rs.getInt("id"));
				tmp.setFirstName(rs.getString("firstName"));
				tmp.setLastName(rs.getString("lastName"));
				tmp.setEmail(rs.getString("email"));
				
				list.add(tmp);
			}
			rs.close();
			stmt.close();
			connection.close();
		}catch(Exception e){}

		return list;
	}

	public boolean delete(Person person){
		try{
			String sql = "delete from person where id=?";
			Connection connection = this.con.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1,person.getId());
			
			stmt.execute();
			stmt.close();
			connection.close();

			return true; 
		}catch(Exception e){	
			return false;
		}
	}
}
