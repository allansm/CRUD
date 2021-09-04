<?php
	class personDao{
		public function create($connection,$person){
			$sql = "insert into person(firstName,lastName,email) values ('".$person->getFirstName()."','".$person->getLastName()."','".$person->getEmail()."')";
			(mysqli_query($connection,$sql))?$query = true:$query = false;
			
			$connection->close();
			return $query;
		}

		public function read($connection){
			$sql = "select * from person";
			$result = mysqli_query($connection,$sql);
			$list = [];
			while($row = mysqli_fetch_assoc($result)){
				$person = new Person();

				$person->setId($row["id"]);
				$person->setFirstName($row["firstName"]);
				$person->setLastName($row["lastName"]);
				$person->setEmail($row["email"]);

				array_push($list,$person);
			}

			$connection->close();
			return $list;
		}

		public function update($connection,$person){
			$sql = "update person set firstName='".$person->getFirstName()."', lastName='".$person->getLastName()."' , email='".$person->getEmail()."' where id='".$person->getId()."'";
			echo $sql;

			(mysqli_query($connection,$sql))?$query = true:$query = false;
			
			$connection->close();
			return $query;
		}

		public function delete($connection,$person){
			$sql = "delete from person where id=".$person->getId();

			(mysqli_query($connection,$sql))?$query = true:$query = false;
			
			$connection->close();
			return $query;
		}
	}
?>
