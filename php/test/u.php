<?php

include("../connection/connection.php");
include("../entity/person.php");
include("../persistence/personDao.php");

$con    = new Connection();
$person = new Person();

$person->setId(1);
$person->setFirstName("admin");
$person->setLastName("admin");
$person->setEmail("admin@admin.com");


print_r($person);

$dao = new PersonDao();

$bool = $dao->update($con->getConnection(),$person);

echo $bool;
