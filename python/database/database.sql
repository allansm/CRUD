create database pythoncrud;

use pythoncrud;

create table person(
	id bigint not null auto_increment primary key,
	firstName varchar(50) not null,
	lastName varchar(50) not null,
	email varchar(255) not null unique
)engine=innoDB;
