create database dbestacionamento;

use dbestacionamento;

create table tbcarro( placa char(7) not null, cor varchar(20), descricao varchar(100), primary key(placa));

create table tbUsuario( codUsu int not null auto_increment, nomeUsu varchar(20), senhaUsu varchar(20), privilegio int, primary key(codUsu));
