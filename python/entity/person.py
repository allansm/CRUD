class Person:
    __id = None
    __firstName = None
    __lastName = None
    __email = None

    def setId(self,id):
        self.__id = id

    def setFirstName(self,firstName):
        self.__firstName = firstName

    def setLastName(self,lastName):
        self.__lastName = lastName

    def setEmail(self,email):
        self.__email = email
    
    def getId(self):
        return self.__id
    
    def getFirstName(self):
        return self.__firstName

    def getLastName(self):
        return self.__lastName

    def getEmail(self):
        return self.__email

