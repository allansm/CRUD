def connection():
    from connection.pythoncrud import PythonCRUD

    connection = PythonCRUD().getConnection();

    print("connected.")
    connection.close()

def create():
    from entity.person import Person
    from connection.pythoncrud import PythonCRUD
    from persistence.persondao import PersonDao

    firstname = input("First Name:")
    lastname = input("Last Name:")
    email = input("Email:")

    person = Person()

    person.setFirstName(firstname)
    person.setLastName(lastname)
    person.setEmail(email)
    
    try:
        PersonDao().create(PythonCRUD().getConnection(),person)
        print("ok")
    except:
        print("fail")

connection()
create()
