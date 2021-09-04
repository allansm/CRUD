<?php

include("../connection/connection.php");
include("../entity/person.php");
include("../persistence/personDao.php");

$con    = new Connection();
$person = new Person();

$person->setId($_GET["i"]);
$person->setFirstName($_GET["fn"]);
$person->setLastName($_GET["ln"]);
$person->setEmail($_GET["em"]);



$dao = new PersonDao();

$bool = $dao->update($con->getConnection(),$person);

echo $bool;
