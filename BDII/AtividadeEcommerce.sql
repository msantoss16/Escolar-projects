CREATE DATABASE ECOMMERCE;

CREATE TABLE CLIENTES
(
id INT PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL,
email VARCHAR(50),
cpf VARCHAR(17) NOT NULL,
endereco VARCHAR(100),
telefone CHAR(15),
dataNasci DATETIME,
);

CREATE TABLE PEDIDOS
(
id INT PRIMARY KEY NOT NULL,
tipoPagamento VARCHAR(12) NOT NULL,
dataCompra DATETIME NOT NULL,
fornecedor VARCHAR(100) NOT NULL,
cpDesconto VARCHAR(10),
frete DECIMAl NOT NULL,
);

CREATE TABLE ITENS_PEDIDOS
(
codigo INT PRIMARY KEY NOT NULL,
quantidade INT NOT NULL,
valor DECIMAL NOT NULL,
);

CREATE TABLE PRODUTOS
(
codigo INT PRIMARY KEY NOT NULL,
marca VARCHAR(30) NOT NULL,
modelo VARCHAR(20) NOT NULL,
descricao VARCHAR(200),
cor VARCHAR(20),
valor DECIMAL NOT NULL,
estoque INT,
);
