class PythonCRUD:
    def getConnection(self):
        import mysql.connector

        return mysql.connector.connect(
                host="localhost",
                user="root",
                password="",
                database="pythoncrud"
        )

