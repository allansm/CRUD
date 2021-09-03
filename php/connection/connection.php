<?php
	class Connection{
		public function getConnection(){
			return mysqli_connect("localhost","root","","phpcrud") or die("no connection.");		
		}
	}
?>
