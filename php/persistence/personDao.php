<?php
	class personDao{
		public function create($connection,$person){
			$sql = "insert into person(firstName,lastName,email) values ('".$person-firstName>."','".$person->lastName."','".$person->email."')";
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

				$person->id = $row["id"];
				$person->firstName = $row["firstName"];
				$person->lastName = $row["lastName"];
				$person->email = $row["email"];

				array_push($list,$person);
			}

			$connection->close();
			return $list;
		}

		public function update($connection,$person){
			$sql = "update person set firstName='".$person->firstName."',set lastName='".$person->lastname."',set email='".$person->email."' where id='".$person->id."'";
			
			(mysqli_query($connection,$sql))?$query = true:$query = false;
			
			$connection->close();
			return $query;
		}

		public function delete($connection,$person){
			$sql = "delete from person where id=".$person->id;

			(mysqli_query($connection,$sql))?$query = true:$query = false;
			
			$connection->close();
			return $query;
		}
	}
?>
