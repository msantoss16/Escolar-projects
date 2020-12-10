create database dbProdutos CHARACTER SET utf8 COLLATE utf8_general_ci;

use dbProdutos;

create table tbProdutos(
codPro int not null auto_increment,
nomePro varchar(100),
descricao varchar(100),
categoria varchar(15),
preco decimal(15,2),
primary key(codPro))ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;