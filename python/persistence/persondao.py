class PersonDao:
    def create(self, connection, person):
        stmt = connection.cursor()
        
        sql = "INSERT INTO person (firstName, lastName, email) values (%s, %s, %s)"
        
        data = (
            person.getFirstName(),
            person.getLastName(),
            person.getEmail()
        )

        stmt.execute(sql, data)

        connection.commit()

        stmt.close()
        connection.close()
