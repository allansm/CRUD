package connection;

import connection.DbConnection;
import java.sql.Connection;
import entity.Person;
import persistence.PersonDao;

public class Test{
	
	public void connect(){
		DbConnection con = new DbConnection();
		Connection connection = con.getConnection();
		if(connection != null){
			System.out.println("connected");
		}else{
			System.out.println("no connection");
		}
	}

	public void create(){
		Person person = new Person();
		person.setFirstName("allan");
		person.setLastName("sm");
		person.setEmail("fake@email.com");

		if(new PersonDao().create(person)){
			System.out.println("sucess");
		}else{
			System.out.println("fail");
		}
	}

	public static void main(String[]args){
		new Test().connect();
		new Test().create();
	}
}
