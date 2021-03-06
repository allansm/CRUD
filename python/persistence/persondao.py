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

    def read(self, connection):
        from entity.person import Person

        stmt = connection.cursor()

        sql = "SELECT * FROM person"

        stmt.execute(sql)
        results = stmt.fetchall()

        stmt.close()
        connection.close()
        
        list = []
        for result in results:
            person = Person()
            
            person.setId(result[0])
            person.setFirstName(result[1])
            person.setLastName(result[2])
            person.setEmail(result[3])
            
            list.append(person)
        
        return list

    def update(self,connection,person):
        stmt = connection.cursor()

        sql = "UPDATE person SET firstName = %s, lastName = %s, email = %s WHERE id = %s"
        
        data = (
            person.getFirstName(),
            person.getLastName(),
            person.getEmail(),
            person.getId()
        )

        stmt.execute(sql,data)
        
        connection.commit()

        stmt.close()
        connection.close()
    
    def delete(self,connection,person):
        stmt = connection.cursor()

        sql = "DELETE FROM person WHERE id = %s"

        data = (person.getId(),)

        stmt.execute(sql,data)
        connection.commit()

        stmt.close()
        connection.close()

