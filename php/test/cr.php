<?php

include("../connection/connection.php");
include("../entity/person.php");
include("../persistence/personDao.php");

$con    = new Connection();
$person = new Person();

$person->setFirstName($_POST["fn"]);
$person->setLastName($_POST["ln"]);
$person->setEmail($_POST["em"]);



$dao = new PersonDao();

$dao->create($con->getConnection(),$person);

$list = $dao->read($con->getConnection());

print_r($list);
