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

def read():
    from connection.pythoncrud import PythonCRUD
    from persistence.persondao import PersonDao

    list = PersonDao().read(PythonCRUD().getConnection())
    for n in list:
        print("id:"+str(n.getId()))
        print("first name:"+n.getFirstName())
        print("last name:"+n.getLastName())
        print("email:"+n.getEmail()+"\n")

connection()
create()
read()
