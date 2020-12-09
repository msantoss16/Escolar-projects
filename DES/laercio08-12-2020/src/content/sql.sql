create database dbCadClientes;
use dbCadClientes;

create table tbcliente (
    id int not null auto_increment,
    nome varchar(30),
    telResidencial varchar(8),
    telComercial varchar(8),
    telCelular varchar(9),
    email varchar(100),
    primary key(id)
);

create table tbempresa (
    codigo varchar(20) not null,
    nomeEmpresa varchar(30),
    cnpj varchar(14),
    razaoSocial varchar(14),
    primary key(codigo)
);