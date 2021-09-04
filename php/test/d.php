<?php

include("../connection/connection.php");
include("../entity/person.php");
include("../persistence/personDao.php");

$con    = new Connection();
$person = new Person();

$person->setId(1);


$dao = new PersonDao();

$bool = $dao->delete($con->getConnection(),$person);


