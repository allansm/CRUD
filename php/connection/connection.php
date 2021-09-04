<?php
	class Connection{
		public function getConnection(){
			$con = mysqli_connect("localhost","root","","phpcrud") or die("no connection.");
			return $con;	
		}
	}
?>
