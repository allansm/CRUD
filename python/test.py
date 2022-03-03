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

def update():
    from connection.pythoncrud import PythonCRUD
    from persistence.persondao import PersonDao
    
    dao = PersonDao()
    
    before = dao.read(PythonCRUD().getConnection())[0]
    first = dao.read(PythonCRUD().getConnection())[0]

    first.setFirstName("ROOT")
    first.setLastName("")
    first.setEmail("root@root.com")

    dao.update(PythonCRUD().getConnection(),first)
    
    print("first name:"+before.getFirstName()+" >> "+first.getFirstName())
    print("last name:"+before.getLastName()+" >> "+first.getLastName())
    print("email:"+before.getEmail()+" >> "+first.getEmail()+"\n")

def delete():
    from connection.pythoncrud import PythonCRUD
    from persistence.persondao import PersonDao

    dao = PersonDao()
    list = dao.read(PythonCRUD().getConnection())

    for person in list:
        dao.delete(PythonCRUD().getConnection(),person)
        print("id:"+str(person.getId())+"\nfirst name:"+person.getFirstName()+"\ndeleted\n")

print("create test:")
create()
print("")
print("read test:")
read()
print("")
print("update test:")
update()
print("")
print("delete test:")
delete()
