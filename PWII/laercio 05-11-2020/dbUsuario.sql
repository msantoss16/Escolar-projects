drop database dbUsuarios;

create database dbUsuarios;

use dbUsuarios;

Create table tbUsuarios (
codUsu int not null auto_increment,
nomeUsu varchar(50),
loginUsu varchar(30) unique,
senhaUsu varchar(40),
nivelAcesso char(2),
primary key (codUsu));

INSERT INTO tbUsuarios(nomeUsu,loginUsu,nivelAcesso,senhaUsu)VALUES('admin','admin','2','admin')

