def connection():
    from connection.pythoncrud import PythonCRUD

    connection = PythonCRUD().getConnection();

    print("connected.")

connection()
