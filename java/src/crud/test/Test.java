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

	public void read(){
		for(Person tmp : new PersonDao().read()){
			System.out.println("id:"+tmp.getId());
			System.out.println("first name:"+tmp.getFirstName());
			System.out.println("last name:"+tmp.getLastName());
			System.out.println("email:"+tmp.getEmail());
			System.out.println("");
		}
	}

	public void update(){
		Person toUpdate = new PersonDao().read().get(0);

		toUpdate.setFirstName("admin");
		toUpdate.setLastName("admin");
		toUpdate.setEmail("admin@admin");

		if(new PersonDao().update(toUpdate)){
			System.out.println("updated data");
			System.out.println("id:"+toUpdate.getId());
			System.out.println("first name:"+toUpdate.getFirstName());
			System.out.println("last name:"+toUpdate.getLastName());
			System.out.println("email:"+toUpdate.getEmail());
			System.out.println("");
	
		}else{
			System.out.println("cant update");
		}
	}

	public void delete(){
		Person toDelete = new PersonDao().read().get(0);
		if(new PersonDao().delete(toDelete)){
			System.out.println("person with id:"+toDelete.getId()+" and email:"+toDelete.getEmail()+" deleted");	
		}else{
			System.out.println("error!!");
		}
	}

	public static void main(String[]args){
		System.out.println("");	
		System.out.println("connect:");
		new Test().connect();
		
		System.out.println("");	
		System.out.println("create:");
		new Test().create();
		
		System.out.println("");	
		System.out.println("read:");
		new Test().read();
		
		System.out.println("");	
		System.out.println("update:");
		new Test().update();
		
		System.out.println("");	
		System.out.println("delete:");
		new Test().delete();
	}
}
